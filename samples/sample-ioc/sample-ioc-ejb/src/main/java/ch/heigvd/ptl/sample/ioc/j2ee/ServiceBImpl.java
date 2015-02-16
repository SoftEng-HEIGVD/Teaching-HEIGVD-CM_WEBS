package ch.heigvd.ptl.sample.ioc.j2ee;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ServiceBImpl {
	public String world() {
		return "World!";
	}
}
