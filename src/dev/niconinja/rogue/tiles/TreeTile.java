package dev.niconinja.rogue.tiles;

import dev.niconinja.rogue.gfx.Assets;

public class TreeTile extends Tile{

	public TreeTile(int id) {
		super(Assets.tree, id);
	}
	
	@Override
	public boolean isWalkable(){
		return false;
	}
}
