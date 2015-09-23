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
}
