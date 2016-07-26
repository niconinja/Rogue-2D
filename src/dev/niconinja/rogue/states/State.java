package dev.niconinja.rogue.states;

import java.awt.Graphics;
import dev.niconinja.rogue.Handler;

public abstract class State {
	
	//State-manager
	private static State currentState = null;
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	
	
	//actual Class	
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public abstract void tick();
		
	public abstract void render(Graphics g);
		
}
