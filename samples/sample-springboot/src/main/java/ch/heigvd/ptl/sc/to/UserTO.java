package ch.heigvd.ptl.sc.to;

public class UserTO {
	private String username;
	private String role;
	private AddressTO address;

	public String getRole() {
		return role;
	}

	public String getUsername() {
		return username;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AddressTO getAddress() {
		return address;
	}

	public void setAddress(AddressTO address) {
		this.address = address;
	}
}
