package com.infinitios.casusbelli.utils;


import java.util.Random;

public class Utils {

	private static int nextRowIndex = 1;
										
	static final String AB = "abcdefghijklmnopqrstuvwxyz";
	static Random rndi = new Random();

	static String randomString( int len ) 
	{
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rndi.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
	public static int getRandomNumberInRange(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt(max - min + 1) + min;
		return randomNum;
	}

	public static int getNextRowIndex() {
		return nextRowIndex++;
	}

	public static int getRandomValue(int max) {
		if(max!=1){
			Random rand = new Random();
			int min = 1;

			// nextInt is normally exclusive of the top value,
			// so add 1 to make it inclusive
			int randomNum = rand.nextInt(max - min + 1) + min;
			return randomNum;
		}else{
			return 1;
		}
	}
	
	public static String getUniqueNameForEmail(){
		String mailBody = randomString(getRandomNumberInRange(3, 9));
		System.out.println("Mail Body: " + mailBody);
		return mailBody;
	}
	
	public static String getUniqueDomain(){
		String mailDomain = randomString(getRandomNumberInRange(3, 9));
		String mailSecondDomain = randomString(getRandomNumberInRange(2, 5));
		System.out.println("Mail Domain: " + mailDomain);
		System.out.println("Mail Second Domain: " + mailSecondDomain);
		return "@" + mailDomain + "." + mailSecondDomain;
	}
	
	public static String getUniqueUserName(){
		String userName = randomString(getRandomNumberInRange(3, 9));
		System.out.println("User name: " + userName);
		return userName;
	}

	public static void waitInterval(long interval){
		try {
			synchronized (Thread.currentThread()) {
				Thread.currentThread().wait(interval);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
