package br.com.fiap.drone.controller;

import br.com.fiap.drone.dto.DroneDTO;
import br.com.fiap.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("drones")
public class DroneController {

    @Autowired
    private DroneService droneService;

    /**
     * Cadastrar drone
     *
     * @param drone
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DroneDTO addDrone(@RequestBody DroneDTO drone) {
        return droneService.storeDroneInfo(drone);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DroneDTO patchDrone(@RequestBody DroneDTO drone) {
        if(drone.getId()!=null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Necessário ID do Drone");
        }
        return droneService.storeDroneInfo(drone);
    }

    /**
     * Localizar drone
     */
    @GetMapping()
    public List<DroneDTO> getAll() {
        return droneService.findAllDrone();
    }

}
