package br.com.fiap.drone.service.impl;

import br.com.fiap.drone.dto.DroneDTO;
import br.com.fiap.drone.service.CheckSensorsService;
import br.com.fiap.drone.service.DroneService;
import br.com.fiap.drone.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckSensorsServiceImpl implements CheckSensorsService {

    Logger logger = LoggerFactory.getLogger(CheckSensorsServiceImpl.class);

    private final MailService mailService;
    private final DroneService droneService;

    CheckSensorsServiceImpl(MailService mailService,
                            DroneService droneService) {
        this.mailService = mailService;
        this.droneService = droneService;
    }

    @Override
    public void checkSensors() {
        logger.info("checking sensors");
        // TODO fazer busca na base de dados dos sensores, lendo o lidar  e validando a regra
        List<DroneDTO> drones = droneService.findAllDrone().stream()
                .filter(d -> (d.getTemperatura() >= 35. || d.getTemperatura() <= 0. || d.getUmidade() <= 15.))
                .collect(Collectors.toList());
        if (drones.size() > 0) {
            StringBuilder msgMail = new StringBuilder();
            msgMail
                    .append("Drones com temperatura abaixo de zero ou maior que 35 ou umidade menor que 15: " + drones.size() + "\n")
                    .append("\n\nLista de drones:");
            drones.forEach(d ->
                    msgMail.append("\nID DO DRONE: " + d.getId())
                            .append("\nLatitude: " + d.getLatitude())
                            .append("\nLongitude: " + d.getLongitude())
                            .append("\nTemperatura: " + d.getTemperatura())
                            .append("\nUmidade: " + d.getUmidade())
                            .append("\n"));
            logger.info("Enviando email");
            mailService.sendEmail(msgMail.toString());
        } else {
            logger.info("Sem Email para encaminhar");
        }

    }

}
