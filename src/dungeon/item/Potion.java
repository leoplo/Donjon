package dungeon.item;

import dungeon.unit.Player;

public class Potion extends Item {
	protected int healthPointsRestored;

	public Potion(String name, int healthPoints) {
		super(name);
		this.healthPointsRestored = healthPoints;
	}
	
	/**
	 * Heal the player.
	 * @param player the player who is healed.
	 */
	public void itemAction(Player player) {
		player.heal(this.healthPointsRestored);
	}

	public String getDescription() {
		return "Restores " + this.healthPointsRestored + " health points.";
	}
}