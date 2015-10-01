package dungeon;

import dungeon.room.Room;

public class DungeonTest {
	protected Dungeon dungeon;
	
	public void createDungeon () {
		Room room = new Room();
		dungeon = new Dungeon(room);
	}
}
