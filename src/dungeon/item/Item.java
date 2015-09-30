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
	
	/**
	 * Does the action related to this item.
	 * @param player the player who triggered the action.
	 */
	public abstract void itemAction(Player player);
	
	public abstract String getDescription();
}
