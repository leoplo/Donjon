package dungeon.room.exit;

/** the class {@code Exit} represents the different exits associated to a direction.
 */
public class Exit {
	protected boolean isHidden;
	
	public Exit(boolean isHidden){
		this.isHidden = isHidden;
	}
	
	public Exit() {
		this(false);
	}
	
	public boolean isOpen() {
		return true;
	}
	
	public boolean isHidden(){
		return this.isHidden;
	}
	
	public String getMessage () {
		return "The exit is open";
	}
}
