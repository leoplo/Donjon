package dungeon;

import java.util.*;

import dungeon.room.Room;

/**
 * The class <code>Dungeon</code> represents a dungeon game.
 */

public class Dungeon {

	// Attributes
	protected Room currentRoom = new Room();
	protected final Scanner scanner = new Scanner(System.in);

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
			if (nextRoom == null) {
				System.out.println("You can't go this way");
			} else {
				System.out.println("You are in a new room");
				this.currentRoom = nextRoom;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("I don't know what you mean");
		}
	}

	public boolean start() {
		do {
			System.out.println("What do you want to do now ?");
			System.out.print("> ");
			// Read a command from the user (stdin)
			String line = this.scanner.nextLine();
			changingRoom(line);
		} while (!gameIsFinished());
		if (this.currentRoom.isWinningRoom()) {
			System.out.println("You win !");
			return true;
		} else {
			System.out.println("You loose !");
			return false;
		}
	}
	
	public boolean gameIsFinished() {
		return  this.currentRoom.isWinningRoom() || this.currentRoom.isLosingRoom();
	}
	
	public void initializeLevel1 () {
		Room room1 = new Room();
		Room room2 = new Room();
		Room room3 = new Room();
		Room room4 = new Room();
		this.currentRoom.addRoom("north", room1);
		room1.addRoom("south", currentRoom);
		room1.addRoom("west", room2);
		room2.addRoom("east", room1);
		room1.addRoom("east", room3);
		room3.addRoom("west", room1);
		room1.addRoom("north", room4);
		room4.addRoom("south", room1);
	}
}
