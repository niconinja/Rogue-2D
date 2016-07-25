package dev.niconinja.rogue.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//all tiles array
	public static Tile[] tiles = new Tile[16];
	
	public static Tile wallTile = new WallTile(0);
	public static Tile groundTile = new GroundTile(1);
	public static Tile treeTile = new TreeTile(2);
	public static Tile waterTile = new WaterTile(3);
	
	
	//Class	
	public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;

	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean isWalkable(){
		return true;
	}
	
	public int getId(){
		return id;
	}
	
}
