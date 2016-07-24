package dev.niconinja.rogue.entities;

import java.awt.Graphics;

//abstract class for all entities to inherit
public abstract class Entity {

	//Coordinates of the entity
	protected float x, y;
	
	public Entity(float x, float y){
		this. x = x;
		this.y = y;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
