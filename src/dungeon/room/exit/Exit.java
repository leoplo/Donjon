package dungeon.room.exit;

public class Exit {
	protected boolean hidden;
	protected boolean isLocked;
	
	public Exit(boolean hidden){
		this.hidden = hidden;
		this.isLocked = false;
	}
	
	public Exit() {
		new Exit(false);
	}
	
	public boolean isOpen() {
		return !this.isLocked;
	}
	
	public boolean isHidden(){
		return this.hidden;
	}
}
