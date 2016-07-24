package dev.niconinja.rogue.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Can read the keyboard input.
public class KeyManager implements KeyListener {

	//All keys on the keyboard.
	public boolean[] keys;
	
	//The actions currently used.
	public boolean up, down, left, right;
	
	//Makes all keys have a corresponding boolean variable. The variable is true, while the key is pressed.
	public KeyManager(){
		keys = new boolean[256];
	}
	
	//Sets the currently used actions equal to the corresponding keys.
	public void tick(){
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}
	
	//When a key starts to be pressed.
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	
	//When a key isn't pressed anymore.
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
