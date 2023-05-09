package cards;

import java.util.ArrayList;

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
	private int number=9;
	private Match match1= new Match(0, 2, ItemTileType.GAME);
	private Match match2= new Match(2, 2, ItemTileType.CAT);
	private Match match3= new Match(3, 4, ItemTileType.BOOK);
	private Match match4= new Match(4, 1, ItemTileType.TROPHY);
	private Match match5= new Match(4, 4, ItemTileType.PLANT);
	private Match match6= new Match(5, 0, ItemTileType.FRAME);
	
	private String path="./resources/Assets/personalGoalCards/Personal_Goals9.png";
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
