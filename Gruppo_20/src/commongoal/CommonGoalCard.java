package commongoal;

import java.awt.print.Book;
import java.util.Random;
import java.util.ArrayList;
import model.Bookshelf;

public abstract class CommonGoalCard {
	private boolean flag;
	
	public CommonGoalCard() { 
	}
	
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
			//case 5:
				//card = new CommonGoalCard5();
				//break;
			case 6:
				card = new CommonGoalCard6(b);
				break;
			//case 7:
				//card = new CommonGoalCard7(b);
				//break;
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
			//case 12:
				//card = new CommonGoalCard12();
				//break;
			}
		return card;
	}
	
	
}
