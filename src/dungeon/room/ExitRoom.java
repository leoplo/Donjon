package dungeon.room;

/** the class {@code ExitRoom}, when the player enter in a {@code ExitRoom} he win the game. 
 */
public class ExitRoom extends Room {
	public ExitRoom(){
		super();
		this.winningRoom = true;
	}
	
	public String getMessage(){
		return "You escape this dungeon !";
	}
}
