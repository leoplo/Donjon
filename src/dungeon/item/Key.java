package dungeon.item;

import dungeon.unit.Player;

public class Key extends Item {
	public Key(String name) {
		super(name);
	}

	@Override
	public void use(Player player) {
		player.pickKey(this);
	}
}