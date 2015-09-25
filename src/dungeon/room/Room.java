package dungeon.room;

import java.util.*;

import dungeon.Player;

/**
 * The class <code>Room</code> represents a Dungeon room.
 */

public class Room {

	protected Map<String,Room> rooms;
	protected Map<String,Boolean> isLocked;
	protected boolean visited;
	protected boolean gameIsLost;
	protected boolean gameIsWin;
	
	public Room () {
		this.rooms = new HashMap<String,Room>();
		this.isLocked = new HashMap<String,Boolean>();
		this.gameIsLost = false;
		this.gameIsWin = false;
		this.rooms.put("north", null);
		this.rooms.put("south", null);
		this.rooms.put("west", null);
		this.rooms.put("east", null);
	}
	
	public Map<String,Room> getRooms(){
		return this.rooms;
	}

	public boolean addRoom (String direction, Room room) {
		return addRoom (direction, room, false);
	}
	
	public boolean addRoom (String direction, Room room, boolean locked) {
		if (direction == null || room == null)
			return false;
		this.rooms.put(direction, room);
		this.isLocked.put(direction, locked);
		return true;
	}
	
	/**
	 * This method returns the room associated to the chosen direction
	 * @param direction the chosen direction
	 * @exception InvalidParameterException if the direction doesn't exist
	 * @exception IllegalStateException if the door (of the direction) is locked
	 * @return the room associated to the chosen direction
	 */
	public Room goRoom (String direction) throws IllegalArgumentException, IllegalStateException {
		if (! this.rooms.containsKey(direction))
			throw new IllegalArgumentException();
		if (this.isLocked.containsKey(direction) && this.isLocked.get(direction)) // modif in Dungeon (try/catch) ?????????????????????????????????????????????????????????????????
			throw new IllegalStateException();
		return this.rooms.get(direction);
	}
	

	public boolean isWinningRoom () {
		return this.gameIsWin;
	}
	
	public boolean isLosingRoom () {
		return this.gameIsLost;
	}
	
	public String getMessage() {
		String newRoom = " ";
		if(!this.visited)
			newRoom = " new ";
		return "You entered in a"+newRoom+"room";
	}
	
	public Set<String> getDirections(){
	    return this.rooms.keySet();
	}
	
	public void roomAction(Player player){
		this.visited = true;
	}
}
