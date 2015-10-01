package dungeon.item;

import static org.junit.Assert.*;
import org.junit.Test;

import dungeon.fight.Fight;
import dungeon.unit.*;

public class PotionTest extends ItemTest{
	
	@Test
	public void itemActionTest() {
		Potion potion = new Potion("potion", 1);
		Player player = new Player("player", 2);
		Monster monster = new Monster("monster", 19, 1);
		new Fight(player, monster);
		assertEquals(player.getCurrentHealthPoints(), 1);
		potion.itemAction(player);
		assertEquals(player.getCurrentHealthPoints(), 2);
		potion.itemAction(player);
		assertEquals(player.getCurrentHealthPoints(), 2);
	}
}
