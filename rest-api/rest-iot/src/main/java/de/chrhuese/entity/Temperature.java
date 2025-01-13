package de.chrhuese.entity;

import jakarta.persistence.*;

@Entity
public class Temperature {

    private long id;
    private float temperature;
    private int sensorId;
    private long timestamp;

    public Temperature() {

    }

    @Id
    @SequenceGenerator(name = "temperatureSequence", sequenceName = "temperatureSeq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "temperatureSequence")
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

    public Temperature(long id, float temperature, long timestamp) {
        this.id = id;
        this.temperature = temperature;
        this.timestamp = timestamp;
    }
}
