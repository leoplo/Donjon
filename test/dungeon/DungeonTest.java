package dungeon;

import org.junit.Before;

import dungeon.room.Room;

public class DungeonTest {
	protected Dungeon dungeon;
	
	@Before
	public void createDungeon () {
		Room room = new Room();
		dungeon = new Dungeon(room);
	}
}
