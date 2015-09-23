package dungeon.room;

import java.util.*;

/**
 * The class <code>Room</code> represents a Dungeon room.
 */

public class Room {

	protected Map<String,Room> rooms;
	protected boolean gameIsLost;
	protected boolean gameIsWin;
	
	public Room () {
		this.rooms = new HashMap<String,Room>();
		this.gameIsLost = false;
		this.gameIsWin = false;
		this.rooms.put("north", null);
		this.rooms.put("south", null);
		this.rooms.put("west", null);
		this.rooms.put("east", null);
	}


	public void addRoom (String direction, Room room) {
		this.rooms.put(direction, room);
	}
	
	/**
	 * This method returns the room associated to the chosen direction
	 * @param direction the chosen direction
	 * @exception InvalidParameterException if the direction doesn't exist
	 * @return the room associated to the chosen direction
	 */
	public Room goRoom (String direction) throws IllegalArgumentException {
		if (! this.rooms.containsKey(direction))
			throw new IllegalArgumentException();
		return this.rooms.get(direction);
	}
	

	public boolean isWinningRoom () {
		return this.gameIsWin;
	}
	
	public boolean isLosingRoom () {
		return this.gameIsLost;
	}
	
	public String getMessage() {
		return "You entered in a room";
	}
}
