package com.infinity.GamosapienDesktopServer;

/*
 * @Author : TEAM INFINITY 
 * ATUL
 * RAVEENDRA
 * APARNA
 * BHAVYA
 * NIVEDITHA
 * 
 * DEVICE DATA 
 * Data Format: D,Roll,Pitch,Yaw,Key(VolUp,VolDn,9GridValues)
 * 
 */
import java.awt.AWTException;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class DeviceData {
	private int Roll;
	private int Pitch;
	private int Yaw;
	private int hwKey;
	private MouseClass mouse;
	private CheckClass check;

	private DatagramSocket serverSocket;
	private Timer headDataTimer; // Timer to call receive data at regular
									// intervals
	private InetAddress sendersIPAddress; // Device Data Address
	private int sendersPort; // Device Data Ephemeral Port
	private int dataPort = 9001; // This is the port to which data is received
									// in this PC

	public DeviceData(int dataPortValue) throws SocketException,
			UnknownHostException, AWTException {
		dataPort = dataPortValue;
		serverSocket = new DatagramSocket(dataPort);
		headDataTimer = new Timer();
		sendersIPAddress = InetAddress.getLocalHost();
		sendersPort = dataPort;// Just initialize it with any Port
		mouse = new MouseClass();
		check = new CheckClass();
		hwKey = 0;
	}

	public void startReceivingData() {
		headDataTimer.scheduleAtFixedRate(new TimerTask() {

			private int lastYAW = 0;
			@SuppressWarnings("unused")
			private float lastPitch = 0;

			public void run() {

				byte[] receiveData = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length);
				try {
					serverSocket.receive(receivePacket);
					setHwKey(0);
					String sentence = new String(receivePacket.getData());
					sentence = sentence.trim();
					try {
						decodeAndSetHeadData(sentence);
						// System.out.println("\n" + sentence);
					} catch (Exception e) {

						System.out.println("Error in Data Format ! Data: "
								+ sentence.toString());
					}
					sendersIPAddress = receivePacket.getAddress();
					sendersPort = receivePacket.getPort();

					System.out.println("\n MAPPED "
							+ Utility.mappedValue((float) Yaw - lastYAW, -20f,
									20f, 0f, 1000f));
					int roundedYaw = (int) Utility.mappedValue((float) Yaw
							- lastYAW, -50f, 50f, 0f, 1000f);
					if (roundedYaw <= 3 && roundedYaw >= -3) {
						roundedYaw = 0;
					}
					int roundedPitch = (int) Utility.mappedValue((float) Pitch,
							-15f, 25f, 300f, 700f);
					if (roundedPitch <= 3 && roundedPitch >= -3) {
						roundedPitch = 0;
					}
					System.out.print("*****" + hwKey);
					printAllData();
					mouse.MM(0, roundedYaw, roundedPitch);
					try {
						check.check(hwKey);

					} catch (Exception e) {
						System.out.print("NULL COMING");
					}
					lastPitch = Pitch;

				} catch (IOException e) {
					System.out.println("Error receiving data from Device ");
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}, 0, 1); // max fps

	}

	public void printAllData() {
		System.out.println("Roll " + this.Roll + " Pitch " + this.Pitch
				+ " Yaw " + this.Yaw + " hwKey " + this.getHwKey());
		System.out.println(getHeadDeviceData());
	}

	private void decodeAndSetHeadData(String headData)
			throws NumberFormatException, ArrayIndexOutOfBoundsException {
		String[] DeviceSensorData = headData.trim().split(",");
		this.setRoll(Integer.parseInt(DeviceSensorData[1]));
		this.setPitch(Integer.parseInt(DeviceSensorData[2]));
		this.setYaw(Integer.parseInt(DeviceSensorData[3]));
		this.setHwKey(Integer.parseInt(DeviceSensorData[4]));

	}

	public void stopReceivingData() throws IOException {

		headDataTimer.cancel();
		// To stop the Head data receiver if its waiting for the data from Head
		// Device
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getLocalHost();
		byte[] sendData = new byte[1024];

		String fakeData = "DEVICE_DATA,0,0,0,0";
		sendData = fakeData.getBytes();

		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, IPAddress, dataPort);
		clientSocket.send(sendPacket);
		System.out.println("Sent Stopping data");
		clientSocket.close();

	}

	public String getHeadDeviceData() {
		return "Device IP  : " + sendersIPAddress.getHostAddress() + ":"
				+ sendersPort;

	}

	public int getRoll() {
		return Roll;
	}

	public void setRoll(int roll) {
		Roll = roll;
	}

	public int getPitch() {
		return Pitch;
	}

	public void setPitch(int pitch) {
		Pitch = pitch;
	}

	public int getYaw() {
		return Yaw;
	}

	public void setYaw(int yaw) {
		Yaw = yaw;
	}

	public int getHwKey() {
		return hwKey;
	}

	public void setHwKey(int hwKey) {
		this.hwKey = hwKey;
	}
}
