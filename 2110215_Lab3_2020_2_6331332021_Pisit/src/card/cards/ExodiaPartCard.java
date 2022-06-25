package card.cards;

import card.base.ItemCard;
import player.Player;

//You CAN modify the first line
public class ExodiaPartCard extends ItemCard {
	
	
	public ExodiaPartCard(String name, int defense) {
		super(name,
			"Assemble 4 of Exodia part card to win the game",
			0, 0, defense);
//		String description = "Assemble 4 of Exodia part card to win the game";
//		int lpBonus = 0;
//		int attackBonus = 0;

	}
	
	@Override
	public void equipItem(Player player) {
		player.addInventory(this);
		if (player.getAssignedCharacter() instanceof ExodiaCharacterCard) {
			player.setDefense(player.getDefense() + (2 * this.defenseBonus));
		}
		else {
			player.setDefense(player.getDefense() + this.defenseBonus);
		}
	}
	

}