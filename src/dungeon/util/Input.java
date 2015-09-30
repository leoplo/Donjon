package dungeon.util;

import java.util.Scanner;

/** the class {@code Input} contains all the function that can read inputs of the player.
 */
public class Input {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * read a String from standard input
	 * 
	 * @return the read string
	 */
	public static String readString() {
			return Input.scanner.nextLine();
	}

	/**
	 * read an integer from standard input
   	 * 
	 * @return the read integer
	 * @throws java.io.IOException if input does not correspond to an integer
	 */
	public static int readInt() throws java.io.IOException {
		try {
			return Input.scanner.nextInt();
		} catch (Exception e) {
			Input.scanner.skip(".*");
			throw new java.io.IOException();
		}
	}
}
