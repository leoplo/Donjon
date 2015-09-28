package dungeon.item;

import dungeon.unit.Player;

public class Weapon extends Item {
	protected int damage;
	
	public Weapon(String name, int damage) {
		super(name);
		this.damage = damage;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	@Override
	public void use(Player player) {
		player.switchWeapon(this);
	}
	
	public boolean isBetterThan(Weapon weapon) {
		return weapon.damage > this.damage;
	}
}
