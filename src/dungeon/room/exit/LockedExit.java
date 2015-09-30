package dungeon.room.exit;

import dungeon.unit.Player;

public abstract class LockedExit extends Exit {

	public boolean unlock(Player player){
		this.isLocked = false;
		return true;
	}
	
	public String getMessage () {
		return "The exit is locked";
	}
}
