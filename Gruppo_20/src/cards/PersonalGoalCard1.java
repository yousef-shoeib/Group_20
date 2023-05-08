package cards;

import java.util.ArrayList;

import model.Bookshelf;
import model.ItemTileType;

public class PersonalGoalCard1 extends PersonalGoalCard {
	
	/* riga.colonna tipo
	 * 0.0 pianta
	 * 0.2 quadro
	 * 1.4 gatto
	 * 2.3 libro
	 * 3.1 giochi
	 * 5.2 trofei
	 */
	
	private Match match1=new Match(0,0, ItemTileType.PLANT );
	private Match match2=new Match(0,2, ItemTileType.FRAME );
	private Match match3=new Match(1,4, ItemTileType.CAT );
	private Match match4=new Match(2,3, ItemTileType.BOOK );
	private Match match5=new Match(3,1, ItemTileType.GAME );
	private Match match6=new Match(5,2, ItemTileType.TROPHY );
	private ArrayList<Match> matches= this.fillMatches();
	private String path="./resources/Assets/personalGoalCards/Personal_Goals1.png";
	
}
