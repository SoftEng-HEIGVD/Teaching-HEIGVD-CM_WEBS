package ch.heigvd.ptl.transfert.object.sample;

import ch.heigvd.ptl.transfert.object.sample.rest.DataResource;
import ch.heigvd.ptl.transfert.object.sample.rest.OrderResource;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(ObjectMapperProvider.class);
		register(DataResource.class);
		register(OrderResource.class);
	}
}
