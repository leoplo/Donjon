package dungeon;

import java.util.List;

import dungeon.unit.Player;
import dungeon.util.ConsoleInterface;

public class Game {
	private Player player;
	private List<Dungeon> dungeons;
	private boolean end;
	private ConsoleInterface console;
	
	public Game(Player player, List<Dungeon> dungeons) {
		this.player = player;
		this.dungeons = dungeons;
		this.end = false;
		this.console = new ConsoleInterface();
	}
	
	public void run() {
		int currentLevel = 0;
		this.end = false;
		
		this.console.presentation();
		
		while(currentLevel < dungeons.size() && !this.end) {
			this.console.printMessage("Level " + (currentLevel+1) + " begin!");
			
			if(this.runLevel(currentLevel)) {
				this.console.printMessage("Congratulations, you have finished the level " + currentLevel + " !");
				currentLevel++;
			}
			else {
				this.end = true;
			}
		}
		
		if(!this.end) {
			this.console.printMessage("Congratulations " + this.player.getName() + ", you win !");
		}
		else {
			this.console.printMessage("Game over!");
		}
	}
	
	private boolean runLevel(int level) {
		Dungeon dungeon = dungeons.get(level);
		
		while(!dungeon.gameIsFinished()) {
			String command = this.console.readCommand();
			String response = dungeon.interpretCommand(command);
			this.console.printMessage(response);
		}
		
		return dungeon.gameIsWon();
	}
}
