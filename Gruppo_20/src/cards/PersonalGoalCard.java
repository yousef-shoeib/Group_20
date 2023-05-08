package cards;

import java.util.ArrayList;
import java.util.Random;

import model.Bookshelf;

public abstract class PersonalGoalCard {
	private int points;
	private boolean match1;
	private boolean match2;
	private boolean match3;
	private boolean match4;
	private boolean match5;
	private boolean match6;
	private String path;
	private Bookshelf bookshelf;
	private ArrayList<Boolean> matches= new ArrayList<Boolean>();
	public void fillMatches() {
		matches.add(match1);
		matches.add(match2);
		matches.add(match3);
		matches.add(match4);
		matches.add(match5);
		matches.add(match6);
	}
	public PersonalGoalCard(Bookshelf b) {
		this.bookshelf=b;
	}
	
	public String getColor(int row, int column) {
		return "";
		//return this.getItemTile(row, column).getColor();
	}
	public boolean isColorMatching(int row, int column, String color) {// cambiare in bookshelf.getTile(row, column).getColor()
		if(this.bookshelf.getTile(row, column).getColor()==color) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int countMatches() {
		this.fillMatches();
		int counter=0;
		for(boolean match: matches) {
			if(match) {
				counter++;
			}
		}
		return counter;
	}
	
	public void setPoints() {
		int matches=this.countMatches();
		if(matches==1||matches==2) {
			this.points=matches;
		}
		if(matches==3) {
			this.points=4;
		}
		if(matches==4) {
			this.points=6;
		}
		if(matches==5) {
			this.points=9;
		}
		if(matches==6) {
			this.points=12;
		}
	}
	public int getPoints() {
		return points;
	}

	public String getPath() {
		return path;
	}


	public Bookshelf getBookshelf() {
		return bookshelf;
	}

	public static PersonalGoalCard assignPersonalGoalCard(Bookshelf b) {
		Random r = new Random();
		int n=r.nextInt(12)+1;
		PersonalGoalCard card = null;
		switch(n) {
		case 1:
			card=new PersonalGoalCard1(b);
			break;
		case 2:
			card=new PersonalGoalCard2(b);
			break;
		case 3:
			card=new PersonalGoalCard3(b);
			break;
		case 4:
			card=new PersonalGoalCard4(b);
			break;
		case 5:
			card=new PersonalGoalCard5(b);
			break;
		case 6:
			card=new PersonalGoalCard6(b);
			break;
		case 7:
			card=new PersonalGoalCard7(b);
			break;
		case 8:
			card=new PersonalGoalCard8(b);
			break;
		case 9:
			card=new PersonalGoalCard9(b);
			break;
		case 10:
			card=new PersonalGoalCard10(b);
			break;
		case 11:
			card=new PersonalGoalCard11(b);
			break;
		case 12:
			card=new PersonalGoalCard12(b);
			break;
			
		}
		return card;
	}
	public void setBookshelf(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}

	
	
	
}