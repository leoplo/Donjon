package dungeon;

import java.util.List;

import dungeon.unit.Player;
import dungeon.util.ConsoleInterface;

/**
 * the class {@code Game} represent the all game, it contains a player and a list of dungeon (which are a kind of levels). 
 *
 */
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
	
	/**
	 * This method start the game, it includes a game presentation. 
	 * After the presentation the game starts and the hand is given to the player.
	 */
	public void run() {
		int currentLevel = 1;
		this.end = false;
		
		this.console.presentation();
		
		while(currentLevel-1 < dungeons.size() && !this.end) {
			this.console.printMessage("Level " + currentLevel + " begin!");
			
			if(this.runLevel(currentLevel-1)) {
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
	
	/**
	 * This method run a level (Dungeon)
	 * @param level the index of the level to play.
	 * @return {@code true}, if the player won the level, 
	 * 			{@code false} else.
	 */
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
