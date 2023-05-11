package commongoal;
import model.Bookshelf;
public class CommonGoalCard8 extends CommonGoalCard{
	Bookshelf bookshelf;
	public CommonGoalCard8(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}
	@Override
	boolean CheckTarget(Bookshelf bookshelf) {
		boolean check = false;
		if(bookshelf.getSlot(0, 0).isEmpty()==false && 
		   bookshelf.getSlot(0, 4).isEmpty()==false &&
		   bookshelf.getSlot(5, 4).isEmpty()==false &&
		   bookshelf.getSlot(5, 0).isEmpty()==false) {
					if(bookshelf.getTile(0, 0)==bookshelf.getTile(0, 4) &&
				       bookshelf.getTile(0, 4)==bookshelf.getTile(5, 4) &&
					   bookshelf.getTile(5, 4)==bookshelf.getTile(5, 0)) {
			                             check = true;
					}
		}
		return check;
	}
	
}
