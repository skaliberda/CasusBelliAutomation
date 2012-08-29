package com.epam.cara.core.configuration;

public class GroupPaymentConfiguration {
	private String couponCode;
	private String cardType;
	private String cardNumber;
	private String cardSecurityCode;
	private String cardholderName;
	private String expirationDate;
	private String expirationYear;
	private String giftCardNumber;
	private String amount;
	private String specialInstractions;
	
	public GroupPaymentConfiguration(String[][] paymentData){
		couponCode = paymentData[0][0];
		cardType = paymentData[0][1];
		cardNumber = paymentData[0][2];
		cardSecurityCode = paymentData[0][3];
		cardholderName = paymentData[0][4];
		expirationDate = paymentData[0][5];
		expirationYear = paymentData[0][6];
		giftCardNumber = paymentData[0][7];
		amount = paymentData[0][8];
		specialInstractions = paymentData[0][9];
	}
	
	public String getCouponCode (){
		return couponCode;
	}
	
	public String getCardType (){
		return cardType;
	}
	
	public String getCardNumber (){
		return cardNumber;
	}
	
	public String getCardSecurityCode (){
		return cardSecurityCode;
	}
	
	public String getCardholderName (){
		return cardholderName;
	}
	
	public String getExpirationDate (){
		return expirationDate;
	}
	
	public String getExpirationYear (){
		return expirationYear;
	}
	
	public String getGiftCardNumber (){
		return giftCardNumber;
	}
	
	public String getGiftCardAmount (){
		return amount;
	}
	
	public String getSpecialInstractions (){
		return specialInstractions;
	}
	
	@Override
	public String toString() {
		return "GroupPaymentConfiguration [couponCode=" + couponCode + ", cardType=" + cardType + ", cardNumber=" + cardNumber + ", cardSecurityCode=" + cardSecurityCode + ", cardholderName=" + cardholderName + ", expirationDate=" + expirationDate + ", expirationYear=" + expirationYear + ", giftCardNumber=" + giftCardNumber + ", giftCardAmount=" + amount + ", specialInstractions=" + specialInstractions + "]";
	}
}
