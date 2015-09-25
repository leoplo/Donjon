package dungeon.room;

public class ExitRoom extends Room {
	public ExitRoom(){
		super();
		this.winningRoom = true;
	}
	
	public String getMessage(){
		return "You escape this dungeon !";
	}
}
