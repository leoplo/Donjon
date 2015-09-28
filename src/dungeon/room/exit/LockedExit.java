package dungeon.room.exit;

import dungeon.unit.Player;

public abstract class LockedExit extends Exit {

	public String unlock(Player player){
		this.locked = false;
		return "You've unlocked the exit.";
	}
}
