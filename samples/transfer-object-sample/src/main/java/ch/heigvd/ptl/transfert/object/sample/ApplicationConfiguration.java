package ch.heigvd.ptl.transfert.object.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfiguration {
	@Value("${mongo.db}")
	private String dbName;
	
	public String getDbName() {
		return dbName;
	}
}