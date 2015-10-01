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
	private ConsoleInterface console;
	
	public Game(List<Dungeon> dungeons) {
		this.dungeons = dungeons;
		this.console = new ConsoleInterface();
	}
	
	public String presentation() {
		return "During this game, you have to choose a direction to change room.\n" +
				"Exemple, if you want to go in the west room, write : 'go west'\n" +
				"To see the hidden directions and be informated about the player health, write : 'infos'\n" +
				"If you want to leave the game, write : 'quit'\n" +
				"Good luck!";
	}
	
	/**
	 * This method start the game, it includes a game presentation. 
	 * After the presentation the game starts and the hand is given to the player.
	 */
	public void run() {
		int currentLevel = 0;
		boolean end = false;
		
		this.console.printMessage(this.presentation());
		this.console.printMessage("What's your name ?");
		String playerName = this.console.readCommand();
		this.player = new Player(playerName, 100);
		
		while(currentLevel < dungeons.size() && !end) {
			this.console.printMessage("Level " + (currentLevel+1) + " begin!");
			
			if(this.runLevel(currentLevel)) {
				this.console.printMessage("Congratulations, you have finished the level " + (currentLevel+1) + " !");
				currentLevel++;
			}
			else {
				end = true;
			}
		}
		
		if(!end) {
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
		this.console.printMessage(dungeon.startDungeon(this.player));
		
		while(!dungeon.gameIsFinished()) {
			this.console.printMessage(this.player.toString());
			this.console.printMessage("What do you want to do now ?");
			String command = this.console.readCommand();
			String response = dungeon.interpretCommand(command);
			this.console.printMessage(response);
			this.console.printMessage("------------------------");
		}
		
		return dungeon.gameIsWon();
	}
}
