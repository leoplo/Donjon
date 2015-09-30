package dungeon.room;

import dungeon.unit.Player;
import dungeon.fight.Fight;
import dungeon.unit.Monster;


public class MonsterRoom extends Room {
	protected Monster monster;
	protected Fight combat;
	
	public MonsterRoom(Monster monster){
		super();
		this.monster = monster;
	}
	
	/**
	 * Start a Fight with the monster. When the player enter a room he pick all items in this room and triggered {@link dungeon.item#itemAction(Player player) itemAction} method.
	 * @param player the player who entered in this room and triggered the action.
	 */
	public void roomAction(Player player){
		super.roomAction(player);
		
		if (this.monster.isAlive()) {
			this.combat = new Fight(monster, player);
		}
	}
	
	public String getMessage(){
		if(this.monster.isDead())
			return super.getMessage();
		
		return super.getMessage() + " A monster (" + this.monster.getName() + ") is standing right here in front of you.";
	}
}