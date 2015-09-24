package dungeon.room;


public class MonsterRoom extends Room {
	protected int attackPoints;
	
	public MonsterRoom(int attackPoints){
		super();
		this.attackPoints = attackPoints;
	}
	
	public void roomAction(){
		if (!this.visited){
			this.player.isAttacked(this.attackPoints);
			super.roomAction();
		}
	}
	
	public String toString(){
		if(this.visited)
			return super.toString();
		return super.toString() +", a monster is standing right here in front of you, you loose "+this.attackPoints+" helth points.";
	}
}
