package dev.niconinja.rogue;

//Starts the game.
public class Launcher {
	public static void main(String[] args){
		Game game = new Game("Test", 900, 600);
		game.start();
	}
}
