package dungeon.fight;

import dungeon.unit.Unit;

public class Fight {
	protected Unit fighter1, fighter2;
	
	public Fight(Unit fighter1, Unit fighter2) {
		this.fighter1 = fighter1;
		this.fighter2 = fighter2;
		this.startFight();
	}
	
	/**
	 * This method run the fight between two opponents.
	 * By convention, this.fighter1 is the first to attack.
	 */
	protected void startFight() {
		while(this.fighter1.isAlive() && this.fighter2.isAlive()) {
			this.fighter1.attack(fighter2);
			
			if(this.fighter2.isAlive()) {
				this.fighter2.attack(fighter1);
			}
		}
	}
	
	public Unit getWinner() {
		return this.fighter1.isAlive() ? fighter1 : fighter2;
	}
	
	public Unit getLoser() {
		return this.fighter1.isDead() ? fighter1 : fighter2;
	}
}
