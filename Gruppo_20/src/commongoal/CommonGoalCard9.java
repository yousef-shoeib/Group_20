package commongoal;

import model.Bookshelf;

public class CommonGoalCard9 extends CommonGoalCard{
	Bookshelf bookshelf;
	public CommonGoalCard9(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}
	@Override
	boolean CheckTarget() {
		int count=0;
		for(int i=0; i<this.bookshelf.getRows();i++) {
			for(int j=0; j<this.bookshelf.getColumns();j++) {
				if(this.bookshelf.getSlot(i, j).isEmpty()==false) {
					int matchCount = 1;
					for(int k=i; k<this.bookshelf.getRows(); k++) {
						for(int l=0; l<this.bookshelf.getColumns(); l++) {
							if(k==i && l<=j) continue;
							if(this.bookshelf.getSlot(k, l).isEmpty()==false) {
								if(this.bookshelf.getTile(k, l)==this.bookshelf.getTile(i, j)) {
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
    }
