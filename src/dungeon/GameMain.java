package dungeon;

import java.util.ArrayList;
import java.util.List;

import dungeon.item.*;
import dungeon.room.*;
import dungeon.room.exit.Exit;
import dungeon.unit.*;
import dungeon.util.ConsoleInterface;

public class GameMain {
	
	public static void main(String[] args) {
		ConsoleInterface console = new ConsoleInterface();
		Player player = new Player(console.readName(), 100);
		List<Dungeon> dungeons = new ArrayList<Dungeon>();
		dungeons.add(new Dungeon(initializeLevel1(), player));
		
		Game game = new Game(player, dungeons);
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
	
	public void initializeLevel2 () {
		/*Room entryRoom = new Room();
		Room room2 = new Room();
		Room room3 = new Room();
		Room room4 = new Room();
		Room room5 = new Room();
		Room room6 = new Room();
		Room room7 = new Room();
		Room room8 = new Room();
		Room room9 = new Room();
		Room room10 = new Room();
		Room room11 = new Room();
		Room room12 = new Room();
		Room exitRoom = new ExitRoom();
		Room trapRoom = new TrapRoom();
		// hidden exits "go back"
		this.currentRoom = entryRoom;
		this.currentRoom.addRoom("west", room2);
		this.currentRoom.addRoom("east", room4);
		room2.addRoom("east", this.currentRoom);
		room2.addRoom("north", room3);
		room2.addRoom("behind the board", room9);
		room3.addRoom("under the carpet", room8);
		room3.addRoom("south", room2);
		room4.addRoom("west", this.currentRoom);
		room4.addRoom("north", room5);
		room5.addRoom("south", room4);
		room5.addRoom("east", room6);
		room5.addRoom("north", room7);
		room6.addRoom("west", room5);
		room6.addRoom("a hatch in the wall", room7);
		room7.addRoom("south", room5);
		room7.addRoom("a hatch in the wall", room6);
		room7.addRoom("behind the curtain", room8);
		room7.addRoom("north", room10);
		room8.addRoom("behind the curtain", room7);
		room8.addRoom("under the carpet", room3);
		room8.addRoom("north", room9);
		room9.addRoom("south", room8);
		room9.addRoom("north", trapRoom);
		room9.addRoom("east", room10);
		room9.addRoom("behind the board", room2);
		room10.addRoom("west", room9);
		room10.addRoom("east", room11);
		room10.addRoom("south", room7);
		room11.addRoom("west", room10);
		room11.addRoom("north", room12);
		room12.addRoom("south", room11);
		room12.addRoom("north", exitRoom);	*/
	}
}
