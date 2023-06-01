package model;

import cards.PersonalGoalCard;
import scoringTokens.TokenPoint;
/**
 * classe per la creazione dei giocatori con la propria libreria e obiettivo personale
 * @author youse
 *
 */
public class Player {

	private final int ID;
	private String name;
	private static int PLAYERCOUNTER = 0;
	//private Grid bookshelfDisplay; //da creare come classe che usa Grid
	private int points;
	private Bookshelf bookshelf;
	private PersonalGoalCard personalGoalCard;
	private boolean firstPlayerSeat=false;
	private TokenPoint scoringToken1;
	private TokenPoint scoringToken2;
	
	/**
	 * crea un giocatore con il nome inserito come parametro
	 * @param name nome del giocatore 
	 */
	public Player (String name) {
		this.name=name;
		PLAYERCOUNTER++;
		this.ID = PLAYERCOUNTER;
		this.bookshelf = new Bookshelf();
		this.personalGoalCard = PersonalGoalCard.assignPersonalGoalCard();
		this.points=0;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}

	/**
	 * stampa nome e id del giocatore 
	 */
	public void print() {
		if(this.ID!=0) {
			System.out.println("Player"+ID+": ");
			System.out.println("Name: " + this.name);
			System.out.println("ID: " + this.ID);
		}
		
	}

	public int getPoints() {
		return points;
	}
	/**
	 * somma i punti inseriti ai punti che il giocatore ha
	 * @param points punti da sommare 
	 */
	public void addPoints(int points) {
		this.points += points;
	}

	public Bookshelf getBookshelf() {
		return bookshelf;
	}

	public PersonalGoalCard getPersonalGoalCard() {
		return personalGoalCard;
	}

	public void setPersonalGoalCard(PersonalGoalCard personalGoalCard) {
		this.personalGoalCard = personalGoalCard;
	}

	public boolean isFirstPlayer() {
		return firstPlayerSeat;
	}

	public void setFirstPlayerSeat(boolean firstPlayerSeat) {
		this.firstPlayerSeat = firstPlayerSeat;
	}
	private void countPersonalGoalPoionts() {
		int points=this.getPersonalGoalCard().getPoints(this.bookshelf);
		this.addPoints(points);
	}	
	private void countAdjacentTilesPoionts() {
		int points=this.getBookshelf().adjacentTilesPoints();
		this.addPoints(points);
	}	
	/**
	 * conta i punti delle tessere adiacenti nella libreria e 
	 * i punti dell'obiettivo personale
	 */
	public void countPoints() {
		this.countPersonalGoalPoionts();
		this.countAdjacentTilesPoionts();
		if(this.getBookshelf().isComplete()) {
			this.addPoints(1);
		}
	}

	public TokenPoint getScoringToken1() {
		return scoringToken1;
	}

	public void setScoringToken1(TokenPoint scoringToken1) {
		this.scoringToken1 = scoringToken1;
	}

	public TokenPoint getScoringToken2() {
		return scoringToken2;
	}

	public void setScoringToken2(TokenPoint scoringToken2) {
		this.scoringToken2 = scoringToken2;
	}

}
