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
	private int number=1;
	private Match match1=new Match(0,0, ItemTileType.PLANT );
	private Match match2=new Match(0,2, ItemTileType.FRAME );
	private Match match3=new Match(1,4, ItemTileType.CAT );
	private Match match4=new Match(2,3, ItemTileType.BOOK );
	private Match match5=new Match(3,1, ItemTileType.GAME );
	private Match match6=new Match(5,2, ItemTileType.TROPHY );
	@Override
	public int getCardNumber() {
		return this.number;
	}
	@Override
	
	public ArrayList<Match> fillMatches() {
		ArrayList<Match> matches= new ArrayList<>();
		matches.add(match1);
		matches.add(match2);
		matches.add(match3);
		matches.add(match4);
		matches.add(match5);
		matches.add(match6);
		return matches;
	}
	private ArrayList<Match> matches= this.fillMatches();
	public int countMatches(Bookshelf b) {
		int counter=0;
		for(Match match: matches) {
			if(isColorMatching(b, match)) {
				counter++;
			}
		}
		return counter;
	}
	private String path="./resources/Assets/personalGoalCards/Personal_Goals1.png";
	
	
	
}
