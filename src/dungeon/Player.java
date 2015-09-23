package dungeon;

public class Player {
	protected int healthPoints;
	protected String name;
	protected boolean key = false;
	
	public Player (String name){
		this.name = name;
	}
	
	public void isAttacked(int attack){
		this.healthPoints -= attack;
	}
	
	public void isHeal(int heal){
		this.healthPoints += heal;
	}
	
	public boolean isDead(){
		return (this.healthPoints <= 0);
	}

	public boolean gotKey(){
		return this.key;
	}
	
	
}
