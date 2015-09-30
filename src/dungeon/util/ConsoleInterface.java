package dungeon.util;

/** the class {@code ConsoleInterface} contains all the methods that can print in a console.
 */
public class ConsoleInterface {
	
	public void presentation() {
		System.out.println("During this game, you have to choose a direction to change room.");
		System.out.println("Exemple, if you want to go in the west room write: go west");
		System.out.println("If you choose an unavailable direction, the game will tell you that is impossible");
		System.out.println("To know all available directions in a room you can write: infos");
	}

	public void printMessage(String message) {
		System.out.println(message);
	}
	
	public String readCommand() {
		String command = "";
		
		do {
			this.printMessage("What do you want to do now ?");
			System.out.print("> ");
			command = Input.readString().trim();
		} while (command.equals(""));
		
		return command;
	}
}
