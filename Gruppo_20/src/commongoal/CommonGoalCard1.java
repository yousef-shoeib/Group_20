package commongoal;

import model.Bookshelf;

public class CommonGoalCard1 extends CommonGoalCard{
	private String path = "./resources/Assets/commonGoalCard/1.png";
	
	public CommonGoalCard1() {}
	
	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		int count = 0; //conta
		for(int i=0; i<bookshelf.getRows()-1;i++) {
			for(int j=0; j<bookshelf.getColumns()-1;j++) {
				if(bookshelf.getSlot(i, j).isEmpty() == false &&
				   bookshelf.getSlot(i, j+1).isEmpty() == false &&
				   bookshelf.getSlot(i+1, j).isEmpty() == false &&
				   bookshelf.getSlot(i+1,j+1).isEmpty()== false) {
						if(bookshelf.getTile(i, j)==bookshelf.getTile(i, j+1) &&
						   bookshelf.getTile(i, j)==bookshelf.getTile(i+1, j) &&
						   bookshelf.getTile(i, j)==bookshelf.getTile(i+1, j+1)) {
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
