package commongoal;
import model.Slot;
import model.Bookshelf;

public class CommonGoalCard4 extends CommonGoalCard3{
	private String path = "./resources/Assets/commonGoalCard/4.png";
	public CommonGoalCard4(Bookshelf bookshelf) {
		super(bookshelf);
	}

	@Override
	public int countVertical(int nTiles) {
		return super.countVertical(nTiles);
	}

	@Override
	public int countHorizontal(int nTiles) {
		return super.countHorizontal(nTiles);
	}

	@Override
	boolean CheckTarget() {
		int countVertical = countVertical(2);
		int countHorizontal = countHorizontal(2);
		if((countVertical+countHorizontal)>=6) return true;
		else return false;
	}
	
	
	public String getPath() {
		return path;
	}
		
	
}
