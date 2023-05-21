package commongoal;

import model.Bookshelf;
import model.ItemTile;
import model.Slot;

public class CommonGoalCard10 extends CommonGoalCard{
	
	private String path = "./resources/Assets/commonGoalCard/10.png";
	
	public CommonGoalCard10() {}
	
	@Override
	boolean CheckTarget(Bookshelf bookshelf) {
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
	
	public String getPath() {
		return path;
	}
	
}
