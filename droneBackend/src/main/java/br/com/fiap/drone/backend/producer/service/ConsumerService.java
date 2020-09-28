package br.com.fiap.drone.backend.producer.service;

import br.com.fiap.drone.backend.producer.dto.DroneDTO;

/**
 * Classe responsavel por receber a informacao consumida e realizar alguma acao no sistema
 *
 * @author lucasrodriguesdonascimento
 */
public interface ConsumerService {

    void receiveDroneInfo(DroneDTO drone);

}
