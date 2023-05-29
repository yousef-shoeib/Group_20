package commongoal;

import model.Bookshelf;
/**
 * La CommoonGoalCard3 ha come obiettivo quattro gruppi separati formati ciascuno 
 * da quattro tessere adiacenti dello stesso tipo, Verticalmente oppure orizzontalmente. 
 * Le tessere di un gruppo possono essere diverse da quelle di un altro gruppo. 
 * @author Anton
 *
 */
public class CommonGoalCard3 extends CommonGoalCard {
	private String path = "./resources/Assets/commonGoalCards/3.jpg";
	
	public CommonGoalCard3() {}
	
	/*public int countVertical(Bookshelf bookshelf, int nTiles) {
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
	}*/
	
	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		bookshelf.countGroups();
		int groups=0;
		for(int i: bookshelf.getAdjacentTiles()) {
			if(i>=4)
				groups++;
			if(groups>=4)
				return true;
		}
		return false;
	}
	
	public String getPath() {
		return path;
	}
}
