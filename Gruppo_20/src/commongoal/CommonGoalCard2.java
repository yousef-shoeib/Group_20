package commongoal;
import model.ItemTile;


import java.util.HashSet;
import java.util.Set;

import model.Bookshelf;
import model.ItemTileType;

/**
 * La CommonGoalCard2 ha come obiettivo due colonne formate ciascuna 
 * da 6 diversi tipi di tessere.
 * @author Anton
 *
 */
public class CommonGoalCard2 extends CommonGoalCard{
	private String path = "./resources/Assets/commonGoalCards/2.jpg";
	
	public CommonGoalCard2() {}
	
	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		int unique_columns=0;
		for(int column=0; column<bookshelf.getColumns(); column++) {
			Set<ItemTileType> types= new HashSet<>();
			for(int row=0; row<bookshelf.getRows(); row++) {
				if(bookshelf.getSlot(row,column).isEmpty()) {
					break;
				}
				types.add(bookshelf.getItemTileType(row, column));
			}
			if(types.size()==6)
				unique_columns++;
			
			if(unique_columns==2) 
				return true;
		}
		return false;
	}
	/*
	public boolean CheckTarget(Bookshelf bookshelf) {
		int unique_columns=0;
		for(int column1=0; column1<bookshelf.getColumns(); column1++) {
			for(int column2=column1+1; column2<bookshelf.getColumns(); column2++) {
				boolean only_uniques = true;
				Set<ItemTileType> TilesColumn1 = new HashSet<ItemTileType>();
				Set<ItemTileType> TilesColumn2 = new HashSet<ItemTileType>();
				for(int row=0; row<bookshelf.getRows(); row++) {
					ItemTileType tiles1 = bookshelf.getTile(row, column1).getType();
					ItemTileType tiles2 = bookshelf.getTile(row, column2).getType();
					if(TilesColumn1.contains(tiles1)||TilesColumn2.contains(tiles2)) {
						only_uniques = false;
						break;
					}
					TilesColumn1.add(tiles1);
	                TilesColumn2.add(tiles2);
				}
				if (only_uniques) {
	                unique_columns++;
	                if (unique_columns == 1) {
	                    return true;
	                }
			    }
		    }
	    }
		return false;
	}*/
	
	public String getPath() {
		return path;
	}
}
