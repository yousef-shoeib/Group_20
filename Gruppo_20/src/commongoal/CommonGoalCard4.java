package commongoal;
import model.Slot;
import model.Bookshelf;
/**
 * La CommonGoalCard4 ha come obiettivo sei gruppi separati formati ciascuno 
 * da due tessere adiacenti dello stesso tipo, verticalmente o orizzontalmente.
 * Le tessere di un gruppo possono essere diverse da quelle di un altro gruppo. 
 * @author Anton
 *
 */
public class CommonGoalCard4 extends CommonGoalCard{
	
	private String path = "./resources/Assets/commonGoalCards/4.jpg";
	
	public CommonGoalCard4() {}

	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		bookshelf.countGroups();
		int groups=0;
		for(int i: bookshelf.getAdjacentTiles()) {
			if(i>=2)
				groups++;
			if(groups>=6)
				return true;
		}
		return false;
	}
	
	
	public String getPath() {
		return path;
	}
		
	
}
