package dev.niconinja.rogue.states;

import java.awt.Graphics;

import dev.niconinja.rogue.Game;

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
	protected Game game;
	
	public State(Game game){
		this.game = game;
	}
	
	public abstract void tick();
		
	public abstract void render(Graphics g);
		
}
