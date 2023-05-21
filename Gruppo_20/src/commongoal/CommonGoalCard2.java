package commongoal;
import model.ItemTile;

import java.util.HashSet;
import java.util.Set;

import model.Bookshelf;

public class CommonGoalCard2 extends CommonGoalCard{
	Bookshelf bookshelf;
	private String path = "./resources/Assets/commonGoalCard/2.png";
	public CommonGoalCard2(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}
	@Override
	boolean CheckTarget() {
		int unique_columns=0;
		for(int column1=0; column1<this.bookshelf.getColumns(); column1++) {
			for(int column2=column1+1; column2<this.bookshelf.getColumns(); column2++) {
				boolean only_uniques = true;
				Set<ItemTile> TilesColumn1 = new HashSet<ItemTile>();
				Set<ItemTile> TilesColumn2 = new HashSet<ItemTile>();
				for(int row=0; row<this.bookshelf.getRows(); row++) {
					ItemTile tiles1 = this.bookshelf.getTile(row, column1);
					ItemTile tiles2 = this.bookshelf.getTile(row, column2);
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
	}
}
