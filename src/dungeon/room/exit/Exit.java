package dungeon.room.exit;

public class Exit {
	protected boolean hidden;
	protected boolean locked;
	
	public Exit(boolean hidden){
		this.hidden = hidden;
		this.locked = false;
	}
	
	public Exit() {
		this(false);
	}
	
	public boolean isOpen() {
		return !this.locked;
	}
	
	public boolean isHidden(){
		return this.hidden;
	}
}
