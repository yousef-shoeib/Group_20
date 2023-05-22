package commongoal;

import model.Bookshelf;
import model.ItemTile;
import model.ItemTileType;
import model.Slot;

public class CommonGoalCard10 extends CommonGoalCard{
	
	private String path = "./resources/Assets/commonGoalCards/10.jpg"; //percorso
	
	public CommonGoalCard10() {}
	
	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		for(int i=1; i<bookshelf.getRows()-1; i++) {
			for(int j=1; j<bookshelf.getColumns()-1; j++) {
				if(!bookshelf.getSlot(i, j).isEmpty()  &&
				   !bookshelf.getSlot(i-1, j-1).isEmpty()  &&
				   !bookshelf.getSlot(i+1, j-1).isEmpty()  &&
				   !bookshelf.getSlot(i-1, j+1).isEmpty()  &&
				   !bookshelf.getSlot(i+1, j+1).isEmpty() ){
					ItemTileType type=bookshelf.getTile(i,j).getType();
					if(bookshelf.getTile(i-1, j-1).getType().equals(type) &&
					   bookshelf.getTile(i+1, j-1).getType().equals(type) &&
					   bookshelf.getTile(i-1, j+1).getType().equals(type) &&
					   bookshelf.getTile(i+1, j+1).getType().equals(type)) {
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
