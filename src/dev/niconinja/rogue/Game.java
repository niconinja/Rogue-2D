package dev.niconinja.rogue;

import java.awt.*;
import java.awt.image.BufferStrategy;

import dev.niconinja.rogue.display.*;

//Most important class in the game. Includes most of the games code.
public class Game implements Runnable {
	
	//Display and properties of it.
	private Display display;
	public String title;
	public int width, height;

	//Thread anf properties of it.
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;					
		this.title = title;
	}
	
	//Initializes everything.
	private void init(){
		display = new Display(title, width, height);
	}
	
	//Updates variables.
	private void tick(){
		
	}
	
	//Shows everything on the screen.
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Draw start:
		
		
		
		//Draw end.
		bs.show();
		g.dispose();
	}
	
	//Main game loop.
	public void run(){
		
		init();
		while(running){
			tick();
			render();
		}
		
		stop();
		
	}
	
	//Starts the seperate thread the game is running on.
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	//Ends the seperate thread the game is running on.
	public synchronized void stop(){
		if(!running){
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
