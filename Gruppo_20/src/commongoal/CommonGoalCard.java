package commongoal;

import java.awt.print.Book;
import java.util.Random;
import java.util.ArrayList;
import model.Bookshelf;

public abstract class CommonGoalCard {
	static int count=0;
	
	public CommonGoalCard() { }
	
	abstract boolean CheckTarget();
	
	public static CommonGoalCard assignCommonGoalCard(Bookshelf b) {
		Random random = new Random();
		int num = random.nextInt(12)+1;
		CommonGoalCard card = null;
		switch(num) {
			case 1:
				card = new CommonGoalCard1(b);
				break;
			case 2:
				card = new CommonGoalCard2(b);
				break;
			case 3:
				card = new CommonGoalCard3(b);
				break;
			case 4:
				card = new CommonGoalCard4(b);
				break;
			case 5:
				card = new CommonGoalCard5(b);
				break;
			case 6:
				card = new CommonGoalCard6(b);
				break;
			case 7:
				card = new CommonGoalCard7(b);
				break;
			case 8:
				card = new CommonGoalCard8(b);
				break;
			case 9:
				card = new CommonGoalCard9(b);
				break;
			case 10:
				card = new CommonGoalCard10(b);
				break;
			case 11:
				card = new CommonGoalCard11(b);
				break;
			case 12:
				card = new CommonGoalCard12(b);
				break;
			}
		return card;
	}
	
	/*
	public int Counter(Bookshelf b) {
		if(CheckTarget()) count++;
		return count;
	}
	*/
	
	public int ReturnPoints(int count, int giocatori) {
		int points=0;
		switch(giocatori) {
			case 2:
				switch(count) {
					case 1:
						points = 8;
						break;
					case 2:
						points = 4;
						break;
				}
			case 3:
				switch(count) {
					case 1:
						points = 8;
						break;
					case 2:
						points = 6;
						break;
					case 3:
						points = 4;
						break;
				}
			case 4:
				switch(count) {
					case 1:
						points = 8;
						break;
					case 2:
						points = 6;
						break;
					case 3:
						points = 4;
						break;
					case 4:
						points = 2;
						break;
				}
		}
	
		return points;
	}	
	
}
