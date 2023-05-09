package cards;


import java.util.ArrayList;

import model.Bookshelf;
import model.ItemTileType;

public class PersonalGoalCard8 extends PersonalGoalCard {
	

	/* riga.colonna tipo
	 * 0.4 quadro
	 * 1.1 gatti
	 * 2.2 trofei
	 * 3.0 pianta
	 * 4.3 libro
	 * 5.3 giochi
	 */
	private int number=8;
	private Match match1= new Match(0, 4, ItemTileType.FRAME);
	private Match match2= new Match(1, 1, ItemTileType.CAT);
	private Match match3= new Match(2, 2, ItemTileType.TROPHY);
	private Match match4= new Match(3, 0, ItemTileType.PLANT);
	private Match match5= new Match(4, 3, ItemTileType.BOOK);
	private Match match6= new Match(5, 3, ItemTileType.GAME);
	private String path="./resources/Assets/personalGoalCards/Personal_Goals8.png";
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
