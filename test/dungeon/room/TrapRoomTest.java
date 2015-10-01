package dungeon.room;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrapRoomTest {
	
	@Test
	public void testIsLosingRoom(){
		TrapRoom trap = new TrapRoom();
		assertTrue(trap.isLosingRoom());
		assertFalse(trap.isWinningRoom());
	}
}
