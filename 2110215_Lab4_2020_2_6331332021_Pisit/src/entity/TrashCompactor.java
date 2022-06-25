package entity;

import entity.base.Consumable;
import entity.base.Entity;
import entity.base.Interactable;
import entity.base.Updatable;
import exception.IllegalValueException;
import logic.GameController;
import logic.Sprites;

public class TrashCompactor extends Entity implements Interactable, Consumable, Updatable{
	private int cooldown;
	
	public TrashCompactor() {
		this.cooldown = 0;
	}
	
	@Override
	public int getSymbol() {
		// TODO Auto-generated method stub
		if (cooldown == 0) {
			return Sprites.COMPACTOR_ON;
		}
		return Sprites.COMPACTOR_OFF;
	}
	
	@Override
	public boolean interact(Entity e) {
		// TODO Auto-generated method stub
		if (Entity.isBox(e) && cooldown == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean consume(Entity e) {
		// TODO Auto-generated method stub
		if (Entity.isBox(e) && cooldown == 0) {
			cooldown = GameController.MAX_COOLDOWN_TIME;
			return true;
		}
		return false;
	}


	@Override
	public void update() throws IllegalValueException {
		// TODO Auto-generated method stub
		if (cooldown > 0) {
			cooldown -= 1;
		}
		else if (cooldown < 0) {
			throw new IllegalValueException();
		}
	}

	@Override
	public void valueCorrection() {
		// TODO Auto-generated method stub
		cooldown = 0;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	
	
	
	
}
