package com.epam.cara.core.configuration;

public class LoginConfiguration {

	private String email;
	private String password;
	private String name;
	
	public LoginConfiguration(String[][] loginData){
	 email = loginData[0][0];
	 password = loginData[0][1];
	 name = loginData[0][2];
	}
	
	public String getEmail (){
		return email;
	}
	
	public String getPassword (){
		return password;
	}
	
	public String getName (){
		return name;
	}
	
	@Override
	public String toString() {
		return "LoginConfiguration [email=" + email + ", password=" + password + ", name=" + name + "]";
	}
}
