package de.chrhuese.boundary;

public class SoilMoistureDTO {
    public long id;
    public int rawValue;
    public int percentValue;
    public int sensorId;
    public long timestamp;


    public SoilMoistureDTO() {
    }

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

    public static class Converter {

        public static SoilMoistureDTO toDTO(SoilMoisture soilMoisture) {
            SoilMoistureDTO dto = new SoilMoistureDTO();
            dto.id = soilMoisture.getId();
            dto.rawValue = soilMoisture.getRawValue();
            dto.percentValue = soilMoisture.getPercentValue();
            dto.sensorId = soilMoisture.getSensorId();
            dto.timestamp = soilMoisture.getTimestamp();
            return dto;
        }

        public static SoilMoisture fromDTO(SoilMoistureDTO dto) {
            SoilMoisture soilMoisture = new SoilMoisture();
            soilMoisture.setId(dto.getId());
            soilMoisture.setRawValue(dto.getRawValue());
            soilMoisture.setPercentValue(dto.getPercentValue());
            soilMoisture.setSensorId(dto.getSensorId());
            soilMoisture.setTimestamp(dto.getTimestamp());
            return soilMoisture;
        }
    }
}
