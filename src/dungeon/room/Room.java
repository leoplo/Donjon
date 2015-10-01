package dungeon.room;

import java.util.*;
import dungeon.item.Item;
import dungeon.room.exit.Exit;
import dungeon.unit.Player;

/**
 * The class {@code Room} represents a Dungeon room. A room contains its neighbours.
 */

public class Room {

	protected Map<String,Room> neighbours;
	protected Map<String,Exit> exits;
	protected List<Item> itemsInTheRoom;
	protected boolean visited;
	protected boolean losingRoom;
	protected boolean winningRoom;
	
	public Room () {
		this.neighbours = new HashMap<String,Room>();
		this.exits = new HashMap<String,Exit>();
		this.itemsInTheRoom = new ArrayList<Item>();
		this.losingRoom = false;
		this.winningRoom = false;
	}
	
	/**
	 * Add a room this room neighbours.
	 * @param direction the direction of the new neighbour.
	 * @param room the new neighbour.
	 * @param exit the exit associated to the neighbour.
	 * @throws NullPointerException if one of the three parameters is {@code null}
	 */
	public void addRoom (String direction, Room room, Exit exit) {
		if (direction == null || room == null || exit == null)
			throw new NullPointerException();
		this.neighbours.put(direction, room);
		this.exits.put(direction, exit);
	}
	
	/**
	 * This method returns the room associated to the chosen direction
	 * @param direction the chosen direction
	 * @throws InvalidParameterException if the direction doesn't exist
	 * @throws IllegalStateException if the exit (in this direction) is locked
	 * @return the room associated to the chosen direction
	 */
	public Room getRoom(String direction) {
		return this.neighbours.get(direction);
	}
	
	public Exit getExit (String direction) {
		return this.exits.get(direction);
	}

	public boolean isWinningRoom () {
		return this.winningRoom;
	}
	
	public boolean isLosingRoom () {
		return this.losingRoom;
	}
	
	public String getMessage() {
		return "You entered in a " + ((!this.visited) ? "new " : "") + "room.";
	}
	
	public Set<String> getDirections(){
	    return this.neighbours.keySet();
	}
	
	/**
	 * Does the room action. When the player enter a room he pick all items in this room and triggered {@link dungeon.item#itemAction(Player player) itemAction} method.
	 * @param player the player who entered in this room and triggered the action.
	 */
	public String roomAction(Player player) {
		String message = "";
		if(!this.visited) {
			this.visited = true;
			
			for(Item i : this.itemsInTheRoom) {
				message += "You loot " + i.getName() + "(Description : " + i.getDescription() + ")\n";
				i.itemAction(player);
			}
		}
		
		return message;
	}
	
	public void addItemInTheRoom(Item itemToAdd) {
		this.itemsInTheRoom.add(itemToAdd);
	}
}
