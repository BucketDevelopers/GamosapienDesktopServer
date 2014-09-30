package com.infinity.GamosapienDesktopServer;


public class MainServer {
	private static DeviceData phone;

	public static void main(String args[]) throws Exception {
		phone = new DeviceData(9004);
		phone.startReceivingData();
		//phone.printAllData();
		//phone.stopReceivingData();
		
		
	}
}