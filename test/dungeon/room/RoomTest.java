package dungeon.room;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import dungeon.item.Key;
import dungeon.room.exit.Exit;
import dungeon.unit.Player;


public class RoomTest {
	protected Room room;
	
	@Before
	public void createRoom() {
		room = new Room();
	}
	
	@Test
	public void testAddRoomAndGetRoomAndGetExit () {
		Room room1 = new Room();
		Room room2 = new Room();
		Room room3 = new Room();
		Room room4 = new Room();
		Exit exit1 = new Exit();
		Exit exit2 = new Exit(true);
		Exit exit3 = new Exit(true);
		Exit exit4 = new Exit();
		room.addRoom("north", room1, exit1);
		room.addRoom("south", room2, exit2);
		room.addRoom("west", room3, exit3);
		room.addRoom("east", room4, exit4);
		assertSame(room1, room.getRoom("north"));
		assertSame(room2, room.getRoom("south"));
		assertSame(room3, room.getRoom("west"));
		assertSame(room4, room.getRoom("east"));
		assertNull(room.getRoom("unknown"));
		assertSame(exit1, room.getExit("north"));
		assertSame(exit2, room.getExit("south"));
		assertSame(exit3, room.getExit("west"));
		assertSame(exit4, room.getExit("east"));
		assertNull(room.getExit("unknown"));
	}
	
	@Test
	public void testIsWinningRoom () {
		assertFalse(this.room.isWinningRoom());
	}
	
	@Test
	public void testIsLosingRoom () {
		assertFalse(this.room.isLosingRoom());
	}
	
	@Test
	public void testAddItemInTheRoomAndRoomAction () {
		Player player = new Player("player", 100);
		Key key = new Key("key");
		assertFalse(player.hasKey(key));
		room.addItemInTheRoom(key);
		room.roomAction(player);
		assertTrue(player.hasKey(key));
	}
	
	@Test
	public void testGetDirections () {
		Room room1 = new Room();
		Room room2 = new Room();
		Room room3 = new Room();
		Room room4 = new Room();
		Exit exit1 = new Exit();
		Exit exit2 = new Exit(true);
		Exit exit3 = new Exit(true);
		Exit exit4 = new Exit();
		room.addRoom("north", room1, exit1);
		room.addRoom("south", room2, exit2);
		room.addRoom("west", room3, exit3);
		room.addRoom("east", room4, exit4);
		Set<String> directions = room.getDirections();
		Set<String> directionsExpected = new TreeSet<String>();
		directionsExpected.add("north");
		directionsExpected.add("south");
		directionsExpected.add("west");
		directionsExpected.add("east");
		assertEquals(directionsExpected, directions);
	}
}
