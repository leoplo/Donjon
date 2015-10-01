package dungeon.unit;

public class MonsterTest extends UnitTest{

	/**
	 * {@inheritDoc}
	 */
	public Monster createUnit(String name, int healthPoints) {
		return new Monster(name, healthPoints, 10);
	}
}
