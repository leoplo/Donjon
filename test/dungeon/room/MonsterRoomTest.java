package dungeon.room;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.unit.Monster;
import dungeon.unit.Player;

public class MonsterRoomTest {
	
	@Test
	public void testRoomAction(){
		Player player = new Player("player", 20);
		Monster godzilla = new Monster("GODZILLA", 600, 200);
		Monster diablotin = new Monster("diablotin", 2, 1);
		MonsterRoom godzillaRoom = new MonsterRoom(godzilla);
		MonsterRoom diablotinRoom = new MonsterRoom(diablotin);
		
		String diablotinMessage = diablotinRoom.roomAction(player);
		assertEquals(" A fight begin between diablotin and you.\nThe winner is player\n", diablotinMessage);
		assertTrue(diablotin.isDead() && player.isAlive());
		String godzillaMessage = godzillaRoom.roomAction(player);
		assertEquals(" A fight begin between GODZILLA and you.\nThe winner is GODZILLA\n", godzillaMessage);
		assertTrue(godzilla.isAlive() && player.isDead());
	}
}
