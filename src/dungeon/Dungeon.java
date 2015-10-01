package dungeon;

import java.util.Set;

import dungeon.room.*;
import dungeon.room.exit.Exit;
import dungeon.room.exit.LockedExit;
import dungeon.unit.*;

/**
 * The class <code>Dungeon</code> represents a dungeon game containing Rooms and a Player.
 */

public class Dungeon {
	
	protected Player player;
	protected Room currentRoom;
	protected boolean userGiveUp = false;
	
	public Dungeon (Room startingRoom) {
		this.currentRoom = startingRoom;
	}
	
	/**
	 * initialize the player in the dungeon
	 * @param player to add in the dungeon
	 * @return a string to be print with the answer of the first room
	 */
	public String startDungeon(Player player) {
		this.player = player;
		return this.doActionRoomAndGetMessage();
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	
	/**
	 * Interprets the user's command and executes it
	 * @param command the user's command
	 * @return the command interpretation
	 */
	public String interpretCommand(String command) {
		if(command.isEmpty()) {
			return "Say somethings !";
		}
		
		String[] parameters = command.trim().split("\\s+");
		String message;
		
		switch(parameters[0]) {
			case "go":
				String remainder = command.substring(parameters[0].length()).trim();
				message = (!remainder.isEmpty()) ? this.changingRoom(remainder) : "Where ?";
				break;
			case "infos":
				message = this.movementsPossibilities(true);
				break;
			case "quit":
				message = "You give up !";
				this.userGiveUp = true;
				break;
			default:
				message = "I don't know what you mean.";
		}
		
		return message;
	}
	
	/**
	 * Changes the room and go to the direction 
	 * @param direction the direction where the player will go
	 * @return a string to be print with the answer :
	 * 			"No direction associated." if the direction is not available.
	 * 			the exit's message if the exit is locked.
	 * 			the new room's message if the player changes room.
	 */
	public String changingRoom(String direction) {
		Room nextRoom = this.currentRoom.getRoom(direction);
		
		if (nextRoom == null) {
			return "No direction associated.";
		}
		
		String message = "";
		boolean exitUnlock = true;
		Exit exit = this.currentRoom.getExit(direction);
		if (!exit.isOpen()) {
			exitUnlock = ((LockedExit) exit).unlock(player);
			message = exit.getMessage();
		}
		
		if(exitUnlock) {
			this.currentRoom = nextRoom;
			message += this.doActionRoomAndGetMessage();
		}
		return message;
	}

	public String doActionRoomAndGetMessage() {
		String message = this.currentRoom.getMessage();
		message += this.currentRoom.roomAction(player);
		if(player.isAlive() && !this.gameIsFinished())
			message += this.movementsPossibilities(false);
		return message;
	}
	
	public boolean gameIsFinished() {
		return  this.currentRoom.isWinningRoom() || this.currentRoom.isLosingRoom() || this.player.isDead() ||this.userGiveUp;
	}
	
	public boolean gameIsWon() {
		return this.currentRoom.isWinningRoom() && this.player.isAlive();
	}
	
	/**
	 * Give all directions you can choose
	 * @return a string made of all possible directions.
	 */
	public String movementsPossibilities(boolean seeHiddenExits){
	    Set<String> directions = this.currentRoom.getDirections(seeHiddenExits);
	    String message = "";
	    
	    for (String direction : directions) {
	    	if(this.currentRoom.getRoom(direction) != null)
	    		message += "-" +  direction + "\n";
	    }
	    if (message.isEmpty())
	    	message = "No direction to display.";
	    
	    return("All " + (seeHiddenExits ? "hiddens" : "visibles") + " directions you can choose :\n" + message);
	}
}
