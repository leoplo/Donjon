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
		String command = "";
		do {
			System.out.print("> ");
			command = Input.readString().trim();
		} while (!command.equals(""));
		if(command.equals("infos"))
			return command;
		return (command.substring(2)).trim();
	}
	
	public String readName() {
		this.printMessage("Please choose your name :");
		String name = "";
		do {
			System.out.print("> ");
			name = Input.readString().trim();
		} while (!name.equals(""));
		return name;
	}
}
