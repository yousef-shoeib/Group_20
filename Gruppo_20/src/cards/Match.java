package cards;

import model.ItemTileType;
/**
 * classe di supporto per la classe PersonalGoalCard
 * @author youse
 *
 */
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
	/**
	 * crea un obiettivo nella cella scelta
	 * @param row riga della cella
	 * @param column colonna della cella 
	 * @param type tipo che la cella deve avere 
	 */
	public Match(int row, int column, ItemTileType type) {
		this.row = row;
		this.column = column;
		this.type = type;
	}
	
}

