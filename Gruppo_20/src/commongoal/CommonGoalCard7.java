package commongoal;

import model.Bookshelf;
import model.ItemTileType;

import java.util.Set;
import java.util.HashSet;

public class CommonGoalCard7 extends CommonGoalCard{
	
	private String path = "./resources/Assets/commonGoalCard/7.png";
	
	public CommonGoalCard7() {}
	
	private boolean searchRows(Bookshelf bookshelf) {
		int countRows=0;
		for(int i=0; i<bookshelf.getRows(); i++) {
			Set<ItemTileType> differentType = new HashSet<>();
			for(int j=0; j<bookshelf.getColumns(); j++) {
				if(bookshelf.getSlot(i, j).isEmpty() == false) {
					differentType.add(bookshelf.getItemTileType(i, j));
					if(differentType.size()>3) {
						break;
					}
				}
			}
			if(differentType.size()<=3) countRows++;
		}
		if(countRows>=4) return true;
		else return false;
	}
	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		boolean check;
		check = searchRows(bookshelf);
		if(check) return true;
		else return false;
		
	}
	
	public String getPath() {
		return path;
	}

}
