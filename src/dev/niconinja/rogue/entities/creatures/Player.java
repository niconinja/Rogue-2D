package dev.niconinja.rogue.entities.creatures;

//import java.awt.Color;
import java.awt.Graphics;

import dev.niconinja.rogue.Handler;
import dev.niconinja.rogue.gfx.Assets;

//creature that can be controlled.
public class Player extends Creature{
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//collision box for player image
		bounds.x = 11;
		bounds.y = 12;
		bounds.width = 10;
		bounds.height = 19;
	}

	@Override
	public void tick() {
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
	g.drawImage(Assets.player,(int) (x - handler.getCamera().getxOffset()),
			(int) (y - handler.getCamera().getyOffset()), width, height, null);
	//g.setColor(Color.green);
	//g.fillRect((int) (x + bounds.x - handler.getCamera().getxOffset()), 
	//		(int) (y + bounds.y - handler.getCamera().getyOffset()),
	//		bounds.width, bounds.height);
	}

}
