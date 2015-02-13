package ch.heigvd.ptl.sc.rest;

import ch.heigvd.ptl.sc.converter.UserConverter;
import ch.heigvd.ptl.sc.model.User;
import ch.heigvd.ptl.sc.service.UserService;
import ch.heigvd.ptl.sc.to.UserTO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/users")
public class UserResource {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserConverter userConverter;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(UserTO userTO) {
		User user = userService.register(userTO);

		return Response.ok(userConverter.convertSourceToTarget(user)).status(201).build();
	}
}
