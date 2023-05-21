package commongoal;

import model.Bookshelf;
import model.ItemTileType;

import java.util.Set;
import java.util.HashSet;

public class CommonGoalCard7 extends CommonGoalCard{
	Bookshelf bookshelf;
	private String path = "./resources/Assets/commonGoalCard/7.png";
	public CommonGoalCard7(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}
	
	private boolean searchRows() {
		int countRows=0;
		for(int i=0; i<this.bookshelf.getRows(); i++) {
			Set<ItemTileType> differentType = new HashSet<>();
			for(int j=0; j<this.bookshelf.getColumns(); j++) {
				if(this.bookshelf.getSlot(i, j).isEmpty() == false) {
					differentType.add(this.bookshelf.getItemTileType(i, j));
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
	boolean CheckTarget() {
		boolean check;
		check = searchRows();
		if(check) return true;
		else return false;
		
	}
	
	public String getPath() {
		return path;
	}

}
