package dungeon.room;

import java.util.*;

/**
 * The class <code>Room</code> represents a Dungeon room.
 */

public class Room {

	// Attributs
	protected Map<String,Room> rooms;
	protected boolean gameIsLost;
	protected boolean gameIsWin;
	
	/**
	 * the Constructer, by default both boolean are initialized to <code>false</code>.
	 */
	public Room () {
		this.rooms = new HashMap<String,Room>();
		this.gameIsLost = false;
		this.gameIsWin = false;
	}
	
	/**
	 * This fonction adds a room with a specified direction to <code>this</code> room. <br/>
	 * If the direction has already been set, the new value replaces it.
	 * @param direction the direction associated to the room
	 * @param room the the room associated to the direction 
	 */
	public void addRoom (String direction, Room room) {
		this.rooms.put(direction, room);
	}
	
	/**
	 * This fonction returns the room associated to the chosen direction
	 * @param direction the chosen direction
	 * @exception InvalidParameterException if the direction doesn't exist
	 * @return the room associated to the chosen direction
	 */
	public Room goRoom (String direction) throws InvalidParameterException {
		Room room = this.rooms.get(direction);
		if (room == null)
			throw new InvalidParameterException();
		return room;
	}
	
	/**
	 * Check if the room is a winning room
	 * @return <code>true</code> if the room is a winning room, <code>false</code> else.
	 */
	public boolean isWinningRoom () {
		return this.gameIsWin;
	}
	
	/**
	 * Check if the room is a losing room
	 * @return <code>true</code> if the room is a losing room, <code>false</code> else.
	 */
	public boolean isLosingRoom () {
		return this.gameIsLost;
	}
}