package com.companyname.casusbelli.core.configuration;

public class GroupLoginConfiguration {
	
	private String email;
	private String password;
	private String name;
	
	public GroupLoginConfiguration(String[][] loginData){
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
		return "GroupLoginConfiguration [email=" + email + ", password=" + password + ", name=" + name + "]";
	}

}
