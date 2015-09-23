package dungeon.room;

import dungeon.Player;

public class MonsterRoom extends Room {
	protected int attackPoints;
	
	public MonsterRoom(int attackPoints){
		super();
		this.attackPoints = attackPoints;
	}
	
	public void attackPlayer(Player player){
		player.isAttacked(this.attackPoints);
	}
	
	public String toString(){
		return "You entered in a monster room, you've lost "+this.attackPoints+" helth points.";
	}
}
