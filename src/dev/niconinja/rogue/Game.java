//TODO continue with creature sizing

package dev.niconinja.rogue;

import java.awt.*;
import java.awt.image.BufferStrategy;

import dev.niconinja.rogue.display.*;
import dev.niconinja.rogue.gfx.Assets;
import dev.niconinja.rogue.input.KeyManager;
import dev.niconinja.rogue.states.*;

//Most important class in the game. Includes most of the games code.
public class Game implements Runnable {
	
	//Display and properties of it.
	private Display display;
	public String title;
	public int width, height;

	//Thread and properties of it.
	private Thread thread;
	private boolean running = false;
	
	//Graphics 
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	private State settingsState;
	
	//Input
	private KeyManager keyManager;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;					
		this.title = title;
		keyManager = new KeyManager();
	}
	
	
	//Initializes everything.
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		settingsState = new SettingsState(this);
		State.setState(gameState);
	}
	
	
	//Updates variables.
	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null){
			State.getState().tick();
		}
	}
	
	//Shows everything on the screen.
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		//Clear screen.
		g.clearRect(0, 0, width, height);
		
		//Draw start:
		
		if(State.getState() != null){
			State.getState().render(g);
		}
		
		//Draw end.
		
		bs.show();
		g.dispose();
	}
	
	//Main game loop.
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		long ticks = 0;
		
		
		while(running){
			
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				
				tick();
				render();
				ticks++;
				delta--;		
			}
			
			if(timer >= 1000000000){
				System.out.println(ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	//Starts the separate thread the game is running on.
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