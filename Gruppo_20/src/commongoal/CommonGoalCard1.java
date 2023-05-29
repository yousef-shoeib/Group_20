package commongoal;

import model.Bookshelf;
import model.ItemTileType;

public class CommonGoalCard1 extends CommonGoalCard{
	private String path = "./resources/Assets/commonGoalCards/1.jpg";
	public CommonGoalCard1() {}
	
	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		int count = 0; 
		for(int i=0; i<bookshelf.getRows()-1;i++) {
			for(int j=0; j<bookshelf.getColumns()-1;j++) {
				if(!bookshelf.getSlot(i, j).isEmpty()   &&
				   !bookshelf.getSlot(i, j+1).isEmpty() &&
				   !bookshelf.getSlot(i+1, j).isEmpty() &&
				   !bookshelf.getSlot(i+1,j+1).isEmpty()) {
					//associo al variabile type il tipo di riferimento da controllare
					ItemTileType type= bookshelf.getTile(i, j).getType();
						if(type.equals(bookshelf.getTile(i, j+1).getType()) &&
						   type.equals(bookshelf.getTile(i+1, j).getType()) &&
						   type.equals(bookshelf.getTile(i+1, j+1).getType())) {
							count++;
						}
				      }
			       }
		         }
	    if(count>=2) return true;
	    else return false;
	}
	
	public String getPath() {
		return path;
	}
}
