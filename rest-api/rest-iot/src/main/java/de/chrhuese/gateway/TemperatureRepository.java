package de.chrhuese.gateway;

import de.chrhuese.boundary.TemperatureDTO;
import de.chrhuese.control.TemperatureConverter;
import de.chrhuese.entity.Temperature;
import de.chrhuese.entity.TemperatureKatalog;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;

import java.sql.SQLOutput;
import java.util.List;

@RequestScoped
public class TemperatureRepository implements TemperatureKatalog {

    @Inject
    EntityManager em;

    @Inject
    TemperatureConverter converter;

    @Override
    @Transactional
    public List<Temperature> getTemperatures() {
        return em.createQuery("select t from Temperature t", Temperature.class).setMaxResults(10).getResultList();
    }

    @Override
    @Transactional
    public Temperature getLastTemperature() {
        return em.createQuery("select t from Temperature t", Temperature.class).getSingleResult();
    }

    @Override
    public boolean createTemperature(Temperature newTemperature) {
        try {
            em.persist(temperature);
            em.flush();
            return true;
        } catch (PersistenceException e) {
            System.out.println("Error while persisting temperature: " + e.getMessage());;
            return false;
        }
    }
}
