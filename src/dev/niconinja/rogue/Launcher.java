package dev.niconinja.rogue;

//Starts the game.
public class Launcher {
	public static void main(String[] args){
		//Creates a new game and starts it.
		Game game = new Game("Rogue", 900, 600);
		game.start();
	}
}
