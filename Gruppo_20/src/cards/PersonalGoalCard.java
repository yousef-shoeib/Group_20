package cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cards.Match;
import model.Bookshelf;

public abstract class PersonalGoalCard {
	private int points;
	private int number;
	private Match match1;
	private Match match2;
	private Match match3;
	private Match match4;
	private Match match5;
	private Match match6;
	private String path;
	private static List<Integer> assignedCards=new ArrayList<>();
	private ArrayList<Match> matches=null;
	protected ArrayList<Match> fillMatches() {
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
	public int getCardNumber() {
		return this.number;
	}
	
	protected boolean isColorMatching(Bookshelf bookshelf, Match m) {
		if(!bookshelf.getSlot(m.getRow(), m.getColumn()).isEmpty() && 
				bookshelf.getTile(m.getRow(), m.getColumn()).getType().equals(m.getType())) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	private int countMatches(Bookshelf b) {
		this.fillMatches();
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


	

	public static PersonalGoalCard assignPersonalGoalCard() {
		PersonalGoalCard card = null;
		Random r = new Random();
		int n=r.nextInt(12)+1;
		for(int i :assignedCards) {
		if(n==i){
		 n=r.nextInt(12)+1;		 
		}
		}
		assignedCards.add(n);
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