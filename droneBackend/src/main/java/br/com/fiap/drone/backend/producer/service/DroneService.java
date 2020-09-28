package br.com.fiap.drone.backend.producer.service;

import br.com.fiap.drone.backend.producer.dto.DroneDTO;

import java.util.List;

public interface DroneService {

    DroneDTO storeDroneInfo(DroneDTO dronePresenter);

    List<DroneDTO> findAllDrone();

}
