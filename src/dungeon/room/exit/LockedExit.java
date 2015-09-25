package dungeon.room.exit;

import dungeon.Player;

public abstract class LockedExit extends Exit {
	
	
	public String unlock(Player player){
		this.isLocked = false;
		return "You've unlocked the exit ";
	}
}
