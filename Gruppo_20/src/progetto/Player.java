package progetto;

public class Player {

	private int ID;
	private String name;
	private static int playerCounter = 0;

    

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
		this.ID = IDGenerator();
	}
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}

	
	public void stampa() {
		if(this.ID!=0) {
			System.out.println("Player"+ID+": ");
			System.out.println("Name: " + this.name);
			System.out.println("ID: " + this.ID);
		}
		
	}
	

}
