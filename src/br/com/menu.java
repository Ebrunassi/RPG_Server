package br.com;
import java.text.Annotation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.apache.catalina.connector.Response;

import br.com.filter.SimpleCORSFilter;


@Path("/menu")
public class menu {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}")
	public String hello(@PathParam("name") String name) {
		String response = "{\"name\":\"" + name + "\"}";
		return response;
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cadastrar")
	public String cadastrar_usuario(String usuario){
		if(usuario.length() > 0)
			return "{\"status\" : \"Sucesso\"}";
		else
			return "{\"status\" : \"Falhou\"}";
	}
	
}
