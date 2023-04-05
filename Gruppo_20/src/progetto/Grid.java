package progetto;


public class Grid {
	private int rows;
	private int columns;
	private Slot[][] slots;
	
	public Grid() {

	}
	
	/*public Grid(int rows, int columns) {
		this.rows=rows;
		this.columns=columns;
		this.slots= new Slot[rows][columns];
		this.setSlots();
	}
	
	public Grid(int rows, int columns, int numberOfPlayers) {
		this.rows=rows;
		this.columns=columns;
		this.slots= new Slot[rows][columns];
		this.setSlots();
	}*/
	
	/*public Grid[][] createPersonalGoalCard() {
		Grid[][] personalObjectiveCard= new Grid[6][5];
		this.rows=6;
		this.columns=5;
		this.setSlots();
		return personalObjectiveCard;		
	}*/
	
	public void setSlots() {
		int number =1;
		for(int row=0;row<rows;row++) {
			for(int column=0;column<columns;column++) {
				//this.slots[row][column]=new Slot(number,row,column);
			//	this.slots[row][column].setId(0);
				number++;
			}
		}
	}
	public Slot getSlot(int row, int column) {
		return slots[row-1][column-1];
	}
	public Slot[][] getSlots(){
		return this.slots;
	}
/*	public void printGridNumber() {
		for(int i =1;i<=this.rows;i++) {
			System.out.println("");
			for(int j =1;j<=this.columns;j++) {
				System.out.print(this.getSlot(i,j).getNumber()+"\t");
			}
		}
	}*/
	
/*	public void printGridId() {
		for(int i =1;i<=this.rows;i++) {
			System.out.println("");
			for(int j =1;j<=this.columns;j++) {
				if(this.getSlot(i,j).getId()==0) {
					System.out.print(" \t");
				}else {
					System.out.print(this.getSlot(i,j).getId()+"\t");
				}
			}System.out.println("");
		}
	}*/
	
	/*public void setSlot() {
		this.slot = new Slot();
	}*/
	public int getRows() {
		return this.rows;
	}
	public int getColumns() {
		return this.columns;
	}
}
