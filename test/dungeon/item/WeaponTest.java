package dungeon.item;

import static org.junit.Assert.*;
import org.junit.Test;

import dungeon.unit.Player;

//don't extend Item
public class WeaponTest extends ItemTest {
	
	public Item createItem(String name){
		return new Weapon(name, 20);
	}
	
	@Test
	public void itemActionTest(){
		Weapon weapon = (Weapon) this.createItem("weapon");
		Player player = new Player("player", 1);
		assertNotSame(weapon, player.getWeapon());
		weapon.itemAction(player);
		assertSame(weapon, player.getWeapon());
	}
	
	@Test
	public void isBetterThanTest() {
		Weapon weapon1 = new Weapon("weapon1", 20);
		Weapon weapon2 = new Weapon("weapon2", 15);
		assertFalse(weapon2.isBetterThan(weapon1));
		assertFalse(weapon1.isBetterThan(weapon1));
		assertTrue(weapon1.isBetterThan(weapon2));
	}
}
