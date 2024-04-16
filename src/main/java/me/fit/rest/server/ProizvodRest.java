package me.fit.rest.server;

import java.util.List;

import org.jboss.resteasy.reactive.RestResponse.Status;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.exception.ProizvodException;
import me.fit.model.Proizvod;
import me.fit.service.ProizvodService;

@Path("/api/proizvod/")
public class ProizvodRest {

    @Inject
    private ProizvodService proizvodService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createProizvod")
    public Response createProizvod(Proizvod proizvod) {
        Proizvod p = null;
        try {
            p = proizvodService.createProizvod(proizvod);
        } catch (ProizvodException e) {
            return Response.status(Status.CONFLICT).entity(e.getMessage()).build();
        }
        return Response.ok().entity(p).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllProizvodi")
    public Response getAllProizvodi() {
        List<Proizvod> proizvodi = proizvodService.getAllProizvodi();
        return Response.ok().entity(proizvodi).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getProizvodiByIme")
    public Response getProizvodiByIme(@QueryParam(value = "ime") String ime) {
        List<Proizvod> proizvodi = proizvodService.getProizvodiByIme(ime);
        return Response.ok().entity(proizvodi).build();
    }
}
