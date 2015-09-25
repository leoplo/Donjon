package dungeon;

public class DungeonMain {
	
	public static void main(String[] args) {
		Dungeon dungeon = new Dungeon();
		dungeon.player = new Player(dungeon.console.readName());
		dungeon.console.presentation();
		dungeon.initializeLevel2();
		if (dungeon.start()) {
			dungeon.initializeLevel2();
			if (dungeon.start()) {
				dungeon.initializeLevel2();
				dungeon.start();
			}
		}
		dungeon.console.printMessage("Congratulations "+dungeon.player.name+", you win !");
	}
}
