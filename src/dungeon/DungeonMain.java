package dungeon;

public class DungeonMain {
	
	public static void main(String[] args) {
		Dungeon dungeon = new Dungeon();
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
