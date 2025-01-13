package de.chrhuese.entity;

import de.chrhuese.boundary.TemperatureDTO;

import java.util.List;

public interface TemperatureKatalog {
    public Temperature getLastTemperature();
    public List<Temperature> getTemperatures();
    public boolean createTemperature(TemperatureDTO temperatureDTO);
}
