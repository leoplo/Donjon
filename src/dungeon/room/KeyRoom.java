package dungeon.room;

public class KeyRoom extends Room {
	
	public String toString(){
		if(this.visited)
			return super.toString();
		return "You entered in this room and you just found a key";
	}
}
