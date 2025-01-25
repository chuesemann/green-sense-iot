package de.chrhuese.control;

import de.chrhuese.boundary.TemperatureDTO;
import de.chrhuese.entity.Temperature;
import de.chrhuese.entity.TemperatureKatalog;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class TemperatureService {

    @Inject
    TemperatureKatalog katalog;


    @Transactional
    public TemperatureDTO getLastTemperature() {
        Temperature lastTemperature = katalog.getLastTemperature();
        return TemperatureDTO.Converter.toDTO(lastTemperature);
    }

    public List<TemperatureDTO> getTemperatures() {
        List<Temperature> temperatures = katalog.getTemperatures();
        List<TemperatureDTO> temperaturesDTO = new ArrayList<>();
        for (Temperature temperature : temperatures) {
            temperaturesDTO.add(TemperatureDTO.Converter.toDTO(temperature));
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
