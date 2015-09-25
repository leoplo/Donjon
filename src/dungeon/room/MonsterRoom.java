package dungeon.room;

import java.util.Random;

import dungeon.Player;


public class MonsterRoom extends Room {
	protected int attackPoints;
	
	public MonsterRoom(int attackPointsMax, int attackPointsMin){
		super();
		this.attackPoints = attackPointsMin + (new Random()).nextInt(attackPointsMax - attackPointsMin+1);
	}
	
	public void roomAction(Player player){
		if (!this.visited){
			player.attacked(this.attackPoints);
			super.roomAction(player);
		}
	}
	
	public String getMessage(){
		if(this.visited)
			return super.toString();
		return super.toString() +", a monster is standing right here in front of you, you loose "+this.attackPoints+" helth points.";
	}
}
