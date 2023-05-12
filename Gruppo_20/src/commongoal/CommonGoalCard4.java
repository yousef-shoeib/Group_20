package commongoal;
import model.Slot;
import model.Bookshelf;

public class CommonGoalCard4 extends CommonGoalCard{
	Bookshelf bookshelf;
	public CommonGoalCard4(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}
	
	private int countHorizontal() {
		int count=0;
		for(int i=0; i<this.bookshelf.getRows(); i++) {
			for(int j=0; j<this.bookshelf.getColumns()-1; j++) {
				if(this.bookshelf.getSlot(i, j).isEmpty() == false &&
				   this.bookshelf.getSlot(i, j+1).isEmpty() == false) {
							if(this.bookshelf.getTile(i, j) == this.bookshelf.getTile(i, j+1)) count++;
				}
			}
		}
		return count;
	}
	
	private int countVertical() {
		int count=0;
		for(int j=0; j<bookshelf.getColumns(); j++) {
			for(int i=0; i<bookshelf.getRows()-1; i++) {
				if(this.bookshelf.getSlot(i, j).isEmpty() == false &&
				   this.bookshelf.getSlot(i+1,j).isEmpty()==false) {
							if(this.bookshelf.getTile(i, j) == this.bookshelf.getTile(i+1, j)) count++;
				}
			}
		}
		return count;
	}

	@Override
	boolean CheckTarget() {
		int countVertical, countHorizontal;
		countVertical = countVertical();
		countHorizontal = countHorizontal();
		if((countHorizontal+countVertical)>=6) return true;
		else return false;
	}
	
	
	
	
}
