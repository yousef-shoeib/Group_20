package commongoal;

import model.Bookshelf;

public class CommonGoalCard11 extends CommonGoalCard {
	Bookshelf bookshelf;
	private String path = "./resources/Assets/commonGoalCard/11.png";
	public CommonGoalCard11(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}
	@Override
	boolean CheckTarget() {
		for(int i=0; i<this.bookshelf.getRows(); i++) {
			for(int j=0; j<this.bookshelf.getColumns();j++) {
				int count=1;
				
				for(int k=1; k<5 && i+k < this.bookshelf.getColumns() && j+k <this.bookshelf.getRows(); k++) {
					if(this.bookshelf.getSlot(i+k, j+k).isEmpty() == false && this.bookshelf.getSlot(i, j).isEmpty()==false) {
							if(this.bookshelf.getTile(i+k, j+k) == this.bookshelf.getTile(i, j)){
								count++;
									if(count==5) return true;
									else break;
						}
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
