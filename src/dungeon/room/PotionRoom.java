package dungeon.room;

import dungeon.Player;

public class PotionRoom extends Room {
	protected int heal;
	
	public PotionRoom(int heal){
		super();
		this.heal = heal;
	}
	
	public void healPlayer(Player player){
		player.isHeal(this.heal);
	}

	public String toString() {
		return "You entered in a new room and you found a potion, you are heal by "+this.heal+" helth points";
	}
}
