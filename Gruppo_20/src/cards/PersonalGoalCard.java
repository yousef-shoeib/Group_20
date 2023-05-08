package cards;

import java.util.ArrayList;
import java.util.Random;

import cards.Match;
import model.Bookshelf;

public abstract class PersonalGoalCard {
	private int points;
	private Match match1;
	private Match match2;
	private Match match3;
	private Match match4;
	private Match match5;
	private Match match6;
	private String path;
	private ArrayList<Match> matches=null;
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
	
	public PersonalGoalCard() {
		
	}
	
	public String getType(int row, int column) {
		return "";
		//return this.getItemTile(row, column).getColor();
	}
	public boolean isColorMatching(Bookshelf bookshelf, Match m) {// cambiare in bookshelf.getTile(row, column).getColor()
		if(bookshelf.getSlot(m.getRow(), m.getColumn()).isEmpty()) {
			return false;
		}
		if(bookshelf.getTile(m.getRow(), m.getColumn()).getType()==m.getType()) {
			return true;
		}
		else {
			return false;
		}
	}
	/////////////////////
	public int countMatches(Bookshelf b) {
		this.fillMatches();
		int counter=0;
		for(Match match: matches) {
			if(isColorMatching(b, match)) {
				counter++;
			}
		}
		return counter;
	}
	
	public int getPoints(int numberOfMatches) {
		//this.countMatches();
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


	

	public static PersonalGoalCard assignPersonalGoalCard(Bookshelf b) {
		Random r = new Random();
		int n=r.nextInt(12)+1;
		PersonalGoalCard card = null;
		switch(n) {
		case 1:
			card=new PersonalGoalCard1();
			break;
		case 2:
			card=new PersonalGoalCard2();
			break;
		case 3:
			card=new PersonalGoalCard3();
			break;
		case 4:
			card=new PersonalGoalCard4();
			break;
		case 5:
			card=new PersonalGoalCard5();
			break;
		case 6:
			card=new PersonalGoalCard6();
			break;
		case 7:
			card=new PersonalGoalCard7();
			break;
		case 8:
			card=new PersonalGoalCard8();
			break;
		case 9:
			card=new PersonalGoalCard9();
			break;
		case 10:
			card=new PersonalGoalCard10();
			break;
		case 11:
			card=new PersonalGoalCard11();
			break;
		case 12:
			card=new PersonalGoalCard12();
			break;
			
		}
		return card;
	}
	

	
	
	
}