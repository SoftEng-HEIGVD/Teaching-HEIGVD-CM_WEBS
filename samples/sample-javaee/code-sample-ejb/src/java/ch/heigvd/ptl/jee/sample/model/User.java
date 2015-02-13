package ch.heigvd.ptl.jee.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class User {
	public static enum Role {
		ADMIN,
		MEMBER;
	}
	
	@Id
	private Long id;
	
	@Column(length = 50)
	private String username;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
