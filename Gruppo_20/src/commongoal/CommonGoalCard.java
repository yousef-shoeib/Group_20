package commongoal;

import java.awt.print.Book;
import java.util.Random;
import java.util.ArrayList;
import model.Bookshelf;

public abstract class CommonGoalCard {
	static int count=0; //variable that counts the number of times a goal has been achieved
	
	public CommonGoalCard() {}
	
	abstract public boolean CheckTarget(Bookshelf bookshelf);
	
	public static CommonGoalCard assignCommonGoalCard() {
		Random random = new Random();
		int num = random.nextInt(12)+1;
		CommonGoalCard card = null;
		switch(num) {
			case 1:
				card = new CommonGoalCard1();
				break;
			case 2:
				card = new CommonGoalCard2();
				break;
			case 3:
				card = new CommonGoalCard3();
				break;
			case 4:
				card = new CommonGoalCard4();
				break;
			case 5:
				card = new CommonGoalCard5();
				break;
			case 6:
				card = new CommonGoalCard6();
				break;
			case 7:
				card = new CommonGoalCard7();
				break;
			case 8:
				card = new CommonGoalCard8();
				break;
			case 9:
				card = new CommonGoalCard9();
				break;
			case 10:
				card = new CommonGoalCard10();
				break;
			case 11:
				card = new CommonGoalCard11();
				break;
			case 12:
				card = new CommonGoalCard12();
				break;
			}
		return card;
	}
	
	
	public int Counter(Bookshelf b) {
		if(CheckTarget(b)) {
			count++;
		}
		return count;
	}
	
	
	
	public int ReturnPoints(int players) {
		int points=0;
		switch(players) {
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
