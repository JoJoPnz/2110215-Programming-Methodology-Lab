package logic;

import java.util.ArrayList;

import role.base.DayActable;
import role.base.NightActable;
import role.base.Player;

public class GameLogicUtility {
	public static void doNightAction(ArrayList<Player> targetPlayers) {
		ArrayList<Player> playerList = GameLogic.getInstance().getPlayerList();
		for (int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);
			if (player instanceof NightActable) {
				((NightActable) player).nightAction(targetPlayers.get(i));
			}
		}
	}
	
	public static void doDayAction(ArrayList<Player> targetPlayers) {
		ArrayList<Player> playerList = GameLogic.getInstance().getPlayerList();
		for (int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);
			if (player instanceof DayActable) {
				((DayActable) player).dayAction(targetPlayers.get(i));
			}
		}
	}
	
}
