package dungeon.item;

import dungeon.unit.Player;

public class Weapon extends Item {
	protected int damage;
	
	public Weapon(String name, int damage) {
		super(name);
		this.damage = damage;
	}
	
	/**
	 * Switch the weapon found if it's better than the current weapon.
	 * @param player the player who found the weapon
	 */
	public void itemAction(Player player) {
		player.switchWeapon(this);
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public boolean isBetterThan(Weapon weapon) {
		return weapon.damage > this.damage;
	}
	
	public String getDescription() {
			return "Whenever you'll hit an opponent with it, you'll deal " + this.damage + " damage.";
	}
}
