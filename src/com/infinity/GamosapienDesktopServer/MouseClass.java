package com.infinity.GamosapienDesktopServer;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;

public class MouseClass {

	int XPos;
	int YPos;
	int Mdelay;

	Toolkit toolkit = Toolkit.getDefaultToolkit(); // Get the current screen
	// size
	Dimension scrnsize = toolkit.getScreenSize(); // Print the screen size
	private Robot mouse;

	MouseClass() throws AWTException {
		XPos = scrnsize.width / 2;
		YPos = scrnsize.height / 2;
		Mdelay = 0;
		mouse = new Robot();
		mouse.mouseMove(XPos, YPos);

	}

	public void MMove(int del, int x1, int y1) throws Exception {

		x1 = (int) ((x1 * 1.0 * scrnsize.width) / 1000.0);
		y1 = (int) ((y1 * 1.0 * scrnsize.height) / 1000.0);

		mouse.mouseMove(x1, y1);

	}
}
