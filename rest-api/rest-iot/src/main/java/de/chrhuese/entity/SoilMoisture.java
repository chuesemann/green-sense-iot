package de.chrhuese.entity;

import jakarta.persistence.*;

@Entity
public class SoilMoisture {

    private long id;
    private int rawValue;
    private int percentValue;
    private int sensorId;
    private long timestamp;

    public SoilMoisture() {

    }

    @Id
    @SequenceGenerator(name = "soilMoistureSequence", sequenceName = "soilMoistureSeq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "soilMoistureSequence")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRawValue() {
        return rawValue;
    }

    public void setRawValue(int rawValue) {
        this.rawValue = rawValue;
    }

    public int getPercentValue() {
        return percentValue;
    }

    public void setPercentValue(int percentValue) {
        this.percentValue = percentValue;
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


}
