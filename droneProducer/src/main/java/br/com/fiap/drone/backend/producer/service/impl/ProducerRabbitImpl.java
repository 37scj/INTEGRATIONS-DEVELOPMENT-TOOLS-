package br.com.fiap.drone.backend.producer.service.impl;

import br.com.fiap.drone.backend.producer.models.DroneData;
import br.com.fiap.drone.backend.producer.service.AmqpProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerRabbitImpl implements AmqpProducer<DroneData> {

    private Logger logger = LoggerFactory.getLogger(ProducerRabbitImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routing-key}")
    private String queue;

    @Override
    public void producer(DroneData droneData) {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(droneData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        logger.info("Produzindo: " + json);
        try {

            rabbitTemplate.convertAndSend(exchange, queue, droneData);

        } catch (Exception e) {
            /**
             * Quando der Erro , sera enviada pela deadletter
             */
            throw new AmqpRejectAndDontRequeueException(e);
        }

    }

}
