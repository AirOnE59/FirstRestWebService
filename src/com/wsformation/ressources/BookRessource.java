package com.wsformation.ressources;

import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Path("/books")
public class BookRessource {

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)  
	public String getBookById(@PathParam("id") String id ){
		     return "Hello, World BSW :"+id;
		  }
	
	
	@GET
	@Path("/name-{name}-editor-{editor}")
	@Produces(MediaType.TEXT_PLAIN)  
	public String getBookByNameAndEditor(@PathParam("name") String name,@PathParam("editor") String editor)
	{
		     return "Hello, World BSW Name: "+name+" Edior :"+editor;
	}
	
	@GET
	@Path("/{id : .+}/editor")
	@Produces(MediaType.TEXT_PLAIN)  
	public String getBookEditorById(@PathParam("id") String id ){
		     return "Hello, Java For LIFE2  :"+id;
		  }
	
	@GET
	@Path("/queryparameters")
	@Produces(MediaType.TEXT_PLAIN)  
	public String getQueryParameterBook(@Context UriInfo uriInfo,
			@DefaultValue("all") @QueryParam("name") String name,
			@DefaultValue("?-???-?") @QueryParam("isbn") String isbn,
			@DefaultValue("false") @QueryParam("isExtended") boolean isExtended,
			@HeaderParam("User-Agent") String user){
		
		MultivaluedMap<String,String> para=uriInfo.getPathParameters();
		for(String key:para.keySet())
			System.out.println(key+"=="+para.getFirst(key));
		     return uriInfo.getPath()+ "  **Hello, Java For LIFE2  : Name "+name+" ISBN :"+isbn+" isEx "+ isExtended+" User "+ user;
		  }
	
	@POST
	@Path("/createfromform")
	@Consumes("application/x-www-form-urlencoded") 
	public String createBookFromForm(@FormParam("name") String name){
		
		     return name;
		  }
	
	@GET
	@Path("httpHeaders")
	public String getInformationFromHttpHeaders(@Context HttpHeaders httpheaders) {
		Map<String, Cookie> cookies = httpheaders.getCookies();
		Set<String> currentKeySet = cookies.keySet();
		for (String currentCookie : currentKeySet) {
			System.out.println(currentCookie + "=" + cookies.get(currentCookie));
		}
	MultivaluedMap<String, String> requestHeaders = httpheaders.getRequestHeaders();
		Set<String> requestHeadersSet = requestHeaders.keySet();
		for (String currentHeader : requestHeadersSet) {
	System.out.println(currentHeader + "=" + requestHeaders.get(currentHeader));
		}
		return "ok";
	
		
	}
	
	
}
