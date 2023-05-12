package commongoal;

import model.Bookshelf;
import model.ItemTile;
import model.Slot;

public class CommonGoalCard10 extends CommonGoalCard{
	Bookshelf bookshelf;
	public CommonGoalCard10(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}
	@Override
	boolean CheckTarget(Bookshelf b) {
		for(int i=1; i<bookshelf.getRows()-1; i++) {
			for(int j=1; j<bookshelf.getColumns()-1; j++) {
				if(bookshelf.getSlot(i, j).isEmpty() == false &&
				   bookshelf.getSlot(i-1, j-1).isEmpty() == false &&
				   bookshelf.getSlot(i+1, j-1).isEmpty() == false &&
				   bookshelf.getSlot(i-1, j+1).isEmpty() == false &&
				   bookshelf.getSlot(i+1, j+1).isEmpty() == false){
					
					if(bookshelf.getTile(i-1, j-1)==bookshelf.getTile(i,j) &&
					   bookshelf.getTile(i+1, j-1)==bookshelf.getTile(i,j) &&
					   bookshelf.getTile(i-1, j+1)==bookshelf.getTile(i,j) &&
					   bookshelf.getTile(i+1, j+1)==bookshelf.getTile(i,j)) {
						return true;
					}
				 }
			  }
		   }
		return false;
	}
	
}
