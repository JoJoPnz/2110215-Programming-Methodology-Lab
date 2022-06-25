package role.derived;

import role.base.DayActable;
import role.base.NightActable;
import role.base.Player;

public class Detective extends Player implements DayActable, NightActable {

	public Detective(String playerName) {
		super(playerName);
	}

	@Override
	public void nightAction(Player targetPlayer) {
		// TODO Auto-generated method stub
		String targetName = targetPlayer.getPlayerName();
		if (targetPlayer instanceof Mafia) {
			System.out.println(targetName + " is the Mafia boss");
		}
		else {
			System.out.println(targetName + " is not the Mafia boss");
		}
	}

	@Override
	public void dayAction(Player targetPlayer) {
		// TODO Auto-generated method stub
		String targetName = targetPlayer.getPlayerName();
		if (targetPlayer instanceof Mayor) {
			System.out.println(targetName + " is the Mayor");
		}
		else {
			System.out.println(targetName + " is not the Mayor");
		}
	}

}
