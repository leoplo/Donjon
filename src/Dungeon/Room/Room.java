package Dungeon.Room;

public class Room{

	protected String name;
	protected Room northRoom;
	protected Room westRoom;
	protected boolean gameIsLost;
	protected boolean gameIsWin;
	
	
	public Room() {
		Room(null, null);
	}
	
	public Room (Room northRoom, Room westRoom) {
		this.northRoom = northRoom;
		this.westRoom = westRoom;
		this.gameIsLost = false;
		this.gameIsWin = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Room goNorthRoom() {
		
		return;
	}
	
	public Room goWestRoom() {
		
		return;
	}