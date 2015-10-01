package dungeon.item;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class ItemTest {
	
	public abstract Item createItem (String name);
	
	@Test
	public void getNameTest () {
		Item item = this.createItem("item");
		assertEquals("item", item.getName());
	}
	
	@Test
	public abstract void itemActionTest ();
}
