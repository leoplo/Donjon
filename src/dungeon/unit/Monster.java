package dungeon.unit;

public class Monster extends Unit {
	protected int force;
	
	public Monster(String name, int maxHealthPoints, int force) {
		super(name, maxHealthPoints);
		this.force = force;
	}
	
	public void attack(Unit opponent) {
		opponent.currentHealthPoints -= this.force;
	}
}
