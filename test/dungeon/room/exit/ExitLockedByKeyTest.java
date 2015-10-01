package dungeon.room.exit;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.item.Key;
import dungeon.unit.Player;

public class ExitLockedByKeyTest extends LockedExitTest {
	protected Key key = new Key("key");
	
	public Exit createExit (boolean isHidden) {
		return new ExitLockedByKey(isHidden, key);
	}
	
	@Test
	public void isOpenTest () {
		ExitLockedByKey exit1 = (ExitLockedByKey) createExit(true);
		ExitLockedByKey exit2 = (ExitLockedByKey) createExit(false);
		assertFalse(exit1.isOpen());
		assertFalse(exit2.isOpen());
	}
	
	@Test
	public void unlockTest () {
		ExitLockedByKey exit = (ExitLockedByKey) createExit(false);
		Player player = new Player("player", 30);
		assertFalse(exit.isOpen());
		exit.unlock(player);
		assertFalse(exit.isOpen());
		player.pickKey(key);
		exit.unlock(player);
		assertTrue(exit.isOpen());
	}
	
}
