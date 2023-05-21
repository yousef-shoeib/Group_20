package commongoal;

import model.Bookshelf;

public class CommonGoalCard1 extends CommonGoalCard{
	Bookshelf bookshelf;
	private String path = "./resources/Assets/commonGoalCard/1.png";
	public CommonGoalCard1(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}
	@Override
	boolean CheckTarget() {
		int count = 0;
		for(int i=0; i<this.bookshelf.getRows()-1;i++) {
			for(int j=0; j<this.bookshelf.getColumns()-1;j++) {
				if(this.bookshelf.getSlot(i, j).isEmpty() == false &&
				   this.bookshelf.getSlot(i, j+1).isEmpty() == false &&
				   this.bookshelf.getSlot(i+1, j).isEmpty() == false &&
				   this.bookshelf.getSlot(i+1,j+1).isEmpty()== false) {
						if(this.bookshelf.getTile(i, j)==this.bookshelf.getTile(i, j+1) &&
						   this.bookshelf.getTile(i, j)==this.bookshelf.getTile(i+1, j) &&
						   this.bookshelf.getTile(i, j)==this.bookshelf.getTile(i+1, j+1)) {
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
