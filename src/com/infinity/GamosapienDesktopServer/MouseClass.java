package com.infinity.GamosapienDesktopServer;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;

public class MouseClass {

	int XPos;
	int YPos;
	int Mdelay;

	Toolkit toolkit = Toolkit.getDefaultToolkit(); // Get the current screen
	// size
	Dimension scrnsize = toolkit.getScreenSize(); // Print the screen size

	MouseClass() throws AWTException {

		// System.out.println ("Screen size : " + scrnsize);
		XPos = scrnsize.width / 2;
		YPos = scrnsize.height / 2;
		Mdelay = 0;
		Robot iP = new Robot();
		iP.mouseMove(XPos, YPos);

	}

	public void MM(int del, int x1, int y1) throws Exception {
		Robot r = new Robot();
		int i, j;
		Point p = MouseInfo.getPointerInfo().getLocation();
		XPos = p.x;
		YPos = p.y;
		j = YPos;
		x1 = (int) ((x1 * 1.0 * scrnsize.width) / 1000.0);
		y1 = (int) ((y1 * 1.0 * scrnsize.height) / 1000.0);
		@SuppressWarnings("unused")
		int flag = 0;
		r.mouseMove(x1, y1);

		//
		// for (i = XPos, j = YPos; i <= x1 && j <= y1; i++, j++) {
		// r.mouseMove(i, j);
		// r.delay(del);
		// flag = 1;
		// }
		// if (flag == 1) {
		// if (i != x1) {
		// for (; i <= x1; i++) {
		// r.mouseMove(i, j);
		// r.delay(del);
		//
		// }
		// }
		//
		// if (j != y1) {
		// for (; j <= y1; j++) {
		// r.mouseMove(i, j);
		// r.delay(del);
		//
		// }
		// }
		// }
		//
		// if (flag != 1)
		// for (i = XPos, j = YPos; i <= x1 && j >= y1; i++, j--) {
		// r.mouseMove(i, j);
		// r.delay(del);
		// flag = 1;
		// }
		// if (flag == 1) {
		// if (i != x1) {
		// for (; i <= x1; i++) {
		// r.mouseMove(i, j);
		// r.delay(del);
		//
		// }
		// }
		//
		// if (j != y1) {
		// for (; j >= y1; j--) {
		// r.mouseMove(i, j);
		// r.delay(del);
		//
		// }
		// }
		// }
		//
		// if (flag != 1)
		// for (i = XPos, j = YPos; i >= x1 && j >= y1; i--, j--) {
		// r.mouseMove(i, j);
		// r.delay(del);
		// flag = 1;
		// }
		// if (flag == 1) {
		// if (i != x1) {
		// for (; i >= x1; i--) {
		// r.mouseMove(i, j);
		// r.delay(del);
		//
		// }
		// }
		//
		// if (j != y1) {
		// for (; j >= y1; j--) {
		// r.mouseMove(i, j);
		// r.delay(del);
		//
		// }
		// }
		// }
		// if (flag != 1)
		// for (i = XPos, j = YPos; i >= x1 && j <= y1; i--, j++) {
		// r.mouseMove(i, j);
		// r.delay(del);
		// flag = 1;
		// }
		// if (flag == 1) {
		// if (i != x1) {
		// for (; i >= x1; i--) {
		// r.mouseMove(i, j);
		// r.delay(del);
		//
		// }
		// }
		//
		// if (j != y1) {
		// for (; j <= y1; j++) {
		// r.mouseMove(i, j);
		// r.delay(del);
		//
		// }
		// }
		// }

		/*
		 * float steps,xinc,yinc; dx = Math.abs(XPos-x1); dy =
		 * Math.abs(YPos-y1); if(dx> dy) { steps = dy/dx; xinc = steps; yinc =
		 * 1;
		 * 
		 * } else { steps = dx/dy; xinc = 1; yinc = steps; } i = XPos; j = YPos;
		 * while(i<x1){
		 * 
		 * r.mouseMove(i, j); r.delay(del); i=i+xinc; j=j+yinc;
		 */

		/*
		 * System.out.print("X = " + XPos + " Y = " + YPos); boolean steep =
		 * Math.abs(y1 - YPos) > Math.abs(x1 - XPos); if (steep) { int t; //
		 * swap(XPos, YPos); t = XPos; XPos = YPos; YPos = t; // swap(x1, y1); t
		 * = x1; x1 = y1; y1 = t; } if (XPos > x1) { int t; // swap(XPos, x1); t
		 * = XPos; XPos = x1; x1 = t;
		 * 
		 * // swap(YPos, y1); t = YPos; YPos = y1; y1 = t; } int deltax = x1 -
		 * XPos; int deltay = Math.abs(y1 - YPos); int error = deltax / 2; int
		 * ystep; int y = YPos; if (YPos < y1) ystep = 1; else ystep = -1;
		 * 
		 * for (int x = XPos; x < x1; x++) { if (steep) r.mouseMove(y, x); else
		 * r.mouseMove(x, y); error = error - deltay; if (error < 0) { y = y +
		 * ystep; error = error + deltax; }
		 */
	}
}
