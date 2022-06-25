package entity;

import entity.base.Entity;
import entity.base.Interactable;
import entity.base.Updatable;
import exception.IllegalValueException;
import logic.GameController;
import logic.Sprites;

public class Switch extends Entity implements Interactable, Updatable{
	private boolean isActive;
	
	public Switch() {
		isActive = GameController.getGameSwitchStatus();
	}
	
	@Override
	public int getSymbol() {
		// TODO Auto-generated method stub
		if (isActive) {
			return Sprites.SWITCH_ON;
		}
		return Sprites.SWITCH_OFF;
	}
	
	@Override
	public boolean interact(Entity e) {
		// TODO Auto-generated method stub
		if (e instanceof Player) {
			GameController.setGameSwitchStatus(!GameController.getGameSwitchStatus());
		}
		return false;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		isActive = GameController.getGameSwitchStatus();
	}

	@Override
	public void valueCorrection() {
		// TODO Auto-generated method stub
		
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	

	

	
}
