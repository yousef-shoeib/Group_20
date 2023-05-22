package commongoal;

import model.Bookshelf;

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
						if(bookshelf.getTile(i, j).equals(bookshelf.getTile(i, j+1)) &&
						   bookshelf.getTile(i, j).equals(bookshelf.getTile(i+1, j)) &&
						   bookshelf.getTile(i, j).equals(bookshelf.getTile(i+1, j+1))) {
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
