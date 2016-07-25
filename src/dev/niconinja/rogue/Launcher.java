package dev.niconinja.rogue;

//Starts the game.
public class Launcher {
	public static void main(String[] args){
		//Creates a new game and starts it.
		Game game = new Game("Rogue", 1024, 512);
		game.start();
	}
}
