package cards;


import model.ItemTileType;

public class PersonalGoalCard2 extends PersonalGoalCard {
	/* riga.colonna tipo
	 * 1.1 pianta
	 * 2.0 gatto
	 * 2.2 gioco
	 * 3.4 libro
	 * 4.3 trofeo
	 * 5.4 quadro
	 */
	
	
	
	private Match match1= new Match(1, 1, ItemTileType.PLANT);
	private Match match2= new Match(2, 0, ItemTileType.CAT);
	private Match match3= new Match(2, 2, ItemTileType.GAME);
	private Match match4= new Match(3, 4, ItemTileType.BOOK);
	private Match match5= new Match(4, 3, ItemTileType.TROPHY);
	private Match match6= new Match(5, 4, ItemTileType.FRAME);
	private String path="./resources/Assets/personalGoalCards/Personal_Goals2.png";
	
	
}

