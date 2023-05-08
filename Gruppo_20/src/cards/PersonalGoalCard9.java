package cards;

import model.Bookshelf;
import model.ItemTileType;

public class PersonalGoalCard9 extends PersonalGoalCard {
	

	/* riga.colonna tipo
	 * 0.2 giochi
	 * 2.2 gatti
	 * 3.4 libro
	 * 4.1 trofei
	 * 4.4 piante
	 * 5.0 quadri
	 */
	private Match match1= new Match(0, 2, ItemTileType.GAME);
	private Match match2= new Match(2, 2, ItemTileType.CAT);
	private Match match3= new Match(3, 4, ItemTileType.BOOK);
	private Match match4= new Match(4, 1, ItemTileType.TROPHY);
	private Match match5= new Match(4, 4, ItemTileType.PLANT);
	private Match match6= new Match(5, 0, ItemTileType.FRAME);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals9.png";
	
}
