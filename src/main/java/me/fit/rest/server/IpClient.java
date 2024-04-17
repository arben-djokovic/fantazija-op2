package me.fit.rest.server;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.rest.client.IpClientClient;

@Path("/api")
public class IpClient {
	@Inject
	@RestClient
	private IpClientClient IpClientClient;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getIpClient")
	public Response getIpClient() {
		me.fit.model.rest.client.IpClient ipClientRes =  IpClientClient.get();
		return Response.ok().entity(ipClientRes).build();
	}
}

