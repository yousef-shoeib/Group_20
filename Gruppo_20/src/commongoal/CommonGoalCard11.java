package commongoal;

import model.Bookshelf;

public class CommonGoalCard11 extends CommonGoalCard {
	
	private String path = "./resources/Assets/commonGoalCard/11.png";
	
	public CommonGoalCard11() {}
	
	@Override
	boolean CheckTarget(Bookshelf bookshelf) {
		for(int i=0; i<bookshelf.getRows(); i++) {
			for(int j=0; j<bookshelf.getColumns();j++) {
				int count=1;
				
				for(int k=1; k<5 && i+k < bookshelf.getColumns() && j+k <bookshelf.getRows(); k++) {
					if(bookshelf.getSlot(i+k, j+k).isEmpty() == false && bookshelf.getSlot(i, j).isEmpty()==false) {
							if(bookshelf.getTile(i+k, j+k) == bookshelf.getTile(i, j)){
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
