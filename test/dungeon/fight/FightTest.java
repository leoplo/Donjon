package dungeon.fight;

import static org.junit.Assert.*;
import dungeon.unit.*;

public class FightTest {
	
	
	public void fightWonByPlayerTest() {
		Player player = new Player("player", 30);
		Monster monster = new Monster("monster", 27, 9);
		Fight fight = new Fight(player, monster);
		assertSame(fight.getWinner(), player);
	}
	
	public void fightWonByMonsterTest() {
		Player player = new Player("player", 30);
		Monster monster = new Monster("monster", 31, 11);
		Fight fight = new Fight(player, monster);
		assertSame(fight.getLoser(), player);
	}
}
