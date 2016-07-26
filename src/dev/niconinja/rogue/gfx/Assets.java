package dev.niconinja.rogue.gfx;

import java.awt.image.BufferedImage;

//Splits the spritesheet.
public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage mage, warrior, thief, archer, wall, ground, tree, water, player;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/allTextures.png"));
		
		mage = sheet.split(0, 0, width, height);
		warrior = sheet.split(width, 0, width, height);
		thief = sheet.split(width * 2, 0, width, height);
		archer = sheet.split(width * 3, 0, width, height);
		wall = sheet.split(0, height, width, height);
		ground = sheet.split(width, height, width, height);
		tree = sheet.split(width * 2, height, width, height);
		water = sheet.split(width * 3, height, width, height);
		player = sheet.split(0, height * 2, width, height);
	}

}
