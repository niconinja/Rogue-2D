package dev.niconinja.rogue.tiles;

import java.awt.Graphics;

import dev.niconinja.rogue.gfx.Animation;
import dev.niconinja.rogue.gfx.Assets;

public class WaterTile extends Tile{
	
	private Animation animation;

	public WaterTile(int id) {
		super(id);
		animation = new Animation(853, Assets.water);
	}

	@Override
	public boolean isWalkable(){
		return false;
	}
	
	@Override
	public void render(Graphics g, int x, int y){
		animation.tick();
		g.drawImage(animation.getCurrentFrame(), x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
}
