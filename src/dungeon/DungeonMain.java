package dungeon;

import dungeon.unit.Player;

public class DungeonMain {
	
	public static void main(String[] args) {
		Dungeon dungeon = new Dungeon();
		dungeon.player = new Player(dungeon.console.readName(), 100);
		dungeon.console.presentation();
		dungeon.initializeLevel1();
		if (dungeon.start()) {
			/*dungeon.initializeLevel2();
			if (dungeon.start()) {*/
				dungeon.console.printMessage("Congratulations " + dungeon.player.getName() + ", you win !");
			/*}*/
		}
	}
}
