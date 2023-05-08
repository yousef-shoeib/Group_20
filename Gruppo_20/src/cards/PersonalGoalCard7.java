package cards;

import java.util.ArrayList;

import model.Bookshelf;
import model.ItemTileType;

public class PersonalGoalCard7 extends PersonalGoalCard {
	

	/* riga.colonna tipo
	 * 0.0 gatti
	 * 1.3 quadri
	 * 2.1 piante
	 * 3.0 trofei
	 * 4.4 giochi
	 * 5.2 libro
	 */
	private Match match1= new Match(0, 0, ItemTileType.TROPHY);
	private Match match2= new Match(1, 3, ItemTileType.TROPHY);
	private Match match3= new Match(2, 1, ItemTileType.TROPHY);
	private Match match4= new Match(3, 0, ItemTileType.TROPHY);
	private Match match5= new Match(4, 4, ItemTileType.TROPHY);
	private Match match6= new Match(5, 2, ItemTileType.TROPHY);
	private ArrayList<Match> matches= this.fillMatches();
	private String path="./resources/Assets/personalGoalCards/Personal_Goals7.png";
	
}
