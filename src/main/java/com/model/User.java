package com.model;

public class User {
	private String username;
	private String email;
	private String password;
	private String image_path;

	public User(String username, String email, String password, String image_path) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.image_path = image_path;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

}
