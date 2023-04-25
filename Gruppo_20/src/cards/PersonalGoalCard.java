package cards;

import java.util.ArrayList;

import progetto.Grid;

public abstract class PersonalGoalCard extends Grid{
	private int points;
	private boolean match1;
	private boolean match2;
	private boolean match3;
	private boolean match4;
	private boolean match5;
	private boolean match6;
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
		super(6, 5);
	}
	public String getColor(int row, int column) {
		return "";
		//return this.getItemTile(row, column).getColor();
	}
	public boolean isColorMatching(int row, int column, String color) {
		if(this.getColor(row, column)==color) {
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
		/*if(match1) {
			counter++;
		}
		if(match2) {
			counter++;
		}
		if(match3) {
			counter++;
		}
		if(match4) {
			counter++;
		}
		if(match5) {
			counter++;
		}
		if(match6) {
			counter++;
		}*/
		return counter;
	}
	
	
	public int getPoints() {
		return points;
	}
	
	
}