package commongoal;
import model.Slot;
import model.Bookshelf;

public class CommonGoalCard4 extends CommonGoalCard3{
	
	private String path = "./resources/Assets/commonGoalCards/4.jpg";
	
	public CommonGoalCard4() {
		super();
	}

	@Override
	public int countVertical(Bookshelf bookshelf ,int nTiles) {
		return super.countVertical(bookshelf ,nTiles);
	}

	@Override
	public int countHorizontal(Bookshelf bookshelf ,int nTiles) {
		return super.countHorizontal(bookshelf ,nTiles);
	}

	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		int countVertical = countVertical(bookshelf ,2);
		int countHorizontal = countHorizontal(bookshelf ,2);
		if((countVertical+countHorizontal)>=6) return true;
		else return false;
	}
	
	
	public String getPath() {
		return path;
	}
		
	
}
