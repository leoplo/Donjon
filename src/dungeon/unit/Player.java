package dungeon.unit;

import java.util.ArrayList;

import dungeon.item.Key;
import dungeon.item.Weapon;

public class Player extends Unit {
	protected Weapon currentWeapon;
	protected ArrayList<Key> keys;
	
	public Player (String name, int healthPoints) {
		super(name, healthPoints);
		this.currentWeapon = new Weapon("Feeble Sword", 10, 50);
		this.keys = new ArrayList<Key>();
	}
	
	public void attack(Unit opponent) {
		opponent.currentHealthPoints -= this.currentWeapon.getDamage();
	}
	
	public void heal(int heal) {
		this.currentHealthPoints = Math.min(this.currentHealthPoints + heal,
											this.maxHealthPoints);
	}
	
	public void switchWeapon(Weapon newWeapon) {
		if(newWeapon.isBetterThan(this.currentWeapon)) {
			this.currentWeapon = newWeapon;
		}
	}

	public boolean hasKey(Key keyRequired){
		return this.keys.contains(keyRequired);
	}
	
	public void pickKey(Key foundKey) {
		this.keys.add(foundKey);
	}
	
	public Weapon getWeapon() {
		return this.currentWeapon;
	}
}
