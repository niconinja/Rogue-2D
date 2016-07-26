package dev.niconinja.rogue.states;

import java.awt.Graphics;
import dev.niconinja.rogue.Handler;
import dev.niconinja.rogue.entities.creatures.Player;
import dev.niconinja.rogue.worlds.World;

public class GameState extends State {

	private Player player;
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.map");
		handler.setWorld(world);
		player = new Player(handler, 0, 0);
	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
