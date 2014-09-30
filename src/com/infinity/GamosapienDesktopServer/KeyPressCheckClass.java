//package com.infinity.GamosapienDesktopServer;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//public class KeyPressCheckClass {
//	private int MAX_KEYS=15;
//	
//	private String stringArray[]=new String[MAX_KEYS];
//	public KeyPressCheckClass() throws IOException
//	{
//		int count=0;
//		InputStream f = new FileInputStream("F:\\checkfile.txt");
//		BufferedReader br = new BufferedReader(new InputStreamReader(f));
//		String line = null;
//		while ((line = br.readLine()) != null) {
//			
//			stringArray[count]=line;
//			count++;
//		}
//		br.close();
//		f.close();
//	}
//	public void check(int n) throws Exception {
//		if(n==0)
//		{
//			return;
//		}
//		n=n-1;
//		KeyStroke k = new KeyStroke();
////		k.keys(stringArray[n].toCharArray()[0]);
//
//	}
//
//}
