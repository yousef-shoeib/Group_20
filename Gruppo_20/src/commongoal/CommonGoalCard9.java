package commongoal;

import model.Bookshelf;

public class CommonGoalCard9 extends CommonGoalCard{
	
	private String path = "./resources/Assets/commonGoalCards/9.jpg";
	
	public CommonGoalCard9() {}
	
	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		int count=0;
		for(int i=0; i<bookshelf.getRows();i++) {
			for(int j=0; j<bookshelf.getColumns();j++) {
				if(!bookshelf.getSlot(i, j).isEmpty()) {
					int matchCount = 1;
					for(int k=i; k<bookshelf.getRows(); k++) {
						for(int l=0; l<bookshelf.getColumns(); l++) {
							if(k==i && l<=j) continue;
							if(!bookshelf.getSlot(k, l).isEmpty()) {
								if(bookshelf.getTile(k, l).equals(bookshelf.getTile(i, j))) {
									matchCount++;
									if(matchCount==8) {
										count=1;
										break;
									}
								}
							}
						}
				  if(matchCount==8) break;
			    }
			  }
			}
		  }
		if(count==1) return true;
		else return false;
	  }
	
	public String getPath() {
		return path;
	}
    }
