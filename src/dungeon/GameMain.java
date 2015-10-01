package dungeon;

import java.util.ArrayList;
import java.util.List;

import dungeon.item.*;
import dungeon.room.*;
import dungeon.room.exit.Exit;
import dungeon.unit.*;

public class GameMain {
	
	public static void main(String[] args) {
		List<Dungeon> dungeons = new ArrayList<Dungeon>();
		dungeons.add(new Dungeon(initializeLevel1()));
		
		Game game = new Game(dungeons);
		game.run();
	}
	
	public static Room initializeLevel1() {
		Room entryRoom = new Room();
		Room room1 = new Room();
		Room roomWithMonster = new MonsterRoom(new Monster("Orc", 200, 600));
		Room roomWithPotion = new Room();
		roomWithPotion.addItemInTheRoom(new Potion("Healing Potion", 10));
		Room exitRoom = new ExitRoom();
		Room trapRoom = new TrapRoom();
		
		entryRoom.addRoom("north", room1, new Exit());
		room1.addRoom("north", roomWithMonster, new Exit());
		room1.addRoom("south", entryRoom, new Exit());
		roomWithMonster.addRoom("west", roomWithPotion, new Exit());
		roomWithMonster.addRoom("south", room1, new Exit());
		roomWithPotion.addRoom("north", exitRoom, new Exit());
		roomWithPotion.addRoom("south", trapRoom, new Exit());
		roomWithPotion.addRoom("east", roomWithMonster, new Exit());
		
		return entryRoom;
	}
}
