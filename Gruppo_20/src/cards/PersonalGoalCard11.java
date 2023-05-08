package cards;

import model.Bookshelf;
import model.ItemTileType;

public class PersonalGoalCard11 extends PersonalGoalCard {
	

	/* riga.colonna tipo
	 * 0.2 piante
	 * 1.1 libro
	 * 2.0 giochi
	 * 3.2 quadri
	 * 4.4 gatti
	 * 5.3 trofei
	 */
	private Match match1= new Match(0, 2, ItemTileType.PLANT);
	private Match match2= new Match(1, 1, ItemTileType.BOOK);
	private Match match3= new Match(2, 0, ItemTileType.GAME);
	private Match match4= new Match(3, 2, ItemTileType.FRAME);
	private Match match5= new Match(4, 4, ItemTileType.CAT);
	private Match match6= new Match(5, 3, ItemTileType.TROPHY);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals11.png";
	
}

