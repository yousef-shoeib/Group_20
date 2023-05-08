package cards;


import java.util.ArrayList;

import model.ItemTileType;

public class PersonalGoalCard4 extends PersonalGoalCard {
	
	/* riga.colonna tipo
	 * 0.4 giochi
	 * 2.0 trofei
	 * 2.2 quadri
	 * 3.3 piante
	 * 4.1 libro
	 * 4.2 gatto
	 */
	private Match match1= new Match(0, 4, ItemTileType.GAME);
	private Match match2= new Match(2, 0, ItemTileType.TROPHY);
	private Match match3= new Match(2, 2, ItemTileType.FRAME);
	private Match match4= new Match(3, 3, ItemTileType.PLANT);
	private Match match5= new Match(4, 1, ItemTileType.BOOK);
	private Match match6= new Match(4, 2, ItemTileType.CAT);
	private ArrayList<Match> matches= this.fillMatches();

	private String path="./resources/Assets/personalGoalCards/Personal_Goals4.png";
	
}
