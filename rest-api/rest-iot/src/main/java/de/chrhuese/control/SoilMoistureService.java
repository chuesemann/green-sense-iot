package de.chrhuese.control;

import de.chrhuese.boundary.SoilMoistureDTO;
import de.chrhuese.entity.SoilMoisture;
import de.chrhuese.entity.SoilMoistureKatalog;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class SoilMoistureService {

    @Inject
    private SoilMoistureKatalog katalog;

    @Inject
    private EntityManager em;

    public SoilMoisture getSoilMoisture() {
        return katalog.getSoilMoisture();
    }

    public boolean createSoilMoisture(SoilMoistureDTO soilMoistureDTO) {
        try {
            katalog.createSoilMoisture(soilMoistureDTO);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
