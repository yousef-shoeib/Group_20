package cards;


import java.util.ArrayList;

import model.Bookshelf;
import model.ItemTileType;

public class PersonalGoalCard4 extends PersonalGoalCard {
	
	/* riga.colonna tipo
	 * 0.4 giochi
	 * 2.0 trofei
	 * 2.2 quadri
	 * 3.3 piante
	 * 4.1 libro
	 * 4.2 gatto
	 */
	private int number=4;
	private Match match1= new Match(0, 4, ItemTileType.GAME);
	private Match match2= new Match(2, 0, ItemTileType.TROPHY);
	private Match match3= new Match(2, 2, ItemTileType.FRAME);
	private Match match4= new Match(3, 3, ItemTileType.PLANT);
	private Match match5= new Match(4, 1, ItemTileType.BOOK);
	private Match match6= new Match(4, 2, ItemTileType.CAT);

	private String path="./resources/Assets/personalGoalCards/Personal_Goals4.png";
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
