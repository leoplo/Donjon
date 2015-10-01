package dungeon.room.exit;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public abstract class LockedExitTest extends ExitTest {
	
	@Test
	public void isOpenTest () {
		ExitLockedByKey exit1 = (ExitLockedByKey) this.createExit(true);
		ExitLockedByKey exit2 = (ExitLockedByKey) this.createExit(false);
		assertFalse(exit1.isOpen());
		assertFalse(exit2.isOpen());
	}
	
	@Test
	public abstract void unlockTest ();
	
}
