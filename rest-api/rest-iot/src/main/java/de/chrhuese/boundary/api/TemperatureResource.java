package de.chrhuese.boundary.api;

import de.chrhuese.boundary.TemperatureDTO;
import de.chrhuese.control.TemperatureConverter;
import de.chrhuese.control.TemperatureService;
import de.chrhuese.entity.Temperature;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/temperature")
public class TemperatureResource {

    @Inject
    public TemperatureService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTemperature() {
        TemperatureDTO lastTemperatureDTO = this.service.getLastTemperature();
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response pushTemperature(TemperatureDTO temperatureDTO) {
        if (this.service.createTemperature(temperatureDTO)) {
            return Response.ok(temperatureDTO).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
