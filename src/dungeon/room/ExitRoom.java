package dungeon.room;

public class ExitRoom extends Room {
	public ExitRoom(){
		super();
		this.gameIsWin = true;
	}
	
	public String getMessage(){
		return "You escape this dungeon !";
	}
}
