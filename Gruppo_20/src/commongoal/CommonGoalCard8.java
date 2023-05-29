package commongoal;
import model.Bookshelf;
import model.ItemTileType;

/**
 * La CommonGoalCard8 ha come obiettivo quattro tessere dello stesso tipo 
 * ai quattro angoli della Libreria.
 * @author Anton
 *
 */
public class CommonGoalCard8 extends CommonGoalCard{
	
	private String path = "./resources/Assets/commonGoalCards/8.jpg";
	
	public CommonGoalCard8() {}
	
	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		boolean check = false;
		if(!bookshelf.getSlot(0, 0).isEmpty()&& 
		   !bookshelf.getSlot(0, 4).isEmpty()&&
		   !bookshelf.getSlot(5, 4).isEmpty()&&
		   !bookshelf.getSlot(5, 0).isEmpty()){
			ItemTileType type= bookshelf.getTile(0, 0).getType();
					if(type.equals(bookshelf.getTile(0, 4).getType()) &&
							type.equals(bookshelf.getTile(5, 4).getType()) &&
									type.equals(bookshelf.getTile(5, 0).getType())) {
			                             check = true;
					}
		}
		return check;
	}
	
	public String getPath() {
		return path;
	}
	
}
