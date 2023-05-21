package commongoal;

import model.Bookshelf;

public class CommonGoalCard11 extends CommonGoalCard {
	
	private String path = "./resources/Assets/commonGoalCards/11.jpg";
	
	public CommonGoalCard11() {}
	
	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		for(int i=0; i<bookshelf.getRows()-1; i++) {
			for(int j=0; j<bookshelf.getColumns()-1;j++) {
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
