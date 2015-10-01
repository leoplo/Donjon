package dungeon.room;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExitRoomTest {
	
	@Test
	public void testIsWinningRoom(){
		ExitRoom exit = new ExitRoom();
		assertTrue(exit.isWinningRoom());
		assertFalse(exit.isLosingRoom());
	}
}
