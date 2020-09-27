package br.com.fiap.drone.service;

import br.com.fiap.drone.dto.DroneDTO;

import java.util.List;

public interface DroneService {

    DroneDTO storeDroneInfo(DroneDTO dronePresenter);

    List<DroneDTO> findAllDrone();

}
