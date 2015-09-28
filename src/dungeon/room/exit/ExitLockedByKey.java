package dungeon.room.exit;

import dungeon.item.Key;
import dungeon.unit.Player;

public class ExitLockedByKey extends LockedExit {
	protected Key associatedKey;
	
	public ExitLockedByKey(Key associatedKey) {
		super();
		this.associatedKey = associatedKey;
	}
	
	public String unlock(Player player) {
		if (player.hasKey(this.associatedKey))
			return super.unlock(player) + "with a key.";
		return "You need a key to unlock this exit.";
	}
}
