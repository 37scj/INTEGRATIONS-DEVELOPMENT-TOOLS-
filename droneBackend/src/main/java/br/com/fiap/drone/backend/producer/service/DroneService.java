package br.com.fiap.drone.backend.producer.service;

import br.com.fiap.drone.backend.producer.dto.DroneDTO;

import java.util.List;
import java.util.Optional;

public interface DroneService {

    DroneDTO storeDroneInfo(DroneDTO dronePresenter);

    List<DroneDTO> findAllDrone();
    Optional<DroneDTO> findById(Long id);

	void deleteById(Long id);
}
