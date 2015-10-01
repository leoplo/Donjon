package dungeon.item;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.unit.Player;

public class KeyTest extends ItemTest{

	public Item createItem(String name){
		return new Key(name);
	}
	
	@Test
	public void itemActionTest(){
		Key key = (Key) this.createItem("key");
		Player player = new Player("player", 30);
		assertFalse(player.hasKey(key));
		key.itemAction(player);
		assertTrue(player.hasKey(key));
	}

}
