package commongoal;

import java.awt.print.Book;
import java.util.Random;
import java.util.ArrayList;
import model.Bookshelf;

/**
 * classe astratta per la creazione delle 12 carte degli obiettivi comuni
 * @author Anton
 *
 */

public abstract class CommonGoalCard {
	static int count=1; //variable that counts the number of times a goal has been achieved
	private String path;
	private static int assignedCard=0;
	
	public CommonGoalCard() {}
	
	abstract public boolean CheckTarget(Bookshelf bookshelf);
	
	/**
	 * metodo per assegnare in modo random un carta delle 12 carte degli obiettivi comuni
	 * @return carta obiettivo comune
	 */
	public static CommonGoalCard assignCommonGoalCard() {
		CommonGoalCard card = null;
		Random random = new Random();
		int num;
		
		
		do {
			num = random.nextInt(12)+1;
		}while(assignedCard == num);
		assignedCard = num;
		
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
	
	/**
	 * metodo per calcolare i punti in base al numero di volte che un obiettivo comune è stato raggiunto
	 * @param b libreria di un giocatore
	 * @return conteggio del numero di volte che un obiettivo comune è stato raggiunto
	 */
	public int Counter(Bookshelf b) {
		if(CheckTarget(b)) {
			count++;
		}
		return count;
	}
	
	/**
	 * metodo per ritornare i punti in base al numero di giocatori
	 * @param players numero di giocatori
	 * @return punti da assegnare
	 */
	
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
		count++;
		return points;
	}	
	
	
	public String getPath() {
		return path;
	}
	
	public static void resetAssignedCommonGoalCards() {
		assignedCard=0;
	}
}
