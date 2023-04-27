package progetto;

import java.util.ArrayList;

public class Bookshelf extends Grid{
	public Bookshelf() {
		super(6,5);
	}
	
	public void addItemTiles(int column, ArrayList<ItemTile> tiles) {
		int n = 0;
		for(int i=0;i<tiles.size();i++) {
			if(this.getTile(i,column)!=null) {
				System.out.println("Not enough slots in the selected column");
				return;
			}			
		}
		
		for(int i=5;n<tiles.size() ;i--) {
			if(this.getTile(i,column)!=null) {
			this.setTile(i, column, tiles.get(n));
			n++;
			}
		}		
	}
	
	public ItemTile getTile(int row, int column) {
		return this.matrGrid[row][column].getItemTile();
	}
	
	public void setTile(int row, int column, ItemTile tile) {
		this.matrGrid[row][column].setItemTile(tile);
	}
	
	public boolean isComplete() {
		for (int i=0;i<5;i++) {
			if(this.matrGrid[0][i].getItemTile()==null) {
				return false;
			}
		}
		return true;
	}
}
