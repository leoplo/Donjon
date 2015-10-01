package dungeon;

import java.util.ArrayList;
import java.util.List;

import dungeon.item.*;
import dungeon.room.*;
import dungeon.room.exit.Exit;
import dungeon.room.exit.ExitLockedByKey;
import dungeon.unit.*;

public class GameMain {
	
	public static void main(String[] args) {
		List<Dungeon> dungeons = new ArrayList<Dungeon>();
		dungeons.add(new Dungeon(initializeLevel1()));
		dungeons.add(new Dungeon(initializeLevel2()));
		
		Game game = new Game(dungeons);
		game.run();
	}
	
	public static Room initializeLevel1() {
		Room entryRoom = new Room();
		Room room1 = new Room();
		Room roomWithMonster = new MonsterRoom(new Monster("Orc", 20, 6));
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
	
	public static Room initializeLevel2() {
		Room entryRoom = new Room();
		Room room1 = new Room();
		Room weaponRoom = new Room();
		Weapon sword = new Weapon("sword", 30);
		weaponRoom.addItemInTheRoom(sword);
		Room room2 = new Room();
		Room room3 = new Room();
		Key exitKey = new Key("exit key");
		Room keyRoom = new Room();
		keyRoom.addItemInTheRoom(exitKey);
		Room room4 = new Room();
		TrapRoom trap = new TrapRoom();
		Monster godzilla = new Monster("godzilla", 60, 40);
		MonsterRoom godzillaRoom = new MonsterRoom(godzilla);
		Monster lutin = new Monster("lutin", 10, 20);
		MonsterRoom lutinRoom = new MonsterRoom(lutin);
		Potion potion = new Potion("healing potion", 10);
		Room potionRoom = new Room();
		potionRoom.addItemInTheRoom(potion);
		ExitRoom exit = new ExitRoom();
		ExitLockedByKey lockedExit = new ExitLockedByKey(false, exitKey);
		Exit hiddenExit = new Exit(true);
		
		entryRoom.addRoom("north", room1, new Exit());
		
		room1.addRoom("south", entryRoom, new Exit());
		room1.addRoom("north", room3, new Exit());
		room1.addRoom("west", weaponRoom, new Exit());
		room1.addRoom("behind the board", room4, hiddenExit);
		
		weaponRoom.addRoom("east", room1, new Exit());
		weaponRoom.addRoom("north", room2, new Exit());
		
		room2.addRoom("east", room3, new Exit());
		room2.addRoom("north", lutinRoom, new Exit());
		room2.addRoom("south", weaponRoom, new Exit());
		
		room3.addRoom("south", room1, new Exit());
		room3.addRoom("east", keyRoom, new Exit());
		room3.addRoom("north", godzillaRoom, new Exit());
		room3.addRoom("west", room2, new Exit());
		room3.addRoom("trap in the roof", exit, hiddenExit);
		
		keyRoom.addRoom("west", room3, new Exit());
		keyRoom.addRoom("north", room4, new Exit());
		
		room4.addRoom("south", keyRoom, new Exit());
		room4.addRoom("north", trap, new Exit());
		room4.addRoom("south", godzillaRoom, new Exit());
		
		godzillaRoom.addRoom("west", lutinRoom, new Exit());
		godzillaRoom.addRoom("east", room4, new Exit());
		godzillaRoom.addRoom("south", room3, new Exit());
		
		lutinRoom.addRoom("north", potionRoom, new Exit());
		lutinRoom.addRoom("east", godzillaRoom, new Exit());
		lutinRoom.addRoom("south", room2, new Exit());
		
		potionRoom.addRoom("south", lutinRoom, new Exit());
		potionRoom.addRoom("east", exit, lockedExit);
		
		return entryRoom;
		
		
		
	}
}
