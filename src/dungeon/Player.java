package dungeon;

public class Player {
	protected int healthPoints;
	protected String name;
	protected int key;
	
	public Player (String name){
		this.name = name;
		this.healthPoints = 100;
		this.key = 0;
	}
	
	public void attacked(int attack){
		this.healthPoints -= attack;
	}
	
	public void healed(int heal){
		this.healthPoints += heal;
	}
	
	public boolean isDead(){
		return (this.healthPoints <= 0);
	}

	public boolean gotKey(){
		return this.key > 0;
	}

	public String toString(){
		return this.name+", "+this.healthPoints+" health points left.";
	}
	
	public void pickKey() {
		this.key++;
	}
	
}
