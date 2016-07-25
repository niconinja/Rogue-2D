package dev.niconinja.rogue.tiles;

import dev.niconinja.rogue.gfx.Assets;

public class WaterTile extends Tile{

	public WaterTile(int id) {
		super(Assets.water, id);
	}

	@Override
	public boolean isWalkable(){
		return false;
	}
}
