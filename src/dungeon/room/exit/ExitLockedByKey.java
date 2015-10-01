package dungeon.room.exit;

import dungeon.item.Key;
import dungeon.unit.Player;

public class ExitLockedByKey extends LockedExit {
	protected Key associatedKey;
	
	public ExitLockedByKey(boolean isHidden, Key associatedKey) {
		super(isHidden);
		this.associatedKey = associatedKey;
	}
	
	public boolean unlock(Player player) {
		if (player.hasKey(this.associatedKey)) {
			return super.unlock(player);
		}
		return false;
	}
	
	public String getMessage () {
		return super.getMessage() + ", you need " + this.associatedKey.getName() +" to unlock this exit.\n";
	}
}
