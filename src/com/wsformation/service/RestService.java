package com.wsformation.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.org.apache.regexp.internal.recompile;

@Path("/banque")
public class RestService {

		@GET
		@Path("/message")
		@Produces(MediaType.TEXT_PLAIN) 
		
	public String getMessage() {
			return "Test Rest full";
		}
		
		@GET
		@Path("/conversion/{montant}")
		@Produces(MediaType.APPLICATION_JSON)
		
	public double conversion (@PathParam("montant") double mt) {
			return mt*11;
		}
		
		@GET
		@Path("/infos")
		@Produces(MediaType.APPLICATION_JSON)
		
	public List<String> getInfos() {
			List<String> res = new ArrayList<String>(); 
			res.add("A"); 
			res.add("B");
			res.add("C");
			return res;
		}
		
		@GET
		@Path("/clients")
		@Produces(MediaType.APPLICATION_XML)
		
	public List<Client> getClients() {
			List<Client> res = new ArrayList<Client>();
			res.add(new Client(1,"A"));
			return res;
		}
		
		@GET
		@Path("/response")
	public Response getReponse() {
		return Response
				.status(Response.Status.OK)
				.header("param1", "valeur1")
				.header("param2", "valeur2")
				.entity("Corps du message")
				.build();
	}
		
		@GET
		@Path("/comptes/v2/{code}/{nom}")
		@Produces(value= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response compte (@PathParam("code")int code, @PathParam("nom")String nom) {
			Client cli = new Client();
			return Response
					.status(Response.Status.OK)
					.entity(cli)
					.build();
		}
	
}
