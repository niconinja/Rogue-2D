package dev.niconinja.rogue.gfx;

import dev.niconinja.rogue.Handler;
import dev.niconinja.rogue.entities.Entity;
import dev.niconinja.rogue.tiles.Tile;
//import dev.niconinja.rogue.worlds.World;

public class Camera {

	private Handler handler;
	private float xOffset, yOffset;
	
	public Camera(Handler handler, float xOffset,float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlank();
	}

	public void centerOnEntity(Entity e){
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2+ e.getHeight() / 2;
		checkBlank();
	}
	
	public void checkBlank(){
		if(xOffset < 0){
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth()){
			xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
		}
		
		if(yOffset < 0){
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()){
			yOffset = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
		}
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
}
