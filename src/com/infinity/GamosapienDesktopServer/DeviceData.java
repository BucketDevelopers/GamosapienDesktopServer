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
 * 
 * 
 */
import java.io.IOException;
import java.net.*;
import java.util.*;

public class DeviceData {
	private int Roll;
	private int Pitch;
	private int Yaw;
	private char hwKey[];
	private MouseClass mouse;
	//private KeyPressCheckClass keyPress;
	KeyStroke keyStrokeengine;
	private DatagramSocket serverSocket;
	private Timer headDataTimer; // Timer to call receive data at regular
									// intervals
	private InetAddress sendersIPAddress; // Device Data Address
	private int sendersPort; // Device Data Ephemeral Port
	private int dataPort = 9001; // This is the port to which data is received
	private char[] hwKeyState;

	// in this PC

	public DeviceData(int dataPortValue) throws Exception {
		keyStrokeengine=new KeyStroke();
		dataPort = dataPortValue;
		serverSocket = new DatagramSocket(dataPort);
		headDataTimer = new Timer();
		sendersIPAddress = InetAddress.getLocalHost();
		sendersPort = dataPort;// Just initialize it with any Port
		mouse = new MouseClass();
		//keyPress = new KeyPressCheckClass();
		hwKey = new char[11];
		hwKeyState=new char[11];
		for(int i=0;i<11;++i)
		{
			hwKey[i]='0';
			hwKeyState[i]='0';
		}
	}

	public void startReceivingData() {
		headDataTimer.scheduleAtFixedRate(new TimerTask() {

			private int lastYAW = 0;
			private float lastPitch = 0;

			public void run() {

				byte[] receiveData = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length);
				try {
					serverSocket.receive(receivePacket);
					String sentence = new String(receivePacket.getData());
					sentence = sentence.trim();
					try {
						decodeAndSetData(sentence);

					} catch (Exception e) {

						System.out.println("Error in Data Format ! Data: "
								+ sentence.toString());
					}
					sendersIPAddress = receivePacket.getAddress();
					sendersPort = receivePacket.getPort();

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

					printAllData();

					// Now Move the mouse and Keyboard presses
					mouse.MM(0, roundedYaw, roundedPitch);
					try {
						for (int i = 0; i < 11; ++i) {
							//keyPress.check(i,hwKey[i]);
							keyStrokeengine.keys(hwKey[i],hwKeyState[i]-'0');
						}

					} catch (Exception e) {
						System.out.print("NULL DETECTED");
					}
					lastPitch = Pitch;

				} catch (IOException e) {
					System.out.println("Error receiving data from Device ");
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}, 0, 1); // max fps

	}

	public void printAllData() {
		StringBuilder sb = new StringBuilder("Roll " + this.Roll + " Pitch "
				+ this.Pitch + " Yaw " + this.Yaw + " hwKey ");
		for (int i = 0; i < 11; ++i) {
			sb.append("("+hwKey[i]+"-"+hwKeyState[i]+")");
		}
		System.out.println(sb.toString());
		System.out.println(getHeadDeviceData());
	}

	private void decodeAndSetData(String headData)
			throws NumberFormatException, ArrayIndexOutOfBoundsException {
		String[] DeviceSensorData = headData.trim().split(",");
		this.setRoll(Integer.parseInt(DeviceSensorData[1]));
		this.setPitch(Integer.parseInt(DeviceSensorData[2]));
		this.setYaw(Integer.parseInt(DeviceSensorData[3]));
		for (int i = 0; i < 11; ++i) {
			this.hwKey[i]=(DeviceSensorData[4 + i].charAt(0));
			this.hwKeyState[i]=(DeviceSensorData[4 + i].charAt(1));
		}
	}

	public void stopReceivingData() throws IOException {

		headDataTimer.cancel();
		// To stop the Head data receiver if its waiting for the data from
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
}
