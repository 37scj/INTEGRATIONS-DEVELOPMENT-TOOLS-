package br.com.fiap.drone.repository;

import br.com.fiap.drone.entity.DroneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<DroneEntity, Long> {

}
