package cards;

import model.ItemTileType;

public class Match {
	private int row;
	private int column;
	private ItemTileType type;
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public ItemTileType getType() {
		return type;
	}
	public Match(int row, int column, ItemTileType type) {
		this.row = row;
		this.column = column;
		this.type = type;
	}
	
}

