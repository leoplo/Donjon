package dungeon.room.exit;

import dungeon.Player;

public class ExitLockedByKey extends LockedExit{
	
	public String unlock(Player player) {
		if (player.giveKey())
			return super.unlock(player)+"with a key.";
		return "You need a key to unlock this exit.";
	}
}
