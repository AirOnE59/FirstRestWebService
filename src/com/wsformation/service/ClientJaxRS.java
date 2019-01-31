package com.wsformation.service;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ClientJaxRS {

	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
	URI uri = UriBuilder.fromUri("http://localhost:8080/TPJAXRS/").build();
		WebResource service = client.resource(uri);
		WebResource path = service.path("banque").path("conversion").path("5");
		String res = path.get(String.class);
		System.out.println(res);
		
		//REQUETE POST AVEC UN PARAM
		WebResource path2 = service.path("banque").path("comptesParClient").queryParam("cc", "45");
		String res2 = path2.post(String.class);
		System.out.println(res2);
		
	}

	
}
