package dungeon.room;

public class TrapRoom extends Room {
	public TrapRoom() {
		super();
		this.gameIsLost = true;
	}
	
	public String getMessage(){
		return "IT'S A TRAP !!! You fall down and scratch on the ground with violence.";
	}
}
