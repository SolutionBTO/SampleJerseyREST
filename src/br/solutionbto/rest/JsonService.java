package br.solutionbto.rest;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import br.solutionbto.model.Role;
import br.solutionbto.model.Track;
import br.solutionbto.security.ExternalUser;

@Path("/json/metallica")
public class JsonService {
	
	private Logger logger=Logger.getLogger(JsonService.class.getSimpleName());
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTrackInJSON(@Context SecurityContext securityContext) {
		
		ExternalUser externalUser=(ExternalUser)securityContext.getUserPrincipal();
		
		logger.info("access method /json/metallica/get/ "+externalUser.toString());
		
		Track track = new Track();
		
		if(securityContext.isUserInRole(Role.anonymous.toString())){
			track.setTitle("Enter Sandman");
			track.setSinger("Metallica");
		}
		else
		if(securityContext.isUserInRole(Role.administrator.toString())){
			track.setTitle("Whisky in the Jar");
			track.setSinger("Metallica");
		}
		else
			if(securityContext.isUserInRole(Role.authenticated.toString())){
				track.setTitle("Fuel");
				track.setSinger("Metallica");
			}	
 
		return Response.ok().entity(track).build();
	}
 
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {
 
		String result = "Track saved : " + track;
		return Response.ok().entity(result).build();
 
	}
 
}