package cards;


import java.util.ArrayList;

import model.ItemTileType;

public class PersonalGoalCard5 extends PersonalGoalCard {
	

	/* riga.colonna tipo
	 * 1.1 trofei
	 * 3.1 quadri
	 * 3.2 libri
	 * 4.4 piante
	 * 5.0 giochi
	 * 5.3 gatto
	 */
	private Match match1= new Match(1, 1, ItemTileType.TROPHY);
	private Match match2= new Match(3, 1, ItemTileType.FRAME);
	private Match match3= new Match(3, 2, ItemTileType.BOOK);
	private Match match4= new Match(4, 4, ItemTileType.PLANT);
	private Match match5= new Match(5, 0, ItemTileType.GAME);
	private Match match6= new Match(5, 3, ItemTileType.CAT);
	private ArrayList<Match> matches= this.fillMatches();
	private String path="./resources/Assets/personalGoalCards/Personal_Goals5.png";
	
}
