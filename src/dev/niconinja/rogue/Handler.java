package dev.niconinja.rogue;

import dev.niconinja.rogue.gfx.Camera;
import dev.niconinja.rogue.input.KeyManager;
import dev.niconinja.rogue.worlds.World;

public class Handler {

	private Game game;
	private World world;
	
	public Handler(Game game){
		this.game = game;
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public Camera getCamera(){
		return game.getCamera();
	}
	
	//getters and setters
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}
