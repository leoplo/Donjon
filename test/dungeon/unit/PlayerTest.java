package dungeon.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.item.Key;
import dungeon.item.Weapon;

public class PlayerTest extends UnitTest{
	
	public Player createUnit(String name, int healthPoints){
		return new Player(name, healthPoints);
	}
	
	@Test
	public void testHeal() {
		Player player1 = this.createUnit("player1", 20);
		Player player2 = this.createUnit("player2", 10);
		player1.attack(player2);
		assertEquals(10, player2.getCurrentHealthPoints());
		player2.heal(5);
		assertEquals(15, player2.getCurrentHealthPoints());
		player2.heal(10);
		assertEquals(20, player2.getCurrentHealthPoints());
		player2.heal(1);
		assertEquals(20, player2.getCurrentHealthPoints());
	}
	
	@Test
	public void testSwitchWeapon(){
		Weapon sword20 = new Weapon("sword", 20);
		Weapon sword30 = new Weapon("sword", 30);
		Player player = this.createUnit("player", 20);
		player.switchWeapon(sword20);
		assertSame(sword20, player.getWeapon());
		player.switchWeapon(sword30);
		assertSame(sword30, player.getWeapon());
		player.switchWeapon(sword20);
		assertSame(sword30, player.getWeapon());
	}
	
	@Test
	public void testPickAndHasKey(){
		Key key1 = new Key("key1");
		Key key2 = new Key("key2");
		Player player = this.createUnit("player", 20);
		player.pickKey(key1);
		assertTrue(player.hasKey(key1));
		assertFalse(player.hasKey(key2));
		player.pickKey(key2);
		assertTrue(player.hasKey(key1) && player.hasKey(key2));
	}
}
