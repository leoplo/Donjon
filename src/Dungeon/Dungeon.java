package Dungeon;

import java.util.*;

public class Dungeon {
	protected Room currentRoom = new Room();
	protected final Scanner scanner = new Scanner(System.in);

	public String getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Interprets the user's command and executs it
	 * @param command the user's command
	 */
	public void interpretCommand(String command) {
		try {
			Room nextRoom = this.currentRoom.goRoom(command);
			this.currentRoom = nextRoom;
		} catch (InvalidParameterException e) {
			System.out.println("You can't go this way");
		}
	}

	public static void main(String[] args) {
		Dungeon dungeon = new Dungeon();
		dungeon.start();
	}

	public void start() {
		do {
			System.out.println("You are in a new room");
			System.out.println("What do you want to do now ?");
			System.out.print("> ");
			// Read a command from the user (stdin)
			String line = this.scanner.nextLine();
			interpretCommand(line);
		} while (!gameIsFinished());
		if (gameIsWon()) {
			System.out.println("You win !");
		} else {
			System.out.println("You loose !");
		}
	}
	
	public boolean gameIsFinished() {
		return  this.currentRoom.isWinningRoom() || this.currentRoom.isLosingRoom();
	}
}
