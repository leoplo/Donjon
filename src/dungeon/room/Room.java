package dungeon.room;

import java.util.*;
import dungeon.item.Item;
import dungeon.room.exit.Exit;
import dungeon.unit.Player;

/**
 * The class <code>Room</code> represents a Dungeon room. A room contains its neighbours.
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
	
	public Map<String,Room> getRooms(){
		return this.neighbours;
	}
	
	public void addRoom (String direction, Room room, Exit exit) {
		if (direction == null || room == null || room == null)
			throw new NullPointerException();
		this.neighbours.put(direction, room);
		this.exits.put(direction, exit);
	}
	
	/**
	 * This method returns the room associated to the chosen direction
	 * @param direction the chosen direction
	 * @exception InvalidParameterException if the direction doesn't exist
	 * @exception IllegalStateException if the door (of the direction) is locked
	 * @return the room associated to the chosen direction
	 */
	public Room goRoom (String direction) throws IllegalArgumentException, IllegalStateException {
		if (! this.neighbours.containsKey(direction))
			throw new IllegalArgumentException();
		if (! this.exits.get(direction).isOpen()) // modif in Dungeon (try/catch) ?????????????????????????????????????????????????????????????????
			throw new IllegalStateException();
		return this.neighbours.get(direction); // ???????????????????????????????????????????
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
	
	public void roomAction(Player player){
		if(!this.visited) {
			this.visited = true;
			
			for(Item i : this.itemsInTheRoom) {
				i.use(player);
			}
		}
	}
	
	public void addItemInTheRoom(Item itemToAdd) {
		this.itemsInTheRoom.add(itemToAdd);
	}
}
