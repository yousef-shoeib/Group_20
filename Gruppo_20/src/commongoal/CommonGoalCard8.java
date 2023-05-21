package commongoal;
import model.Bookshelf;
public class CommonGoalCard8 extends CommonGoalCard{
	Bookshelf bookshelf;
	private String path = "./resources/Assets/commonGoalCard/8.png";
	public CommonGoalCard8(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}
	@Override
	boolean CheckTarget() {
		boolean check = false;
		if(this.bookshelf.getSlot(0, 0).isEmpty()==false && 
		   this.bookshelf.getSlot(0, 4).isEmpty()==false &&
		   this.bookshelf.getSlot(5, 4).isEmpty()==false &&
		   this.bookshelf.getSlot(5, 0).isEmpty()==false) {
					if(this.bookshelf.getTile(0, 0)==this.bookshelf.getTile(0, 4) &&
				       this.bookshelf.getTile(0, 4)==this.bookshelf.getTile(5, 4) &&
					   this.bookshelf.getTile(5, 4)==this.bookshelf.getTile(5, 0)) {
			                             check = true;
					}
		}
		return check;
	}
	
}
