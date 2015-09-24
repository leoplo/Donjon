package dungeon.room;

public class PotionRoom extends Room {
	protected int heal;
	
	public PotionRoom(int heal){
		super();
		this.heal = heal;
	}

	public String toString() {
		if(this.visited)
			return super.toString();
		return super.toString()+ "where you find a potion, you are heal by "+this.heal+" helth points";
	}
	
	public void roomAction() {
		if(!this.visited) {
			this.player.isHeal(this.heal);
			super.roomAction();
		}
	}
}
