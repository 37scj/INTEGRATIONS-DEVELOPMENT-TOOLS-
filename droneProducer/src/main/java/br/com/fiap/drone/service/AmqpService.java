package br.com.fiap.drone.service;

import br.com.fiap.drone.models.DroneData;

/**
 * Test Service
 */
public interface AmqpService {

    void sendToConsumer(DroneData droneData);

}
