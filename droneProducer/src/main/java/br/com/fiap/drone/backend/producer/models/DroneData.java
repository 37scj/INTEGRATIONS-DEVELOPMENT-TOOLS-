package br.com.fiap.drone.backend.producer.models;

public class DroneData {

    private Long id;
    private Double latitude;
    private Double longitude;
    private Double temperatura;
    private Double umidade;

    public DroneData() {

    }

    public DroneData(Long id, Double latitude, Double longitude, Double temperatura, Double umidade) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperatura = temperatura;
        this.umidade = umidade;
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
