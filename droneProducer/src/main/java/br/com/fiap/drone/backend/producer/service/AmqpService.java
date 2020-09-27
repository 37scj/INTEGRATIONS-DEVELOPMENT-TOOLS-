package br.com.fiap.drone.backend.producer.service;

import br.com.fiap.drone.backend.producer.models.DroneData;

/**
 * Test Service
 */
public interface AmqpService {

    void sendToConsumer(DroneData droneData);

}
