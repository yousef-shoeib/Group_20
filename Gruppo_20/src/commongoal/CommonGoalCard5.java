package commongoal;

import model.Bookshelf;
import model.ItemTile;
import model.ItemTileType;

import java.util.Set;
import java.util.HashSet;

public class CommonGoalCard5 extends CommonGoalCard{
	
	private String path = "./resources/Assets/commonGoalCard/5.png";
	
	public CommonGoalCard5() {}
	
	private boolean searchColumns(Bookshelf bookshelf) {
		int countColumns=0;
		for(int j=0; j<bookshelf.getColumns(); j++) {
			Set<ItemTileType> differentTypes = new HashSet<>();
			for(int i=0; i<bookshelf.getRows(); i++) {
				if(bookshelf.getSlot(i, j).isEmpty() == false) {
					differentTypes.add(bookshelf.getItemTileType(i,j));
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
	boolean CheckTarget(Bookshelf bookshelf) {
		boolean check;
		check = searchColumns(bookshelf);
		if(check) return true;
		else return false;
	}
	
	public String getPath() {
		return path;
	}
}
