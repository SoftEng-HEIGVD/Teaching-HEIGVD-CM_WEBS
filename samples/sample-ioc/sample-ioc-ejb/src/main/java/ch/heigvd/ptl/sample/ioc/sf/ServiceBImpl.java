package ch.heigvd.ptl.sample.ioc.sf;

import org.springframework.stereotype.Service;

@Service
public class ServiceBImpl {
	public String world() {
		return "World!";
	}
}
