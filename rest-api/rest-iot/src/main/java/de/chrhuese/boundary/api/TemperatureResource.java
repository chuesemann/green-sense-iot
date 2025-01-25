package de.chrhuese.boundary.api;

import de.chrhuese.boundary.TemperatureDTO;
import de.chrhuese.control.TemperatureService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/temperature")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.REQUIRES_NEW)
@ApplicationScoped
public class TemperatureResource {

    @Inject
    public TemperatureService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTemperature() {
        Temperature lastTemperature;
        try {
            lastTemperature = this.service.getLastTemperature();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        TemperatureDTO lastTemperatureDTO = TemperatureDTO.Converter.toDTO(lastTemperature);
        return Response.ok(lastTemperatureDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response pushTemperature(TemperatureDTO temperatureDTO) {
        System.out.println(temperatureDTO);
        if (this.service.createTemperature(temperatureDTO)) {
            return Response.ok(temperatureDTO).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
