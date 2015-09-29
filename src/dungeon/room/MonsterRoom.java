package dungeon.room;

import dungeon.unit.Player;
import dungeon.combat.Combat;
import dungeon.unit.Monster;


public class MonsterRoom extends Room {
	protected Monster monster;
	protected Combat combat;
	
	public MonsterRoom(Monster monster){
		super();
		this.monster = monster;
	}
	
	public void roomAction(Player player){
		super.roomAction(player);
		
		if (this.monster.isAlive()) {
			this.combat = new Combat(monster, player);
		}
	}
	
	public String getMessage(){
		if(this.monster.isDead())
			return super.getMessage();
		
		return super.getMessage() + " A monster (" + this.monster.getName() + ") is standing right here in front of you.";
	}
}