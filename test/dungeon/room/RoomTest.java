package dungeon.room;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class RoomTest {
	protected Room room;
	protected Room room2;
	
	@Before
	public void createRoom() {
		room = new Room();
		room2 = new Room();
	}
	
	@Test
	public void testAddRoom() {
		assertNull(this.room.goRoom("north"));
		this.room.addRoom("north", room2);
	}
}