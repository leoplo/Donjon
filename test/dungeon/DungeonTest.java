package dungeon;

import org.junit.Before;

import dungeon.unit.Player;

public class DungeonTest {
	protected Dungeon dungeon;
	
	@Before
	public void createDungeon () {
		Player player = new Player("joueur", 10);
		dungeon = new Dungeon();
		dungeon.player = player;
	}
}
