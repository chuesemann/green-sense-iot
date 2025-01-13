package de.chrhuese.control;

import de.chrhuese.boundary.TemperatureDTO;
import de.chrhuese.entity.Temperature;
import de.chrhuese.entity.TemperatureKatalog;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TemperatureService {

    @Inject
    private TemperatureKatalog katalog;

    @Inject
    private TemperatureConverter converter;


    @Transactional
    public TemperatureDTO getLastTemperature() {
        Temperature lastTemperature = katalog.getLastTemperature();
        return converter.toDTO(lastTemperature);
    }

    public List<TemperatureDTO> getTemperatures() {
        List<Temperature> temperatures = katalog.getTemperatures();
        List<TemperatureDTO> temperaturesDTO = new ArrayList<>();
        for (Temperature temperature : temperatures) {
            temperaturesDTO.add(converter.toDTO(temperature));
        }
        return temperaturesDTO;
    }

    @Transactional
    public boolean createTemperature(TemperatureDTO temperatureDTO) {
        try {
            katalog.createTemperature(temperatureDTO);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
