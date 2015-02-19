package ch.heigvd.ptl.transfert.object.sample.rest;

import ch.heigvd.ptl.transfert.object.sample.converter.OrderConverter;
import ch.heigvd.ptl.transfert.object.sample.persistence.OrderRepository;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/orders")
public class OrderResource {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderConverter orderConverter;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		return Response.ok(orderConverter.convertModelToTransferObject(orderRepository.findAll())).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response read(@PathParam("id") String id) {
		return Response.ok(orderConverter.convertModelToTransferObject(orderRepository.findOne(id))).build();
	}
}
