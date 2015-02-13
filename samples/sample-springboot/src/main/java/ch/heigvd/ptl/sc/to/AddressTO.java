package ch.heigvd.ptl.sc.to;

public class AddressTO {
	private String street;
	private int postalCode;
	private String city;

	public String getCity() {
		return city;
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
