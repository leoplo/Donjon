package dungeon;


import java.util.*;

import dungeon.item.*;
import dungeon.room.*;
import dungeon.util.*;
import dungeon.unit.*;

/**
 * The class <code>Dungeon</code> represents a dungeon game containing Rooms.
 */

public class Dungeon {
	
	protected Player player;
	protected Room currentRoom = new Room();
	protected final ConsoleInterface console = new ConsoleInterface();
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	/**
	 * Interprets the user's command and executes it
	 * @param command the user's command
	 */
	public void changingRoom(String direction) {
		try {
			Room nextRoom = this.currentRoom.goRoom(direction);
			this.console.printMessage("You are in a new dungeon");
			this.currentRoom = nextRoom;
			this.console.printMessage(this.currentRoom.getMessage());
			this.currentRoom.roomAction(player);
			this.console.printMessage(this.player.toString());
		} catch (IllegalArgumentException e) {
			this.console.printMessage("I don't know what you mean");
		}
	}

	public boolean start() {
		this.console.printMessage(this.currentRoom.getMessage());
		this.currentRoom.roomAction(player);
		this.console.printMessage(this.player.toString());
		do {
			this.console.printMessage("What do you want to do now ?");
			// Read a command from the user (stdin)
			String line = console.readCommand();
			if(!line.equals("infos")) {
				changingRoom(line);
			} else
				console.printMessage(this.movementsPossibilities());
		} while (!gameIsFinished());
		if (this.currentRoom.isWinningRoom()) {
			this.console.printMessage("You win !");
			return true;
		} else {
			this.console.printMessage("You loose !");
			return false;
		}
	}
	
	public boolean gameIsFinished() {
		return  this.currentRoom.isWinningRoom() || this.currentRoom.isLosingRoom();
	}
	
	public void initializeLevel1 () {
		Room entryRoom = new Room();
		Room room1 = new Room();
		Room roomWithMonster = new MonsterRoom(new Monster("Orc", 20, 6));
		Room roomWithPotion = new Room();
		roomWithPotion.addItemInTheRoom(new Potion("Healing Potion", 10));
		Room exitRoom = new ExitRoom();
		Room trapRoom = new TrapRoom();
		
		this.currentRoom = entryRoom;
		this.currentRoom.addRoom("north", room1);
		room1.addRoom("north", roomWithMonster);
		room1.addRoom("south", entryRoom);
		roomWithMonster.addRoom("west", roomWithPotion);
		roomWithMonster.addRoom("south", room1);
		roomWithPotion.addRoom("north", exitRoom);
		roomWithPotion.addRoom("south", trapRoom);
		roomWithPotion.addRoom("east", roomWithMonster);
	}
	
	public void initializeLevel2 () {
		Room entryRoom = new Room();
		Room room2 = new Room();
		Room room3 = new Room();
		Room room4 = new Room();
		Room room5 = new Room();
		Room room6 = new Room();
		Room room7 = new Room();
		Room room8 = new Room();
		Room room9 = new Room();
		Room room10 = new Room();
		Room room11 = new Room();
		Room room12 = new Room();
		Room exitRoom = new ExitRoom();
		Room trapRoom = new TrapRoom();
		// hidden exits "go back"
		this.currentRoom = entryRoom;
		this.currentRoom.addRoom("west", room2);
		this.currentRoom.addRoom("east", room4);
		room2.addRoom("east", this.currentRoom);
		room2.addRoom("north", room3);
		room2.addRoom("behind the board", room9);
		room3.addRoom("under the carpet", room8);
		room3.addRoom("south", room2);
		room4.addRoom("west", this.currentRoom);
		room4.addRoom("north", room5);
		room5.addRoom("south", room4);
		room5.addRoom("east", room6);
		room5.addRoom("north", room7);
		room6.addRoom("west", room5);
		room6.addRoom("a hatch in the wall", room7);
		room7.addRoom("south", room5);
		room7.addRoom("a hatch in the wall", room6);
		room7.addRoom("behind the curtain", room8);
		room7.addRoom("north", room10);
		room8.addRoom("behind the curtain", room7);
		room8.addRoom("under the carpet", room3);
		room8.addRoom("north", room9);
		room9.addRoom("south", room8);
		room9.addRoom("north", trapRoom);
		room9.addRoom("east", room10);
		room9.addRoom("behind the board", room2);
		room10.addRoom("west", room9);
		room10.addRoom("east", room11);
		room10.addRoom("south", room7);
		room11.addRoom("west", room10);
		room11.addRoom("north", room12);
		room12.addRoom("south", room11);
		room12.addRoom("north", exitRoom);	
	}
	
	/**
	 * Give all directions you can choose
	 */
	public String movementsPossibilities(){
	    Set<String> directions = this.currentRoom.getDirections();
	    String message = "";
	    for (String direction : directions) {
	    	if(this.currentRoom.getRooms().get(direction) != null)
	    		message += "-" +  direction + "\n";
	    }
	    return("All directions you can choose:\n" + message);
	}
}
