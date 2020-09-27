package br.com.fiap.drone.service;

import br.com.fiap.drone.models.DroneData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitServiceImpl implements AmqpService {

    @Autowired
    private AmqpProducer<DroneData> amqp;

    @Override
    public void sendToConsumer(DroneData droneData) {
        amqp.producer(droneData);
    }

}
