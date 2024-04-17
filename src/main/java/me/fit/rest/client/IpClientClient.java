package me.fit.rest.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import me.fit.model.rest.client.IpClient;

@Path("/data")
@RegisterRestClient
public interface IpClientClient {

	@GET
	@Path("/client-ip")
	IpClient get();
	
}
