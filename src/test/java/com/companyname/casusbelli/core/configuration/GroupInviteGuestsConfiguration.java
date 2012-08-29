package com.companyname.casusbelli.core.configuration;

public class GroupInviteGuestsConfiguration {
	private String message;
	private String amount;
	private String login;
	private String password;
	private String service;
	
	public GroupInviteGuestsConfiguration(String[][] invaiteGuestData){
		message = invaiteGuestData[0][3];
		amount = invaiteGuestData[0][4];
		login = invaiteGuestData[0][5];
		password = invaiteGuestData[0][6];
		service = invaiteGuestData[0][7];
	}
	
	public String getMessage (){
		return message;
	}
	
	public String getAmount (){
		return amount;
	}
	
	public String getLogin (){
		return login;
	}
	
	public String getPassword (){
		return password;
	}
	
	public String getService (){
		return service;
	}
	
	@Override
	public String toString() {
		return "GroupInviteGuestsConfiguration [message=" + message + ", amount=" + amount + ", login=" + login + ", password=" + password +", service=" + service + "]";
	}
}
