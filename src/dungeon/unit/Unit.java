package dungeon.unit;

public abstract class Unit {
	protected String name;
	protected int currentHealthPoints;
	protected int maxHealthPoints;
	
	public Unit(String name, int maxHealthPoints) {
		this.name = name;
		this.maxHealthPoints = maxHealthPoints;
		this.currentHealthPoints = maxHealthPoints;
	}
	
	public boolean isDead() {
		return (this.currentHealthPoints <= 0);
	}
	
	public boolean isAlive() {
		return !this.isDead();
	}
	
	public String getName() {
		return this.name;
	}
	
	public abstract void attack(Unit opponent);
	
	public String toString() {
		return this.name + " : " + this.currentHealthPoints + " HP.";
	}
}
