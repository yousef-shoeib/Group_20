package cards;

import java.util.ArrayList;

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
	private int number=3;
	private Match match1= new Match(1, 0, ItemTileType.FRAME);
	private Match match2= new Match(1, 3, ItemTileType.GAME);
	private Match match3= new Match(2, 2, ItemTileType.PLANT);
	private Match match4= new Match(3, 1, ItemTileType.CAT);
	private Match match5= new Match(3, 4, ItemTileType.TROPHY);
	private Match match6= new Match(5, 0, ItemTileType.BOOK);
	private String path="./resources/Assets/personalGoalCards/Personal_Goals3.png";
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
	public int getPoints(Bookshelf b) {
		int numberOfMatches=this.countMatches(b);
		int points=0;
		if(numberOfMatches==1||numberOfMatches==2) {
			points=numberOfMatches;
		}
		if(numberOfMatches==3) {
			points=4;
		}
		if(numberOfMatches==4) {
			points=6;
		}
		if(numberOfMatches==5) {
			points=9;
		}
		if(numberOfMatches==6) {
			points=12;
		}
		return points;
	}
	public String getPath() {
		return path;
	}
}
