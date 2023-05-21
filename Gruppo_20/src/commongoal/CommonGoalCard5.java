package commongoal;

import model.Bookshelf;
import model.ItemTile;
import model.ItemTileType;

import java.util.Set;
import java.util.HashSet;

public class CommonGoalCard5 extends CommonGoalCard{
	Bookshelf bookshelf;
	private String path = "./resources/Assets/commonGoalCard/5.png";
	public CommonGoalCard5(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}
	
	private boolean searchColumns() {
		int countColumns=0;
		for(int j=0; j<this.bookshelf.getColumns(); j++) {
			Set<ItemTileType> differentTypes = new HashSet<>();
			for(int i=0; i<this.bookshelf.getRows(); i++) {
				if(this.bookshelf.getSlot(i, j).isEmpty() == false) {
					differentTypes.add(this.bookshelf.getItemTileType(i,j));
					if(differentTypes.size()>3) {
						break;
					}
				}
			}
			if(differentTypes.size()<=3) countColumns++;
		}
		if(countColumns>=3) return true;
		else return false;
	}
	
	@Override
	boolean CheckTarget() {
		boolean check;
		check = searchColumns();
		if(check) return true;
		else return false;
	}
	
	public String getPath() {
		return path;
	}
}
