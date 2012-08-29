package com.epam.cara.core.configuration;

public class GroupOrderSetupConfiguration {
	private String addressType;
	private String deliverTo;
	private String address1;
	private String address2;
	private String city;
	private String province;
	private String postalCode;
	private String crossStreet;
	private String specialInstructions;
	private String searchQuery;
	private String futureDate;
	private String futureTime;
	
	public GroupOrderSetupConfiguration(String[][] orderSetupData){
		addressType = orderSetupData[0][0];
		deliverTo = orderSetupData[0][1];
		address1 = orderSetupData[0][2];
		address2 = orderSetupData[0][3];
		city = orderSetupData[0][4];
		province = orderSetupData[0][5];
		postalCode = orderSetupData[0][6];
		crossStreet = orderSetupData[0][7];
		specialInstructions = orderSetupData[0][8];
		searchQuery = orderSetupData[0][9];
		futureDate = orderSetupData[0][10];
		futureTime = orderSetupData[0][11];
	}
	
	public String getAddressType() {
		return addressType;
	}
	
	public String getDeliverTo() {
		return deliverTo;
	}
	
	public String getAddress1() {
		return address1;
	}
	
	public String getAddress2() {
		return address2;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getProvince() {
		return province;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public String getCrossStreet() {
		return crossStreet;
	}
	
	public String getSpecialInstructions() {
		return specialInstructions;
	}
	
	public String getSearchQuery() {
		return searchQuery;
	}
	
	public String getFutureDate() {
		return futureDate;
	}
	
	public String getFutureTime() {
		return futureTime;
	}
	
	@Override
	public String toString() {
		return "GroupOrderSetupConfiguration [addressType=" + addressType + ", deliverTo=" + deliverTo + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", province=" + province + ", postalCode=" + postalCode + ", crossStreet=" + crossStreet + ", specialInstructions=" + specialInstructions + ", searchQuery=" + searchQuery + ", futureDate=" + futureDate + ", futureTime=" + futureTime + "]";
	}
}
