package com.flyaway.model;

public class Admin {

	private String password;
	private String username;
	private String newpassword;
	private String confirmpassword;

	public Admin() {

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public Admin(String password, String username, String newpassword, String confirmpassword) {
		super();
		this.password = password;
		this.username = username;
		this.newpassword = newpassword;
		this.confirmpassword = confirmpassword;
	}

	@Override
	public String toString() {
		return "Admin [password=" + password + ", username=" + username + ", newpassword=" + newpassword
				+ ", confirmpassword=" + confirmpassword + "]";
	}



}
