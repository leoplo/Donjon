package dungeon;

import org.junit.Before;

public class DungeonTest {
	protected Dungeon dungeon;
	
	@Before
	public void createDungeon () {
		Player player = new Player("joueur");
		dungeon = new Dungeon(player);
	}
}
