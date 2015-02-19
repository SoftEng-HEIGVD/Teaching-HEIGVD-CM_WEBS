package ch.heigvd.ptl.transfert.object.sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class TOApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TOApplication.class);
	}

	public static void main(String[] args) {
		new TOApplication().configure(new SpringApplicationBuilder(TOApplication.class)).run(args);
	}
}
