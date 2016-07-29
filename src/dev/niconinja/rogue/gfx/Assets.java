package dev.niconinja.rogue.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage mage, warrior, thief, archer, wall, ground;;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] tree, water;
	
	
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet();
		
		sheet.setSheet(ImageLoader.loadImage("/textures/Player.png"));
		player_down = new BufferedImage[2];
		player_down[0] = sheet.split(0, 0, width, height);
		player_down[1] = sheet.split(width, 0, width, height);
		
		player_up = new BufferedImage[2];
		player_up[0] = sheet.split(width * 2, 0, width, height);
		player_up[1] = sheet.split(width * 3, 0, width, height);
		
		player_left = new BufferedImage[2];
		player_left[0] = sheet.split(0 , height, width, height);
		player_left[1] = sheet.split(width, height, width, height);
		
		player_right = new BufferedImage[2];
		player_right[0] = sheet.split(width * 2, height, width, height);
		player_right[1] = sheet.split(width * 3, height, width, height);
		
		sheet.setSheet(ImageLoader.loadImage("/textures/Classes.png"));
		mage = sheet.split(0, 0, width, height);
		warrior = sheet.split(width, 0, width, height);
		thief = sheet.split(width * 2, 0, width, height);
		archer = sheet.split(width * 3, 0, width, height);
		
		sheet.setSheet(ImageLoader.loadImage("/textures/Tiles.png"));
		wall = sheet.split(0, 0, width, height);
		ground = sheet.split(width, 0, width, height);
		
		tree = new BufferedImage[2];
		tree[0] = sheet.split(width * 2, 0, width, height);
		tree[1] = sheet.split(width * 2, height, width, height);
		
		water = new BufferedImage[2];
		water[0] = sheet.split(width * 3, 0, width, height);
		water[1] = sheet.split(width * 3, height, width, height);
	}

}
