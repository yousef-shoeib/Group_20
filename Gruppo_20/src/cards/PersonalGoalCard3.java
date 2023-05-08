package cards;

import model.Bookshelf;
import model.ItemTileType;

public class PersonalGoalCard3 extends PersonalGoalCard {

	/* riga.colonna tipo
	 * 1.0 quadro
	 * 1.3 giochi
	 * 2.2 painta
	 * 3.1 gatto
	 * 3.4 trofei
	 * 5.0 libro
	 */
	private Match match1= new Match(1, 0, ItemTileType.FRAME);
	private Match match2= new Match(1, 3, ItemTileType.GAME);
	private Match match3= new Match(2, 2, ItemTileType.PLANT);
	private Match match4= new Match(3, 1, ItemTileType.CAT);
	private Match match5= new Match(3, 4, ItemTileType.TROPHY);
	private Match match6= new Match(5, 0, ItemTileType.BOOK);
	
	private String path="./resources/Assets/personalGoalCards/Personal_Goals3.png";
	
}
