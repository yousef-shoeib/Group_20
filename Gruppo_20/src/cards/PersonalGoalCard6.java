package cards;

import model.Bookshelf;
import model.ItemTileType;

public class PersonalGoalCard6 extends PersonalGoalCard {
	

	/* riga.colonna tipo
	 * 0.2 trofei
	 * 0.4 gatto
	 * 2.3 libro
	 * 4.1 giochi
	 * 4.3 quadri
	 * 5.0 piante
	 */
	private Match match1= new Match(0, 2, ItemTileType.TROPHY);
	private Match match2= new Match(0, 4, ItemTileType.CAT);
	private Match match3= new Match(2, 3, ItemTileType.BOOK);
	private Match match4= new Match(4, 1, ItemTileType.GAME);
	private Match match5= new Match(4, 3, ItemTileType.FRAME);
	private Match match6= new Match(5, 0, ItemTileType.PLANT);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals6.png";
	
}
