package dungeon.room;

public class TrapRoom extends Room {
	public TrapRoom() {
		super();
		this.gameIsLost = true;
	}
	
	public String toString(){
		return "IT'S A TRAP !!! You fall down and scratch on the ground with violence.";
	}
}
