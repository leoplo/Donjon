package dungeon;

import dungeon.unit.Player;
import dungeon.util.ConsoleInterface;

public class DungeonMain {
	
	public static void main(String[] args) {
		ConsoleInterface console = new ConsoleInterface();
		Player player = new Player(console.readName(), 100);
		Dungeon dungeon = new Dungeon(console, player);
		console.presentation();
		dungeon.initializeLevel1();
		if (dungeon.start()) {
			/*dungeon.initializeLevel2();
			if (dungeon.start()) {*/
				console.printMessage("Congratulations " + dungeon.player.getName() + ", you win !");
			/*}*/
		}
	}
}
