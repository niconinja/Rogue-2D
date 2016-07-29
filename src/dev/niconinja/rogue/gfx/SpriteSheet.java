package dev.niconinja.rogue.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
		
	public BufferedImage split(int x, int y, int width, int height){
		return sheet.getSubimage(x, y, width, height);
	}
	
	public void setSheet(BufferedImage sheet){
		this.sheet = sheet;
	}
}
