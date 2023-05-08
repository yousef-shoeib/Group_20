package cards;


import java.util.ArrayList;

import model.ItemTileType;

public class PersonalGoalCard8 extends PersonalGoalCard {
	

	/* riga.colonna tipo
	 * 0.4 quadro
	 * 1.1 gatti
	 * 2.2 trofei
	 * 3.0 pianta
	 * 4.3 libro
	 * 5.3 giochi
	 */
	private Match match1= new Match(0, 4, ItemTileType.FRAME);
	private Match match2= new Match(1, 1, ItemTileType.CAT);
	private Match match3= new Match(2, 2, ItemTileType.TROPHY);
	private Match match4= new Match(3, 0, ItemTileType.PLANT);
	private Match match5= new Match(4, 3, ItemTileType.BOOK);
	private Match match6= new Match(5, 3, ItemTileType.GAME);
	private ArrayList<Match> matches= this.fillMatches();
	private String path="./resources/Assets/personalGoalCards/Personal_Goals8.png";
	
}
