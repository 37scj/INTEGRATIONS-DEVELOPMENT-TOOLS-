package br.com.fiap.drone.backend.producer.repository;

import br.com.fiap.drone.backend.producer.entity.DroneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<DroneEntity, Long> {

}
