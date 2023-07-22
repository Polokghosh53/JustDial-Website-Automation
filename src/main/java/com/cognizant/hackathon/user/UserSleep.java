package com.cognizant.hackathon.user;

public class UserSleep {
	public static void rest(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			System.out.println("Exception is happened by: " + e.getMessage());
		}
	}

}
