package dev.niconinja.rogue.tiles;

import java.awt.Graphics;

import dev.niconinja.rogue.gfx.Animation;
import dev.niconinja.rogue.gfx.Assets;

public class TreeTile extends Tile{
	
	private Animation animation;

	public TreeTile(int id) {
		super(id);
		animation = new Animation(746, Assets.tree);
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
