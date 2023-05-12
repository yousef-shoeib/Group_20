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
	boolean CheckTarget() {
		for(int i=1; i<this.bookshelf.getRows()-1; i++) {
			for(int j=1; j<this.bookshelf.getColumns()-1; j++) {
				if(this.bookshelf.getSlot(i, j).isEmpty() == false &&
				   this.bookshelf.getSlot(i-1, j-1).isEmpty() == false &&
				   this.bookshelf.getSlot(i+1, j-1).isEmpty() == false &&
				   this.bookshelf.getSlot(i-1, j+1).isEmpty() == false &&
				   this.bookshelf.getSlot(i+1, j+1).isEmpty() == false){
					
					if(this.bookshelf.getTile(i-1, j-1)==this.bookshelf.getTile(i,j) &&
					   this.bookshelf.getTile(i+1, j-1)==this.bookshelf.getTile(i,j) &&
					   this.bookshelf.getTile(i-1, j+1)==this.bookshelf.getTile(i,j) &&
					   this.bookshelf.getTile(i+1, j+1)==this.bookshelf.getTile(i,j)) {
						return true;
					}
				 }
			  }
		   }
		return false;
	}
	
}
