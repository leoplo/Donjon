package dungeon.room;

import dungeon.unit.Player;

public class ArmoryRoom extends Room {
	
	public void roomAction(Player player) {
		player.getWeapon().repare();
	}
}
