package dungeon;

import org.junit.Before;

import dungeon.room.Room;
import dungeon.unit.Player;

public class DungeonTest {
	protected Dungeon dungeon;
	
	@Before
	public void createDungeon () {
		Player player = new Player("player", 30);
		Room room = new Room();
		dungeon = new Dungeon(room, player);
		dungeon.player = player;
	}
}
