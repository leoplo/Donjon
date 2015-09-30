package dungeon.room.exit;

/** the class {@code Exit} represents the different exits associated to a direction.
 */
public class Exit {
	protected boolean isHidden;
	protected boolean isLocked;
	
	public Exit(boolean hidden){
		this.isHidden = hidden;
		this.isLocked = false;
	}
	
	public Exit() {
		this(false);
	}
	
	public boolean isOpen() {
		return !this.isLocked;
	}
	
	public boolean isHidden(){
		return this.isHidden;
	}
	
	public String getMessage () {
		return "The exit is open";
	}
}
