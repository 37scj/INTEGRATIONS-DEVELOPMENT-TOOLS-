package br.com.fiap.drone.backend.producer.service.impl;

import br.com.fiap.drone.backend.producer.dto.DroneDTO;
import br.com.fiap.drone.backend.producer.entity.DroneEntity;
import br.com.fiap.drone.backend.producer.repository.DroneRepository;
import br.com.fiap.drone.backend.producer.service.ConsumerService;
import br.com.fiap.drone.backend.producer.service.DroneService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@EnableAsync
@Service
public class DroneImpl implements DroneService {

    private final org.apache.logging.log4j.Logger logger = LogManager.getLogger(DroneImpl.class);

    @Autowired
    private DroneRepository droneRepository;

    /**
     * Cadastrando um drone
     */
    @Override
    public DroneDTO storeDroneInfo(final DroneDTO droneParameter) {
        logger.info("Drone Info " + droneParameter.getId());

        final DroneEntity drone = droneRepository.findById(droneParameter.getId()).orElse(new DroneEntity());

        if (drone.getId() != null) {
            drone.setId(drone.getId());
        }

        if (droneParameter.getLatitude() != null) {
            drone.setLatitude(droneParameter.getLatitude());
        }
        if (droneParameter.getLongitude() != null) {
            drone.setLongitude(droneParameter.getLongitude());
        }
        if (droneParameter.getUmidade() != null) {
            drone.setUmidade(droneParameter.getUmidade());
        }
        if (droneParameter.getTemperatura() != null) {
            drone.setTemperatura(droneParameter.getTemperatura());
        }

        final DroneEntity saveDrone = droneRepository.save(drone);

        logger.info("DRONE GRAVADO COM SUCESSO");

        return saveDrone.toModel();

    }

    @Override
    public List<DroneDTO> findAllDrone() {
        return droneRepository.findAll().stream().map(DroneDTO::new).collect(Collectors.toList());
    }

    @Override
    public void deleteById(final Long id) {
        droneRepository.deleteById(id);
    }

    @Override
    public Optional<DroneDTO> findById(final Long id) {
        return Optional.ofNullable(new DroneDTO(droneRepository.findById(id).orElse(null)));
    }

}
