package de.chrhuese.control;

import de.chrhuese.boundary.TemperatureDTO;
import de.chrhuese.entity.Temperature;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TemperatureConverter {

    public TemperatureDTO toDTO(Temperature temperature) {
        TemperatureDTO dto = new TemperatureDTO();
        dto.setId(temperature.getId());
        dto.setTemperature(temperature.getTemperature());
        dto.setSensorId(temperature.getSensorId());
        dto.setTimestamp(temperature.getTimestamp());
        return dto;
    }

    public Temperature fromDTO(TemperatureDTO dto) {
        Temperature temperature = new Temperature();
        temperature.setId(dto.getId());
        temperature.setTemperature(dto.getTemperature());
        temperature.setSensorId(dto.getSensorId());
        temperature.setTimestamp(dto.getTimestamp());
        return temperature;
    }
}
