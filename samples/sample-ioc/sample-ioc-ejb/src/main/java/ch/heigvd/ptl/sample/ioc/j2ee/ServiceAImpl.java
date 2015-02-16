package ch.heigvd.ptl.sample.ioc.j2ee;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ServiceAImpl {
	@EJB
	private ServiceBImpl serviceB;
	
	public String hello() {
		return "Hello " + serviceB.world();
	}
}
