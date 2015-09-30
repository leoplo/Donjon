package dungeon.room.exit;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExitTest {
	
	public Exit createExit (boolean isHidden) {
		return new Exit(isHidden);
	}
	
	@Test
	public void isOpenTest () {
		Exit exit1 = createExit(true);
		Exit exit2 = createExit(false);
		assertTrue(exit1.isOpen());
		assertTrue(exit2.isOpen());
	}
	
	@Test
	public void isHiddenTest () {
		Exit exit1 = createExit(true);
		Exit exit2 = createExit(false);
		assertTrue(exit1.isHidden());
		assertFalse(exit2.isHidden());
	}
}
