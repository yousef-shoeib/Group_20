package commongoal;

import java.awt.print.Book;
import java.util.Random;
import java.util.ArrayList;
import model.Bookshelf;

public abstract class CommonGoalCard {
	private boolean flag;
	
	public CommonGoalCard() { 
	}
	
	abstract boolean CheckTarget(Bookshelf b);
	
	
	/*
	public static CommonGoalCard assignCommonGoalCard(Bookshelf b) {
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
	*/
	
}
