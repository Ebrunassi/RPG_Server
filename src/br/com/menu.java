package br.com;
import java.text.Annotation;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.catalina.connector.Response;

import br.com.database.dao.UsuariosDAO;
import br.com.database.dao.databaseDAOService;
import br.com.database.model.Usuarios;
import br.com.filter.SimpleCORSFilter;


@Path("/menu")
public class menu {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}")
	public String hello(@PathParam("name") String name) {
		String response = "{\"name\":\"" + name + "\"}";
		databaseDAOService service = new databaseDAOService();
		Usuarios user = new Usuarios("evandroTeste","123");
		service.persist(user);
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
