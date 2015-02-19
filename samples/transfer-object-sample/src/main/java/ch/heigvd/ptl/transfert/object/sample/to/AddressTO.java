package ch.heigvd.ptl.transfert.object.sample.to;

public class AddressTO {
	private String name;
	private String street;
	private String city;

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
