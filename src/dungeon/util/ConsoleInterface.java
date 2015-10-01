package dungeon.util;

/** the class {@code ConsoleInterface} contains all the methods that can print in a console.
 */
public class ConsoleInterface {

	public void printMessage(String message) {
		System.out.println(message);
	}
	
	/**
	 * Read command on the standard input
	 * @return the string command
	 */
	public String readCommand() {
		String command = "";
		
		do {
			System.out.print("> ");
			command = Input.readString().trim();
		} while (command.equals(""));
		
		return command;
	}
}
