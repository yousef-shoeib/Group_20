package progetto;

public class Slot {
	private boolean state;
	private ItemTile itemTile;
	
	public ItemTile getItemTile() {
		return itemTile;
	}

	public void setItemTile(ItemTile itemTile) {
		this.itemTile = itemTile;
	}

	public String isState() {
		if(state)
			return "T";

		return "F";
	}

	public void setStato(boolean state) {
		this.state = state;
	}

	public Slot()
	{
		this.state = false;
		this.itemTile = null;
	}

}
