package br.com.fiap.drone.backend.producer.service.impl;

import br.com.fiap.drone.backend.producer.models.DroneData;
import br.com.fiap.drone.backend.producer.service.AmqpProducer;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerRabbitImpl implements AmqpProducer<DroneData> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routing-key}")
    private String queue;

    @Override
    public void producer(DroneData droneData) {

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
