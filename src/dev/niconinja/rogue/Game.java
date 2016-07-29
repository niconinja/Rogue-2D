//TODO: Entity Manager
package dev.niconinja.rogue;

import java.awt.*;
import java.awt.image.BufferStrategy;

import dev.niconinja.rogue.display.*;
import dev.niconinja.rogue.gfx.Assets;
import dev.niconinja.rogue.gfx.Camera;
import dev.niconinja.rogue.input.KeyManager;
import dev.niconinja.rogue.states.*;

//Most important class in the game. Includes most of the games code.
public class Game implements Runnable {
	
	//Display and properties of it.
	private Display display;
	public String title;
	private int width, height;

	//Thread and properties of it.
	private Thread thread;
	private boolean running = false;
	
	/* Graphics
	 * Buffer-strategy: Allows buffers to exist. Those are early versions of the image that will be displayed.
	 * 					They are used to remove flickering etc. from the display.
	 * Graphics:		Mainly two kinds of methods: 	draw and fill methods: enable drawing things,
	 * 													attribute setting methods: affect how stuff appears
	 *  
	 */
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	//private State menuState;
	//private State settingsState;
	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private Camera camera;
	
	//Handler
	private Handler handler;
	
	//Parameters = variables, constructs a keyManager
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;					
		this.title = title;
		keyManager = new KeyManager();
	}
	
	
	//Initializes everything.
	private void init(){
		//new display, adds keyListener to it
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		handler = new Handler(this);
		
		camera = new Camera(handler, 0,0);
			
		//initializes all the states, sets current state to gameState
		gameState = new GameState(handler);
		//menuState = new MenuState(handler);
		//settingsState = new SettingsState(handler);
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
		//Sets up the bufferStrategy, sets the graphics object equal to the final buffer
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		//Clear screen.
		g.clearRect(0, 0, width, height);
		
		//things to draw start:
		
		if(State.getState() != null){
			State.getState().render(g);
		}
		
		//things to draw end.
		
		//draws the latest buffer to the screen, removes the "screen" from the graphics object.
		bs.show();
		g.dispose();
	}
	
	//Main game loop. + init etc.
	public void run(){
		
		init();
		
		//Sets the game loop to run at constant 60 frames.
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		long ticks = 0;
		
		//game loop
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
	
	public Camera getCamera(){
		return camera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
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
	
	//Ends the separate thread the game is running on.
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