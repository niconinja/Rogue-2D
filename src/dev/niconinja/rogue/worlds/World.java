package dev.niconinja.rogue.worlds;

import java.awt.Graphics;
import dev.niconinja.rogue.Handler;
import dev.niconinja.rogue.utilities.*;
import dev.niconinja.rogue.tiles.Tile;

public class World {
	
	private Handler handler;
	private int width, height;
	//private int spawnX, spawnY;
	private int[][] map;
	
	public World(Handler handler, String path){
		this.handler = handler;
		loadWorld(path);
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getCamera().getxOffset()/ Tile.TILE_WIDTH);
		int yStart = (int) Math.max(0, handler.getCamera().getyOffset()/ Tile.TILE_HEIGHT);
		int xEnd = (int) Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yEnd = (int) Math.min(height, (handler.getCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart; x < xEnd; x++){
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getCamera().getxOffset()), 
						(int) (y * Tile.TILE_HEIGHT - handler.getCamera().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height){
			return Tile.groundTile;
		}
		
		Tile t = Tile.tiles[map[x][y]];
		if(t == null){
			return Tile.groundTile;
		}
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utilities.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utilities.parseInt(tokens[0]);
		height = Utilities.parseInt(tokens[1]);
		//spawnX = Utilities.parseInt(tokens[2]);
		//spawnY = Utilities.parseInt(tokens[3]);
		
		map = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				map[x][y] = Utilities.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}

	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}