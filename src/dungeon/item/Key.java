package dungeon.item;

import dungeon.unit.Player;

public class Key extends Item {
	public Key(String name) {
		super(name);
	}

	/**
	 * Pick the key.
	 * @param player the player who pick this key.
	 */
	public void itemAction(Player player) {
		player.pickKey(this);
	}
	
	public String getDescription() {
		return "Unlock an exit";
	}
}