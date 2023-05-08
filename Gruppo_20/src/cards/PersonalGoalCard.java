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
	
	public PersonalGoalCard() {
		
	}
	
	public String getColor(int row, int column) {
		return "";
		//return this.getItemTile(row, column).getColor();
	}
	public boolean isColorMatching(int row, int column, String color,Bookshelf bookshelf) {// cambiare in bookshelf.getTile(row, column).getColor()
		if(bookshelf.getSlot(row, column).isEmpty()) {
			return false;
		}
		if(bookshelf.getTile(row, column).getColor()==color) {
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

	public static PersonalGoalCard assignPersonalGoalCard() {
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