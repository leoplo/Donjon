package dungeon;

import java.util.Set;

import dungeon.room.*;
import dungeon.room.exit.Exit;
import dungeon.unit.*;

/**
 * The class <code>Dungeon</code> represents a dungeon game containing Rooms.
 */

public class Dungeon {
	
	protected Player player;
	protected Room currentRoom;
	
	public Dungeon (Room startingRoom, Player player) {
		this.currentRoom = startingRoom;
		this.player = player;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	
	/**
	 * Interprets the user's command and executes it
	 * @param command the user's command
	 * @return result
	 */
	public String interpretCommand(String command) {
		String[] parameters = command.trim().split("\\s+");
		String result;
		
		switch(parameters[0]) {
			case "go":
				result = (parameters.length >= 2) ? this.changingRoom(parameters[1]) : "Where?";
				break;
			case "infos":
				result = this.movementsPossibilities();
				break;
			default:
				result = "I don't know what you mean";
		}
		
		return result;
	}
	
	
	public String changingRoom(String direction) {
		Room nextRoom = this.currentRoom.getRoom(direction);
		if (nextRoom == null) {
			return "No direction associated.";
		}
		
		Exit exit = this.currentRoom.getExit(direction);
		if (!exit.isOpen()) {
			return exit.getMessage();
		}
		
		this.currentRoom = nextRoom;
		String result = this.currentRoom.getMessage();
		this.currentRoom.roomAction(player);
		return result;
	}
	
	public boolean gameIsFinished() {
		return  this.currentRoom.isWinningRoom() || this.currentRoom.isLosingRoom();
	}
	
	public boolean gameIsWon() {
		return this.currentRoom.isWinningRoom() && this.player.isAlive();
	}
	
	/**
	 * Give all directions you can choose
	 */
	public String movementsPossibilities(){
	    Set<String> directions = this.currentRoom.getDirections();
	    String message = "";
	    
	    for (String direction : directions) {
	    	if(this.currentRoom.getRoom(direction) != null)
	    		message += "-" +  direction + "\n";
	    }
	    
	    return("All directions you can choose:\n" + message);
	}
}
