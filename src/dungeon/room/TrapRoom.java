package dungeon.room;

/** the class {@code TrapRoom}, when the player enter in a {@code TrapRoom} he loose the game. 
 */
public class TrapRoom extends Room {
	public TrapRoom() {
		super();
		this.losingRoom = true;
	}
	
	public String getMessage(){
		return "IT'S A TRAP !!! You fall down and scratch on the ground with violence.";
	}
}
