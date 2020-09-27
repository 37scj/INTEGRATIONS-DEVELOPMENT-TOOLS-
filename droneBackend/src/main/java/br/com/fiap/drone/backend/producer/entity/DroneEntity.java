package br.com.fiap.drone.backend.producer.entity;

import br.com.fiap.drone.backend.producer.dto.DroneDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_DRONE")
public class DroneEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column
    private Double temperatura;

    @Column
    private Double umidade;


    public DroneEntity() {
        // TODO Auto-generated constructor stub
    }

    public DroneEntity(DroneDTO drone) {
        if(drone.getId()!=null) {
            this.setId(drone.getId());
        }
        this.setLatitude(drone.getLatitude());
        this.setLongitude(drone.getLongitude());
        this.setUmidade(drone.getUmidade());
        this.setTemperatura(drone.getTemperatura());

    }

    @Transient
    public DroneDTO toModel() {
        DroneDTO drone = new DroneDTO();
        drone.setId(this.getId());
        drone.setLatitude(this.getLatitude());
        drone.setLongitude(this.getLongitude());
        drone.setTemperatura(this.getTemperatura());
        drone.setUmidade(this.getUmidade());
        return drone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getUmidade() {
        return umidade;
    }

    public void setUmidade(Double umidade) {
        this.umidade = umidade;
    }
}
