package dungeon.item;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import dungeon.unit.Player;

//don't extend Item
public class WeaponTest extends ItemTest {
	protected Weapon weapon;
	
	@Before
	public void createWeapon(String name, int damage){
		weapon = new Weapon(name, damage);
	}
	
	@Test
	public void itemActionTest(){
		Player player = new Player("player", 1);
		assertNotSame(weapon, player.getWeapon());
		weapon.itemAction(player);
		assertSame(weapon, player.getWeapon());
	}
	
	@Test
	public void isBetterThanTest() {
		 Weapon weapon2 = new Weapon("weapon2", 15);
		 assertFalse(weapon2.isBetterThan(weapon));
		 assertFalse(weapon.isBetterThan(weapon));
		 assertTrue(weapon.isBetterThan(weapon2));
	}
}
