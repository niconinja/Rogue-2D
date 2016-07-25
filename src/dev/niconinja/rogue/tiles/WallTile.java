package dev.niconinja.rogue.tiles;

import dev.niconinja.rogue.gfx.Assets;

public class WallTile extends Tile{

	public WallTile(int id) {
		super(Assets.wall, id);
	}

	@Override
	public boolean isWalkable(){
		return false;
	}
}
