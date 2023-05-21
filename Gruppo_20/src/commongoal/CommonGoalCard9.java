package commongoal;

import model.Bookshelf;

public class CommonGoalCard9 extends CommonGoalCard{
	
	private String path = "./resources/Assets/commonGoalCard/9.png";
	
	public CommonGoalCard9() {}
	
	@Override
	boolean CheckTarget(Bookshelf bookshelf) {
		int count=0;
		for(int i=0; i<bookshelf.getRows();i++) {
			for(int j=0; j<bookshelf.getColumns();j++) {
				if(bookshelf.getSlot(i, j).isEmpty()==false) {
					int matchCount = 1;
					for(int k=i; k<bookshelf.getRows(); k++) {
						for(int l=0; l<bookshelf.getColumns(); l++) {
							if(k==i && l<=j) continue;
							if(bookshelf.getSlot(k, l).isEmpty()==false) {
								if(bookshelf.getTile(k, l)==bookshelf.getTile(i, j)) {
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
