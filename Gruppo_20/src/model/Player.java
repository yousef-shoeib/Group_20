package model;

import cards.PersonalGoalCard;

public class Player {

	private final int ID;
	private String name;
	private static int PLAYERCOUNTER = 0;
	//private Grid bookshelfDisplay; //da creare come classe che usa Grid
	private int points;
	private Bookshelf bookshelf;
	private PersonalGoalCard personalGoalCard;
	private boolean firstPlayerSeat=false;
    /*private int IDGenerator() 
    {
        return PLAYERCOUNTER++;
        
    }*/
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

	
	public void print() {
		if(this.ID!=0) {
			System.out.println("Player"+ID+": ");
			System.out.println("Name: " + this.name);
			System.out.println("ID: " + this.ID);
		}
		
	}
	
	/*public Grid getBookshelf() {
		return bookshelfDisplay;
	}
	public Slot getBookshelfSlot(int row, int column) {
		Slot slot=this.getBookshelf().getSlot(row, column);
		return slot;
	}

	public void setBookshelf(Grid bookshelf) {
		this.bookshelfDisplay= bookshelf;
	}*/

	public int getPoints() {
		return points;
	}

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
	
	public void countPoints() {
		this.countPersonalGoalPoionts();
		this.countAdjacentTilesPoionts();
		if(this.getBookshelf().isComplete()) {
			this.addPoints(1);
		}
	}

}
