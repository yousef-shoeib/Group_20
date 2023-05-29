package commongoal;

import java.util.HashSet;
import java.util.Set;

import model.Bookshelf;
import model.ItemTile;
import model.ItemTileType;
/**
 * La CommonGoalCard6 ha come obiettivo due righe formate ciascuna 
 * da 5 diversi tipi di tessere.
 * @author Anton
 *
 */
public class CommonGoalCard6 extends CommonGoalCard {
	
	private String path = "./resources/Assets/commonGoalCards/6.jpg";
	
	public CommonGoalCard6() {}
	
	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		int unique_rows=0;
		for(int row=0; row < bookshelf.getRows(); row++) {
			Set<ItemTileType> types= new HashSet<>();
			for(int column=0; column<bookshelf.getColumns(); column++) {
				if(bookshelf.getSlot(row,column).isEmpty()) {
					break;
				}
				types.add(bookshelf.getItemTileType(row, column));
			}
			if(types.size()==5)
				unique_rows++;
			
			if(unique_rows==2) 
				return true;
		}
		return false;
	}
	/*public boolean CheckTarget(Bookshelf bookshelf) {
		int unique_rows=0;
		for(int row1=0; row1 < bookshelf.getRows(); row1++) {
			for(int row2=row1+1; row2<bookshelf.getRows(); row2++) {
				boolean only_uniques = true;
				Set<ItemTile> TilesRow1 = new HashSet<ItemTile>();
				Set<ItemTile> TilesRow2 = new HashSet<ItemTile>();
				for(int column=0; column<bookshelf.getColumns(); column++) {
					ItemTile tiles1 = bookshelf.getTile(row1, column);
					ItemTile tiles2 = bookshelf.getTile(row2, column);
					if(TilesRow1.contains(tiles1) || TilesRow2.contains(tiles2)) {
						only_uniques = false;
						break;
					}
					TilesRow1.add(tiles1);
	                TilesRow2.add(tiles2);
				}
				if (only_uniques) {
	                unique_rows++;
	                if (unique_rows == 1) {
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
