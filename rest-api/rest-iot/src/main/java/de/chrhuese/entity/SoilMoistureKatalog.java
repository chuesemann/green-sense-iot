package de.chrhuese.entity;

import de.chrhuese.boundary.SoilMoistureDTO;

public interface SoilMoistureKatalog {
    public SoilMoisture getSoilMoisture();
    public boolean createSoilMoisture(SoilMoistureDTO soilMoistureDTO);
}
