package cards;

import model.Bookshelf;
import model.ItemTileType;

public class PersonalGoalCard10 extends PersonalGoalCard {
	

	/* riga.colonna tipo
	 * 0.4 trofei
	 * 1.1 giochi
	 * 2.0 libro
	 * 3.3 gatti
	 * 4.1 quadri
	 * 5.3 piante
	 */
	private Match match1= new Match(0, 4, ItemTileType.TROPHY);
	private Match match2= new Match(1, 1, ItemTileType.GAME);
	private Match match3= new Match(2, 0, ItemTileType.BOOK);
	private Match match4= new Match(3, 3, ItemTileType.CAT);
	private Match match5= new Match(4, 1, ItemTileType.FRAME);
	private Match match6= new Match(5, 3, ItemTileType.PLANT);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals10.png";
	
}
