package dungeon.unit;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class UnitTest {
	
	/* the attack's power must be 10 */
	public abstract Unit createUnit (String name, int healthPoints);
	
	@Test
	public void attackAndResurrectTest () {
		Unit unit1 = createUnit("unit1", 20);
		Unit unit2 = createUnit("unit2", 30);
		unit1.attack(unit2);
		assertTrue(unit1.isAlive());
		assertTrue(unit2.isAlive());
		assertFalse(unit1.isDead());
		assertFalse(unit2.isDead());
		unit1.attack(unit2);
		assertTrue(unit1.isAlive());
		assertFalse(unit2.isAlive());
		assertFalse(unit1.isDead());
		assertTrue(unit2.isDead());
		unit2.resurrect();
		assertTrue(unit2.isAlive());
		assertFalse(unit2.isDead());
	}
	
	@Test
	public void getNameTest () {
		Unit unit = createUnit("unit", 30);
		assertEquals("unit", unit.getName());
	}
	
	@Test
	public void toStringTest () {
		Unit unit1 = createUnit("unit", 20);
		Unit unit2 = createUnit("unit", 30);
		assertEquals("unit : 20 HP", unit1.toString());
		unit1.attack(unit2);
	}
}
