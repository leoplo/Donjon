package dungeon;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.room.ExitRoom;
import dungeon.room.MonsterRoom;
import dungeon.room.Room;
import dungeon.room.TrapRoom;
import dungeon.room.exit.Exit;
import dungeon.unit.Monster;
import dungeon.unit.Player;

public class DungeonTest {
	
	public Dungeon createDungeon () {
		Room room = new Room();
		return new Dungeon(room);
	}
	
	@Test
	public void interpretCommandTest () {
		Dungeon dungeon = this.createDungeon();
		assertEquals("Say somethings !", dungeon.interpretCommand(""));
		assertFalse(dungeon.userGiveUp);
		assertEquals(dungeon.changingRoom("north") , dungeon.interpretCommand("go north"));
		assertFalse(dungeon.userGiveUp);
		assertEquals(dungeon.movementsPossibilities(true) , dungeon.interpretCommand("infos"));
		assertFalse(dungeon.userGiveUp);
		assertEquals("You give up !", dungeon.interpretCommand("quit"));
		assertTrue(dungeon.userGiveUp);
	}
	
	@Test
	public void changingRoomTest () {
		Dungeon dungeon = this.createDungeon();
		dungeon.player = new Player("player", 20);
		Room room1 = new Room();
		Room room2 = new Room();
		dungeon.currentRoom.addRoom("north", room1, new Exit());
		room1.addRoom("south", room2, new Exit(true));
		assertNotSame(room1, dungeon.currentRoom);
		dungeon.changingRoom("north");
		assertSame(room1, dungeon.currentRoom);
		dungeon.changingRoom("south");
		assertSame(room2, dungeon.currentRoom);
		dungeon.changingRoom("west");
		assertSame(room2, dungeon.currentRoom);
	}
	
	@Test
	public void gameIsFinishedTest () {
		Dungeon dungeon = this.createDungeon();
		dungeon.player = new Player("player", 20);
		assertFalse(dungeon.gameIsFinished());
		dungeon.currentRoom.addRoom("north", new MonsterRoom(new Monster("monster", 200, 50)), new Exit());
		dungeon.changingRoom("north");
		assertTrue(dungeon.gameIsFinished());
		dungeon.currentRoom = new ExitRoom();
		assertTrue(dungeon.gameIsFinished());
		dungeon.currentRoom = new TrapRoom();
		assertTrue(dungeon.gameIsFinished());
		dungeon.currentRoom = new Room();
		dungeon.interpretCommand("quit");
		assertTrue(dungeon.gameIsFinished());
	}
	
	@Test
	public void gameIsWonTest () {
		Dungeon dungeon = this.createDungeon();
		dungeon.player = new Player("player", 20);
		assertFalse(dungeon.gameIsFinished());
		dungeon.currentRoom = new TrapRoom();
		assertFalse(dungeon.gameIsWon());
		dungeon.currentRoom = new ExitRoom();
		assertTrue(dungeon.gameIsWon());
		dungeon.currentRoom.addRoom("north", new MonsterRoom(new Monster("monster", 200, 50)), new Exit());
		dungeon.changingRoom("north");
		assertFalse(dungeon.gameIsWon());
	}
	
}
