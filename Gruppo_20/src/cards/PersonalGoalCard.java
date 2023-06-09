package cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cards.Match;
import model.Bookshelf;
/**
 * classe astratta per creazione delle 12 carte obiettivo personale
 * @author youse
 *
 */
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
	/**
	 * metodo per mettere i match in una lista
	 * @return lista di 6 match
	 */
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
	/**
	 * metodo per controlloare se la tessere nella liberia è uguale a quella 
	 * del personal goal
	 * @param bookshelf del giocatore 
	 * @param m passato dalla lista di match del personal goal
	 * @return true se il tipo è lo stesso
	 */
	protected boolean isColorMatching(Bookshelf bookshelf, Match m) {
		if(!bookshelf.getSlot(m.getRow(), m.getColumn()).isEmpty() && 
				bookshelf.getTile(m.getRow(), m.getColumn()).getType().equals(m.getType())) {
			return true;
		}
		
		else {
			return false;
		}
	}
	/**
	 * conta quanti dei 6 match sono completati
	 * @param b libreria del giocatore
	 * @return numero degli obiettivi fatti
	 */
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
	/**
	 * metodo per ritornare i punti in base a quante celle hanno lo stesso tipo 
	 * dettato della carta obiettivo personale
	 * @param b libreria del giocatore 
	 * @return i punti dell'obiettivo personale
	 */
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
		return this.path;
	}


	
	/**
	 * metodo per assegnare una carta obiettivo personale casuale
	 * @return carta obiettivo personale
	 */
	public static PersonalGoalCard assignPersonalGoalCard() {
		PersonalGoalCard card = null;
		Random r = new Random();
		int n=0;
		
		do{
		 n=r.nextInt(12)+1;		 
		}while(assignedCards.contains(n));
		
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
	/**
	 * metodo per resettare i personal goal assegnati 
	 * nella partita precedente
	 */
	public static void resetAssignedPersonalGoalCards() {
		assignedCards=new ArrayList<>();
	}
	
	

	
	
	
}