package com.infinity.GamosapienDesktopServer;
/*
 * 
 * KEY MAP
	!->LEFT,@->RIGHT, ->SPACE,*->MOUSERIGHT,$->MOUSELEFT,
	%->UP,^->DOWN,&->CTRL,(->SHIFT,)->ALT,

 * 
 * 
 */


import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class KeyStroke {
	int mousekeyleftstate = 2;
	int mousekeyrightstate = 2;
	Robot r;

	public KeyStroke() throws Exception {
		r = new Robot();
	}

	public void keys(char character, int keystate) throws Exception {

		character = Character.toLowerCase(character);

		if (character == '0') {
			return;
		}
		// r.delay(2000);
		if (keystate == 1) {
			switch (character) {
			case '0':
				break;
			case 'a':
				r.keyPress(KeyEvent.VK_A);
				break;
			case 'b':
				r.keyPress(KeyEvent.VK_B);
				break;
			case 'c':
				r.keyPress(KeyEvent.VK_C);
				break;
			case 'd':
				r.keyPress(KeyEvent.VK_D);
				break;
			case 'e':
				r.keyPress(KeyEvent.VK_E);
				break;
			case 'f':
				r.keyPress(KeyEvent.VK_F);
				break;
			case 'g':
				r.keyPress(KeyEvent.VK_G);
				break;
			case 'h':
				r.keyPress(KeyEvent.VK_H);
				break;
			case 'i':
				r.keyPress(KeyEvent.VK_I);
				break;
			case 'j':
				r.keyPress(KeyEvent.VK_J);
				break;
			case 'k':
				r.keyPress(KeyEvent.VK_K);
				break;
			case 'l':
				r.keyPress(KeyEvent.VK_L);
				break;
			case 'm':
				r.keyPress(KeyEvent.VK_M);
				break;
			case 'n':
				r.keyPress(KeyEvent.VK_N);
				break;
			case 'o':
				r.keyPress(KeyEvent.VK_O);
				break;
			case 'p':
				r.keyPress(KeyEvent.VK_P);
				break;
			case 'q':
				r.keyPress(KeyEvent.VK_Q);
				break;
			case 'r':
				r.keyPress(KeyEvent.VK_R);
				break;
			case 's':
				r.keyPress(KeyEvent.VK_S);
				break;
			case 't':
				r.keyPress(KeyEvent.VK_T);
				break;
			case 'u':
				r.keyPress(KeyEvent.VK_U);
				break;
			case 'v':
				r.keyPress(KeyEvent.VK_V);
				break;
			case 'w':
				r.keyPress(KeyEvent.VK_W);
				break;
			case 'x':
				r.keyPress(KeyEvent.VK_X);
				break;
			case 'y':
				r.keyPress(KeyEvent.VK_Y);
				break;
			case 'z':
				r.keyPress(KeyEvent.VK_Z);
				break;
			case '1':
				r.keyPress(KeyEvent.VK_1);
				break;
			case '2':
				r.keyPress(KeyEvent.VK_2);
				break;
			case '3':
				r.keyPress(KeyEvent.VK_3);
				break;
			case '4':
				r.keyPress(KeyEvent.VK_4);
				break;
			case '5':
				r.keyPress(KeyEvent.VK_5);
				break;
			case '6':
				r.keyPress(KeyEvent.VK_6);
				break;
			case '7':
				r.keyPress(KeyEvent.VK_7);
				break;
			case '8':
				r.keyPress(KeyEvent.VK_8);
				break;
			case '9':
				r.keyPress(KeyEvent.VK_9);
				break;
			case '_':
				r.keyPress(KeyEvent.VK_SPACE);
				break;
			case '!':
				r.keyPress(KeyEvent.VK_LEFT);
				break;
			case '@':
				r.keyPress(KeyEvent.VK_RIGHT);
				break;
		//		%->UP,^->DOWN,&->CTRL,(->SHIFT,)->ALT,
			case '%':
				r.keyPress(KeyEvent.VK_UP);
				break;
			case '^':
				r.keyPress(KeyEvent.VK_DOWN);
				break;
			case '&':
				r.keyPress(KeyEvent.VK_CONTROL);
				break;
			case '(':
				r.keyPress(KeyEvent.VK_SHIFT);
				break;
			case ')':
				r.keyPress(KeyEvent.VK_ALT);
				break;
	
			case '*':
				if (mousekeyrightstate == 0 || mousekeyrightstate == 2) {
					r.mousePress(InputEvent.BUTTON3_MASK);
					mousekeyrightstate = 1;
				}
				break;
			case '$':
				if (mousekeyleftstate == 0 || mousekeyleftstate == 2) {
					r.mousePress(InputEvent.BUTTON1_MASK);
					// System.out.print("\nMOUSE RIGHT PRESSED");
					// Thread.sleep(1000);

					mousekeyleftstate = 1;
				}
				break;

			default:
				// throw new IllegalArgumentException("Cannot type character " +
				// character);
			}
		} else if (keystate == 2) {
			switch (character) {
			case '0':
				break;
			case 'a':
				r.keyRelease(KeyEvent.VK_A);
				break;
			case 'b':
				r.keyRelease(KeyEvent.VK_B);
				break;
			case 'c':
				r.keyRelease(KeyEvent.VK_C);
				break;
			case 'd':
				r.keyRelease(KeyEvent.VK_D);
				break;
			case 'e':
				r.keyRelease(KeyEvent.VK_E);
				break;
			case 'f':
				r.keyRelease(KeyEvent.VK_F);
				break;
			case 'g':
				r.keyRelease(KeyEvent.VK_G);
				break;
			case 'h':
				r.keyRelease(KeyEvent.VK_H);
				break;
			case 'i':
				r.keyRelease(KeyEvent.VK_I);
				break;
			case 'j':
				r.keyRelease(KeyEvent.VK_J);
				break;
			case 'k':
				r.keyRelease(KeyEvent.VK_K);
				break;
			case 'l':
				r.keyRelease(KeyEvent.VK_L);
				break;
			case 'm':
				r.keyRelease(KeyEvent.VK_M);
				break;
			case 'n':
				r.keyRelease(KeyEvent.VK_N);
				break;
			case 'o':
				r.keyRelease(KeyEvent.VK_O);
				break;
			case 'p':
				r.keyRelease(KeyEvent.VK_P);
				break;
			case 'q':
				r.keyRelease(KeyEvent.VK_Q);
				break;
			case 'r':
				r.keyRelease(KeyEvent.VK_R);
				break;
			case 's':
				r.keyRelease(KeyEvent.VK_S);
				break;
			case 't':
				r.keyRelease(KeyEvent.VK_T);
				break;
			case 'u':
				r.keyRelease(KeyEvent.VK_U);
				break;
			case 'v':
				r.keyRelease(KeyEvent.VK_V);
				break;
			case 'w':
				r.keyRelease(KeyEvent.VK_W);
				break;
			case 'x':
				r.keyRelease(KeyEvent.VK_X);
				break;
			case 'y':
				r.keyRelease(KeyEvent.VK_Y);
				break;
			case 'z':
				r.keyRelease(KeyEvent.VK_Z);
				break;
			case '1':
				r.keyRelease(KeyEvent.VK_1);
				break;
			case '2':
				r.keyRelease(KeyEvent.VK_2);
				break;
			case '3':
				r.keyRelease(KeyEvent.VK_3);
				break;
			case '4':
				r.keyRelease(KeyEvent.VK_4);
				break;
			case '5':
				r.keyRelease(KeyEvent.VK_5);
				break;
			case '6':
				r.keyRelease(KeyEvent.VK_6);
				break;
			case '7':
				r.keyRelease(KeyEvent.VK_7);
				break;
			case '8':
				r.keyRelease(KeyEvent.VK_8);
				break;
			case '9':
				r.keyRelease(KeyEvent.VK_9);
				break;
			case '_':
				r.keyRelease(KeyEvent.VK_SPACE);
				break;
			case '!':
				r.keyRelease(KeyEvent.VK_LEFT);
				break;
			case '@':
				r.keyRelease(KeyEvent.VK_RIGHT);
				break;
		//		%->UP,^->DOWN,&->CTRL,(->SHIFT,)->ALT,
			case '%':
				r.keyRelease(KeyEvent.VK_UP);
				break;
			case '^':
				r.keyRelease(KeyEvent.VK_DOWN);
				break;
			case '&':
				r.keyRelease(KeyEvent.VK_CONTROL);
				break;
			case '(':
				r.keyRelease(KeyEvent.VK_SHIFT);
				break;
			case ')':
				r.keyRelease(KeyEvent.VK_ALT);
				break;
			case '$':
				if (mousekeyleftstate != 2) {
					r.mouseRelease(InputEvent.BUTTON1_MASK);
					mousekeyleftstate = 2;
				}
				break;
			case '*':
				if (mousekeyrightstate != 2) {
					r.mouseRelease(InputEvent.BUTTON3_MASK);
					mousekeyrightstate = 2;
				}
				break;
			default:
				break;
			}

		}
	}
}
