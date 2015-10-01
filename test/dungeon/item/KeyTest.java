package dungeon.item;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.unit.Player;

public class KeyTest extends ItemTest{

	public Key createKey(String name){
		return createItem(name);
	}
	
	@Test
	public void itemActionTest(){
		Key key = createKey("key");
		Player player = new Player("player", 30);
		assertFalse(player.hasKey(key));
		key.itemAction(player);
		assertTrue(player.hasKey(key));
	}

}
