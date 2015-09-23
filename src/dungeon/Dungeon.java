package dungeon;

import java.util.*;

import dungeon.room.*;

/**
 * The class <code>Dungeon</code> represents a dungeon game containing Rooms.
 */

public class Dungeon {

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
		System.out.println("You are in a new dungeon");
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
		Room room2 = new TrapRoom();
		Room room3 = new Room();
		Room room4 = new ExitRoom();
		this.currentRoom.addRoom("north", room1);
		room1.addRoom("south", currentRoom);
		room1.addRoom("west", room2);
		room2.addRoom("east", room1);
		room1.addRoom("east", room3);
		room3.addRoom("west", room1);
		room1.addRoom("north", room4);
		room4.addRoom("south", room1);
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
}
