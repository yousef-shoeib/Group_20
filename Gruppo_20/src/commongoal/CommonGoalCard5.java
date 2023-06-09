package commongoal;

import model.Bookshelf;
import model.ItemTile;
import model.ItemTileType;

import java.util.Set;
import java.util.HashSet;

/**
 * La CommonGoalCard5 ha come obiettivo tre colonne formate ciascuna da 
 * 6 tessere di uno, due o tre tipi differenti. Colonne diverse possono avere 
 * combinazioni diverse di tipi di tessere.
 * @author Anton
 *
 */
public class CommonGoalCard5 extends CommonGoalCard{
	
	private String path = "./resources/Assets/commonGoalCards/5.jpg";
	
	public CommonGoalCard5() {}
	
	private boolean searchColumns(Bookshelf bookshelf) {
		int countColumns=0;
		for(int j=0; j<bookshelf.getColumns(); j++) {
			Set<ItemTileType> differentTypes = new HashSet<>();
			for(int i=0; i<bookshelf.getRows(); i++) {
				if(bookshelf.getSlot(i, j).isEmpty()) {
					break;
				}
				else {
					differentTypes.add(bookshelf.getItemTileType(i,j));
					if(differentTypes.size()>3) {
						break;
					}
				}
				if(differentTypes.size()<=3 && i== 5) countColumns++;
			}
			if(countColumns>=3) return true;
		}
		return false;
	}
	
	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		boolean check;
		check = searchColumns(bookshelf);
		if(check) return true;
		else return false;
	}
	
	public String getPath() {
		return path;
	}
}
