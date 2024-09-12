package com.automationFW.models;

public class LoginData {
	
	public String email, password;

	public LoginData(String email, String password) {
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginData [email=" + email + ", password=" + password + "]";
	}
	
	

}
