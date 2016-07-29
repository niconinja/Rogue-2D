package dev.niconinja.rogue.tiles;

import dev.niconinja.rogue.gfx.Assets;

public class GroundTile extends Tile{

	public GroundTile(int id) {
		super(id);
		setTexture(Assets.ground);
	}

}