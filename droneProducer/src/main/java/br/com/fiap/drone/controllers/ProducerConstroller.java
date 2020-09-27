package br.com.fiap.drone.controllers;

import br.com.fiap.drone.models.DroneData;
import br.com.fiap.drone.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerConstroller {


    @Autowired
    private AmqpService service;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/send")
    public void sendToConsumer(@RequestBody DroneData droneData) {
        service.sendToConsumer(droneData);
    }

}
