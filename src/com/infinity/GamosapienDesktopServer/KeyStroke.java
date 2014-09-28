

   package com.infinity.GamosapienDesktopServer;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class KeyStroke {

	public void keys(char character) throws Exception
	{
		Robot r=new Robot();
//		r.delay(2000);
		 switch (character) {
	      case 'a': r.keyPress(KeyEvent.VK_A); r.delay(500);r.keyRelease(KeyEvent.VK_A); break;
	      case 'b': r.keyPress(KeyEvent.VK_B); break;
	      case 'c': r.keyPress(KeyEvent.VK_C); break;
	      case 'd': r.keyPress(KeyEvent.VK_D); r.delay(500);r.keyRelease(KeyEvent.VK_D); break;
	      case 'e': r.keyPress(KeyEvent.VK_E); break;
	      case 'f': r.keyPress(KeyEvent.VK_F); break;
	      case 'g': r.keyPress(KeyEvent.VK_G); break;
	      case 'h': r.keyPress(KeyEvent.VK_H); break;
	      case 'i': r.keyPress(KeyEvent.VK_I); break;
	      case 'j': r.keyPress(KeyEvent.VK_J); break;
	      case 'k': r.keyPress(KeyEvent.VK_K); break;
	      case 'l': r.keyPress(KeyEvent.VK_L); break;
	      case 'm': r.keyPress(KeyEvent.VK_M); break;
	      case 'n': r.keyPress(KeyEvent.VK_N); break;
	      case 'o': r.keyPress(KeyEvent.VK_O); break;
	      case 'p': r.keyPress(KeyEvent.VK_P); break;
	      case 'q': r.keyPress(KeyEvent.VK_Q); r.delay(500);r.keyRelease(KeyEvent.VK_Q); break;
	      case 'r': r.keyPress(KeyEvent.VK_R); r.delay(500);r.keyRelease(KeyEvent.VK_R); break;
	      case 's': r.keyPress(KeyEvent.VK_S); r.delay(500);r.keyRelease(KeyEvent.VK_S); break;
	      case 't': r.keyPress(KeyEvent.VK_T); break;
	      case 'u': r.keyPress(KeyEvent.VK_U); break;
	      case 'v': r.keyPress(KeyEvent.VK_V); break;
	      case 'w': r.keyPress(KeyEvent.VK_W); r.delay(500);r.keyRelease(KeyEvent.VK_W); break;
	      case 'x': r.keyPress(KeyEvent.VK_X); break;
	      case 'y': r.keyPress(KeyEvent.VK_Y); break;
	      case 'z': r.keyPress(KeyEvent.VK_Z); break;
	      case ' ': r.keyPress(KeyEvent.VK_SPACE); break;   
	      case '!': r.keyPress(KeyEvent.VK_LEFT); break;  
	      case '@': r.keyPress(KeyEvent.VK_RIGHT); break;  
	      case '0' : break;
	      case '$': r.mousePress(InputEvent.BUTTON1_MASK);r.delay(100); r.mouseRelease(InputEvent.BUTTON1_MASK); break;   
	      case '*': r.mousePress(InputEvent.BUTTON3_MASK);r.delay(100); r.mouseRelease(InputEvent.BUTTON3_MASK);break;   
	      default:
	          //throw new IllegalArgumentException("Cannot type character " + character);
	      }
	}
}
