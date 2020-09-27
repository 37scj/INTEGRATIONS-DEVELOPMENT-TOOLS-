package br.com.fiap.drone.service;

import br.com.fiap.drone.dto.DroneDTO;

/**
 * Classe responsavel por receber a informacao consumida e realizar alguma acao no sistema
 *
 * @author lucasrodriguesdonascimento
 */
public interface ConsumerService {

    void receiveDroneInfo(DroneDTO drone);

}
