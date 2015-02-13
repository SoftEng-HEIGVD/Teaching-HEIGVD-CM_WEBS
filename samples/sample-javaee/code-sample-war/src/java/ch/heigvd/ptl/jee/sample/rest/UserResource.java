package ch.heigvd.ptl.jee.sample.rest;

import ch.heigvd.ptl.jee.sample.model.User;
import ch.heigvd.ptl.jee.sample.service.UserService;
import ch.heigvd.ptl.jee.sample.to.UserTO;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserResource {
	@EJB
	private UserService userService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(UserTO userTO) {
		User userRegistered = userService.registerUser(userTO);
		
		UserTO userRegisteredTO = new UserTO();
		
		userRegisteredTO.setUsername(userRegistered.getUsername());
		userRegisteredTO.setRole(userRegistered.getRole().name());
		
		return Response.ok(userRegisteredTO).build();
	}
}
