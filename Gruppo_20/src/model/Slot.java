package model;

public class Slot {
	
	private int id;
	private int x;
	private int y;
	private boolean state;
	private ItemTile itemTile;
	
	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public ItemTile getItemTile() {
		if(this.itemTile == null)
			throw new NullPointerException("no tile in slot");
			
		return itemTile;
		
	}

	public void setItemTile(ItemTile itemTile) {
		this.itemTile = itemTile;
	}

	public boolean State() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	public boolean isEmpty()
	{
		if(this.itemTile == null)
		{
			return true;
		}
		return false;
	}

	/**
	 * Default Constructor
	 */
	public Slot()
	{
		this.state = false;
		this.itemTile = null;
	}
	
	
				


}
