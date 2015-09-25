package dungeon.room;

import dungeon.Player;

public class KeyRoom extends Room {
	
	public String getMessage(){
		if(this.visited)
			return super.toString();
		return "You entered in this room and you just found a key";
	}
	
	public void roomAction(Player player) {
		if (!this.visited){
			player.pickKey();
			super.roomAction(player);
		}
	}
}
