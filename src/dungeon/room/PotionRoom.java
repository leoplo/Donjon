package dungeon.room;

import dungeon.Player;

public class PotionRoom extends Room {
	protected int heal;
	
	public PotionRoom(int heal){
		super();
		this.heal = heal;
	}
	
	public void healPlayer(Player player){
		if (!this.visited)
			player.isHeal(this.heal);
	}

	public String toString() {
		if(this.visited)
			return super.toString();
		return super.toString()+ "where you find a potion, you are heal by "+this.heal+" helth points";
	}
}
