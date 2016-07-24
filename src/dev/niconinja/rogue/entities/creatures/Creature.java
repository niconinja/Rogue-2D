package dev.niconinja.rogue.entities.creatures;

import dev.niconinja.rogue.entities.*;

//abstract class for all creatures to inherit.
public abstract class Creature extends Entity{

	//all creatures have a health counter
	protected int health;
	
	public Creature(float x, float y) {
		super(x, y);
		health = 10;
	}
}
