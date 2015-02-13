package ch.heigvd.ptl.sc.model;

import org.springframework.data.annotation.Id;

public class Address {
	@Id
	private String id;
	private String street;
	private String city;
	private int postalCode;

	public String getCity() {
		return city;
	}

	public String getId() {
		return id;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}
