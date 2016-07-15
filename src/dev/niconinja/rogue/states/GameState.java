package dev.niconinja.rogue.states;

import java.awt.Graphics;

import dev.niconinja.rogue.Game;
import dev.niconinja.rogue.entities.creatures.Player;

public class GameState extends State {

	private Player player;
	
	public GameState(Game game){
		super(game);
		player = new Player(game, 100, 100);
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}

}
