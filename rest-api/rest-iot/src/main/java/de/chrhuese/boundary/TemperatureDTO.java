package de.chrhuese.boundary;

import de.chrhuese.entity.Temperature;

public class TemperatureDTO {

    private long id;
    private float temperature;
    private int sensorId;
    private long timestamp;

    // Standard-Konstruktor (erforderlich)
    public TemperatureDTO() {
    }

    // Getter und Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TemperatureDTO{" +
                "id=" + id +
                ", value=" + temperature +
                ", sensorId=" + sensorId +
                ", timestamp=" + timestamp +
                '}';
    }

    public static class Converter {

        public static TemperatureDTO toDTO(Temperature temperature) {
            TemperatureDTO dto = new TemperatureDTO();
            dto.setId(temperature.getId());
            dto.setTemperature(temperature.getTemperature());
            dto.setSensorId(temperature.getSensorId());
            dto.setTimestamp(temperature.getTimestamp());
            return dto;
        }

        public static Temperature fromDTO(TemperatureDTO dto) {
            Temperature temperature = new Temperature();
            temperature.setId(dto.getId());
            temperature.setTemperature(dto.getTemperature());
            temperature.setSensorId(dto.getSensorId());
            temperature.setTimestamp(dto.getTimestamp());
            return temperature;
        }
    }
}

