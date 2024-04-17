package me.fit.scheduler;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.scheduler.Scheduled;
import jakarta.inject.Inject;
import me.fit.model.rest.client.IpClient;
import me.fit.rest.client.IpClientClient;
import me.fit.service.ClientService;

public class ClientScheduler {

	@Inject
	@RestClient
	private IpClientClient IpClientClient;
	
	@Inject
	private ClientService clientService;
	
	@Scheduled(every="10s")
	public void getAllCountries() {
		IpClient client = IpClientClient.get();
		clientService.saveClient(client);
		
	}
}
