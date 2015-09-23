package dungeon;

public class DungeonMain {
	
	public static void main(String[] args) {
		/* nom player stdin scanner pour new Player() */
		Dungeon dungeon = new Dungeon(player);
		dungeon.initializeLevel1();
		if (dungeon.start()) {
			dungeon.initializeLevel2();
			if (dungeon.start()) {
				dungeon.initializeLevel1();
				dungeon.start();
			}
		}
		System.out.println("Finish !");
	}
}
