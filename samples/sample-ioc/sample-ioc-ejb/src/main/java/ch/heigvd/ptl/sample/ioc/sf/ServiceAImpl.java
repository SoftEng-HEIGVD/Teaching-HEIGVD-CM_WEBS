package ch.heigvd.ptl.sample.ioc.sf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAImpl {
	@Autowired
	private ServiceBImpl serviceB;
	
	public String hello() {
		return "Hello " + serviceB.world();
	}
}
