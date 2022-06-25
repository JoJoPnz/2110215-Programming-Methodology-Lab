package card.cards;

import card.base.CharacterCard;
import player.Player;

//You CAN modify the first line
public class MainCharacterCard extends CharacterCard {
	protected int level;
	protected float levelUpBonus;
	
	public MainCharacterCard(String name, String description, int lifePoint, int attackPoint, int defensePoint,float levelUpBonus) {
		super(name, description, lifePoint, attackPoint, defensePoint);
		this.levelUpBonus = levelUpBonus;
		this.level = 0;
	}
	
	public int sacrifice(Player player) {
		int healAmount = player.getMaxLifePoint()/8;
		player.healPlayer(healAmount);
		return healAmount;
	}
	
	
	public  float levelUp(Player player) {
		player.setNewCharacterLifePoint( (int) (player.getMaxLifePoint()*(levelUpBonus + 1)) );
		player.setAttack( (int) (player.getAttack()*(levelUpBonus + 1)) );
		player.setDefense( (int) (player.getDefense()*(levelUpBonus + 1)) );
		level += 1;
		return levelUpBonus;
	}
	
	@Override
	public String getName() {
		return super.getName() + " [level " + this.getLevel() + "]";
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
	
	
}
