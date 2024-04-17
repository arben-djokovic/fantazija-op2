package me.fit.service;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.rest.client.IpClient;

@Dependent
public class ClientService {
	
	@Inject
	private EntityManager em;

	@Transactional
	public void saveClient(IpClient client) {
		
		List<IpClient> savedClient = getClient();
		
		for (IpClient client2 : savedClient) {
			em.merge(client2);
		}
	}
	
	@Transactional
	public List<IpClient> getClient(){
		return em.createNamedQuery(IpClient.GET, IpClient.class).getResultList();
	}


	
}