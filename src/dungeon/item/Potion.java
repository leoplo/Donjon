package dungeon.item;

import dungeon.unit.Player;

public class Potion extends Item {
	protected int healthPointsRestored;

	public Potion(String name, int healthPoints) {
		super(name);
		this.healthPointsRestored = healthPoints;
	}
	
	@Override
	public void use(Player player) {
		player.heal(this.healthPointsRestored);
	}
	
	public String getDescription() {
		return "Restores " + this.healthPointsRestored + " health.";
	}
}