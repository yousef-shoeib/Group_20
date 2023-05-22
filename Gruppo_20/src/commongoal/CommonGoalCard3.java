package commongoal;

import model.Bookshelf;

public class CommonGoalCard3 extends CommonGoalCard {
	private String path = "./resources/Assets/commonGoalCards/3.jpg";
	
	public CommonGoalCard3() {}
	
	public int countVertical(Bookshelf bookshelf, int nTiles) {
		int count=0;
		for(int i=0; i<bookshelf.getRows()-nTiles+1; i++) {
			for(int j=0; j<bookshelf.getColumns(); j++) {
				boolean found = true;
				for(int k=1; k<nTiles; k++) {
					if(!bookshelf.getSlot(i, j).isEmpty() &&
					   !bookshelf.getSlot(i+k,j).isEmpty()) {
								if(!bookshelf.getTile(i, j).equals(bookshelf.getTile(i+k,j))) {
									found = false;
									break;
								}
					      }
				      }
				  if(found) count++;
			   }
		   }
	   return count;
	}
	
	public int countHorizontal(Bookshelf bookshelf ,int nTiles) {
		int count=0;
		for(int j=0; j<bookshelf.getColumns()-nTiles+1; j++) {
			for(int i=0; i<bookshelf.getColumns(); i++) {
				boolean found = true;
				for(int k=1; k<nTiles; k++) {
				if(!bookshelf.getSlot(i, j).isEmpty() &&
				   !bookshelf.getSlot(i,j+k).isEmpty()) {
						if(!bookshelf.getTile(i, j).equals(bookshelf.getTile(i,j+k))) {
							found = false;
							break;
						}
				     }
				  }
			  if(found) count++;
			}
		}
	  return count;
	}
	
	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		int countVertical, countHorizontal;
		countVertical = countVertical(bookshelf,4);
		countHorizontal = countHorizontal(bookshelf,4);
		if((countVertical+countHorizontal) >= 4) return true;
		else return false;
	}
	
	public String getPath() {
		return path;
	}
}
