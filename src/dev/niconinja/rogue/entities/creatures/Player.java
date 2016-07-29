package dev.niconinja.rogue.entities.creatures;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.niconinja.rogue.Handler;
import dev.niconinja.rogue.gfx.*;

//creature that can be controlled.
public class Player extends Creature{
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//collision box for player image
		bounds.x = 11;
		bounds.y = 12;
		bounds.width = 10;
		bounds.height = 19;
		
		//Animations
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
	}

	@Override
	public void tick() {
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		getInput();
		move();
		handler.getCamera().centerOnEntity(this);
	}

	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up){
			yMove = -speed;
		}
		if(handler.getKeyManager().down){
			yMove = speed;
		}
		if(handler.getKeyManager().left){
			xMove = -speed;
		}
		if(handler.getKeyManager().right){
			xMove = speed;
		}
	}
	
	@Override
	public void render(Graphics g) {
	g.drawImage(getCurrentAnim(),(int) (x - handler.getCamera().getxOffset()),
			(int) (y - handler.getCamera().getyOffset()), width, height, null);
	}
	
	private BufferedImage getCurrentAnim(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			return animUp.getCurrentFrame();
		}else{
			return animDown.getCurrentFrame();
		}
	}
}

