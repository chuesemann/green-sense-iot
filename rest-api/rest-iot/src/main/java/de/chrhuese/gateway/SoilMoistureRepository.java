package de.chrhuese.gateway;

import de.chrhuese.boundary.SoilMoistureDTO;
import de.chrhuese.entity.SoilMoisture;
import de.chrhuese.entity.SoilMoistureKatalog;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class SoilMoistureRepository implements SoilMoistureKatalog {

    @Inject
    EntityManager em;

    @Override
    public SoilMoisture getSoilMoisture() {
        return em.createQuery("select s from SoilMoisture s", SoilMoisture.class).getSingleResult();
    }

    @Override
    public boolean createSoilMoisture(SoilMoistureDTO soilMoistureDTO) {
        try {
            em.persist(soilMoistureDTO);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
