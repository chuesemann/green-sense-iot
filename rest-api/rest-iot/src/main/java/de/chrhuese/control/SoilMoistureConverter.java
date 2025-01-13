package de.chrhuese.control;

import de.chrhuese.boundary.SoilMoistureDTO;
import de.chrhuese.entity.SoilMoisture;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SoilMoistureConverter {
    public SoilMoistureDTO toDTO(SoilMoisture soilMoisture) {
        SoilMoistureDTO dto = new SoilMoistureDTO();
        dto.id = soilMoisture.getId();
        dto.rawValue = soilMoisture.getRawValue();
        dto.percentValue = soilMoisture.getPercentValue();
        dto.sensorId = soilMoisture.getSensorId();
        dto.timestamp = soilMoisture.getTimestamp();
        return dto;
    }
}
