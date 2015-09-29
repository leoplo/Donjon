package dungeon.item;

import dungeon.unit.Player;

public class Weapon extends Item {
	protected int damage;
	protected int maxDurability;
	protected int currentDurability;
	
	public Weapon(String name, int damage, int durability) {
		super(name);
		this.damage = damage;
		this.currentDurability = durability;
		this.maxDurability = durability;
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
	
	public void repare() {
		this.currentDurability = this.maxDurability;
	}
}
