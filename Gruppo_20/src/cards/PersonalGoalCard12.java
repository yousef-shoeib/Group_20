package cards;

import model.Bookshelf;
import model.ItemTileType;

public class PersonalGoalCard12 extends PersonalGoalCard {
	

	/* riga.colonna tipo
	 * 0.2 libri
	 * 1.1 piante
	 * 2.2 quadri
	 * 3.3 trofei
	 * 4.4 giochi
	 * 5.0 gatti
	 */
	private Match match1= new Match(0, 2, ItemTileType.BOOK);
	private Match match2= new Match(1, 1, ItemTileType.PLANT);
	private Match match3= new Match(2, 2, ItemTileType.FRAME);
	private Match match4= new Match(3, 3, ItemTileType.TROPHY);
	private Match match5= new Match(4, 4, ItemTileType.GAME);
	private Match match6= new Match(5, 0, ItemTileType.CAT);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals12.png";
	
}

