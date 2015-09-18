package dungeon.room;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class RoomTest {
	protected Room room;
	protected Room northRoom;
	protected Room southRoom;
	protected Room westRoom;
	protected Room eastRoom;
	protected Room hiddenRoom;
	
	@Before
	public void createRoom() {
		room = new Room();
		northRoom = new Room();
		southRoom = new Room();
		westRoom = new Room();
		eastRoom = new Room();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddRoomAndGoRoom () {
		assertNull(this.room.goRoom("north"));
		this.room.addRoom("north", northRoom);
		assertSame(northRoom, this.room.goRoom("north"));
		assertNull(this.room.goRoom("south"));
		this.room.addRoom("south", southRoom);
		assertSame(southRoom, this.room.goRoom("south"));
		assertNull(this.room.goRoom("west"));
		this.room.addRoom("west", westRoom);
		assertSame(westRoom, this.room.goRoom("west"));
		assertNull(this.room.goRoom("east"));
		this.room.addRoom("east", eastRoom);
		assertSame(eastRoom, this.room.goRoom("east"));
		this.room.addRoom("hidden", hiddenRoom);
		assertSame(hiddenRoom, this.room.goRoom("hidden"));
		this.room.goRoom("exception");
	}
	
	@Test
	public void testIsWinningRoom () {
		assertFalse(this.room.isWinningRoom());
	}
	
	@Test
	public void testIsLosingRoom () {
		assertFalse(this.room.isLosingRoom());
	}
}
