package dungeon.room;

import dungeon.Player;

public class HealRoom extends Room {
	protected int heal;
	
	public HealRoom(int heal){
		super();
		this.heal = heal;
	}

	public String getMessage() {
		if(this.visited)
			return super.toString();
		return super.toString()+ "where you find a potion, you are heal by "+this.heal+" helth points";
	}
	
	public void roomAction(Player player) {
		if(!this.visited) {
			player.healed(this.heal);
			super.roomAction(player);
		}
	}
}
