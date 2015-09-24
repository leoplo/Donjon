package dungeon.util;

public class ConsoleInterface {
	
	public void presentation() {
		System.out.println("During this game, you have to choose a direction to change room.");
		System.out.println("Exemple, if you want to go in the west room write: go west");
		System.out.println("By default, the north, south, west and east directions are set but they can be unavailable.");
		System.out.println("If you choose an unavailable direction, the game will tell you that is impossible");
		System.out.println("To know all available directions in a room you can write: infos");
	}

	public void printMessage(String message) {
		System.out.println(message);
	}
	
	public String readCommand() {
		String command = Input.readString();
		command = command.trim();
		if(command == "infos")
			return command;
		return (command.substring(1)).trim();
	}
}
