package dungeon.room.exit;

import dungeon.item.Key;
import dungeon.unit.Player;

public class ExitLockedByKey extends LockedExit {
	protected Key associatedKey;
	
	public ExitLockedByKey(Key associatedKey) {
		super();
		this.associatedKey = associatedKey;
	}
	
	public boolean unlock(Player player) {
		if (player.hasKey(this.associatedKey)) {
			super.unlock(player);
			return true;
		}
		return false;
	}
	
	public String getMessage () {
		return super.getMessage() + ", you need a key " + this.associatedKey.getName() +" to unlock this exit.";
	}
}
