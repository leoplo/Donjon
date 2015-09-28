package dungeon.item;

import dungeon.unit.Player;

public abstract class Item {
	
	protected String name;
	
	public Item(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public abstract void use(Player player);
}
