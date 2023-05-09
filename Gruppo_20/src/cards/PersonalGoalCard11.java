package cards;

import java.util.ArrayList;

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
	private int number=11;
	private Match match1= new Match(0, 2, ItemTileType.PLANT);
	private Match match2= new Match(1, 1, ItemTileType.BOOK);
	private Match match3= new Match(2, 0, ItemTileType.GAME);
	private Match match4= new Match(3, 2, ItemTileType.FRAME);
	private Match match5= new Match(4, 4, ItemTileType.CAT);
	private Match match6= new Match(5, 3, ItemTileType.TROPHY);
	
	private String path="./resources/Assets/personalGoalCards/Personal_Goals11.png";
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
}

