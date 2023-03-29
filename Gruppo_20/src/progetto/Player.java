package progetto;

public class Player {

	private int ID;
	private String name;
	private static int playerCounter = 0;
	//private Grid bookshelfDisplay; //da creare come classe che usa Grid
	private int points;
	

    private int IDGenerator() 
    {
        playerCounter++;
        ID = playerCounter;
        return ID;
    }

    public Player () {
	}
	
	public Player (String name) {
		this.name=name;
		//playerCounter++;
		//this.ID = playerCounter;
		//this.bookshelfDisplay = new Grid(6,5);
		this.ID = IDGenerator();
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
/*
	public Grid getBookshelf() {
		return bookshelfDisplay;
	}
	public Slot getBookshelfSlot(int row, int column) {
		Slot slot=this.getBookshelf().getSlot(row, column);
		return slot;
	}

	public void setBookshelf(Grid bookshelf) {
		this.bookshelfDisplay= bookshelf;
	}
*/
	public int getPoints() {
		return points;
	}

	public void addPoints(int points) {
		this.points += points;
	}

	
	

}
