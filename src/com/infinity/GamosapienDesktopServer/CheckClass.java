package com.infinity.GamosapienDesktopServer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CheckClass {

	public void check(int n) throws Exception {
		InputStream f = new FileInputStream("F:\\checkfile.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(f));
		String line = null;
		int count = 0;
		if (n == 0) {
			br.close();
			f.close();
			return;
		}
		while ((line = br.readLine()) != null) {
			count++;
			if (count == n)
				break;
		}

		KeyStroke k = new KeyStroke();
		char[] charArray = line.toCharArray();
		k.keys(charArray[0]);

		br.close();
		f.close();

	}

}
