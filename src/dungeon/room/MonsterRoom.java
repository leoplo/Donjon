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
	public String roomAction(Player player){
		String message = super.roomAction(player);
		
		if (this.monster.isAlive()) {
			message += "A fight begin between " + this.monster.getName() + " and you.\n";
			this.combat = new Fight(monster, player);
			message += "The winner is " + this.combat.getWinner().getName();
		}
		
		return message;
	}
	
	public String getMessage(){
		if(this.monster.isDead())
			return super.getMessage();
		
		return super.getMessage() + " A monster (" + this.monster.getName() + ") is standing right here in front of you.";
	}
}