package dungeon.combat;

import dungeon.unit.Unit;

public class Combat {
	protected Unit fighter1, fighter2;
	
	public Combat(Unit fighter1, Unit fighter2) {
		this.fighter1 = fighter1;
		this.fighter2 = fighter2;
		this.startFight();
	}
	
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
