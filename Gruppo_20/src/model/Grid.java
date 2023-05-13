package model;

public abstract class Grid {
	
	protected int rows;
	protected int columns;
	protected Slot[][] matrGrid;
	

	public Slot[][] getMatrGrid() {
		return matrGrid;
	}

	public Grid(int rows, int columns) {
		
		if(rows < 0)
			throw new IllegalArgumentException("number of rows must be greater than or equal to 0");
		
		if(columns < 0)
			throw new IllegalArgumentException("number of columns must be greater than or equal to 0");
		
		this.rows=rows;
		this.columns=columns;
		this.matrGrid= new Slot[rows][columns];
		fillGridWithSlots();
	}
	
	private void fillGridWithSlots()
	{	
		for(int x = 0; x < this.rows; x++)
		{
			for(int y = 0; y < this.columns; y++)
			{
				Slot slot = new Slot();
				slot.setX(x);
				slot.setY(y);
				matrGrid[x][y] = slot;
			}
		}
	}
	
	public int getRows() {
		return this.rows;
	}
	public int getColumns() {
		return this.columns;
	}
	
	public Slot getSlot(int x,int y)
	{
		return matrGrid[x][y];
	}
	
	public Slot getSlotFromTile(ItemTile itemTile)
	{
		if(itemTile == null)
			throw new NullPointerException("itemTile is null");
		
		for(int x = 0; x < this.rows; x++)
		{	
			for(int y = 0; y < this.columns ; y++)
			{
				if(matrGrid[x][y].State() && !matrGrid[x][y].isEmpty())
				{
					if(matrGrid[x][y].getItemTile().getId() == itemTile.getId())
						return matrGrid[x][y];
				}
			}
		}
		return null;
	}
	public ItemTile contains(int tileId)
	{
		for(int x = 0; x < this.rows; x++)
		{	
			for(int y = 0; y < this.columns ; y++)
			{
				if(matrGrid[x][y].State() && !matrGrid[x][y].isEmpty())
				{
					if(matrGrid[x][y].getItemTile().getId() == tileId)
						return matrGrid[x][y].getItemTile();
				}
			}
		}
		return null;
	}
	
	public int numberOfEmptySlot(int column)
	{
		if(column < 0 || column >= this.columns) {
			throw new IndexOutOfBoundsException("This column doesn't exit");
		}
		
		int count = 0;
		for(int i =0; i < this.rows; i++)
		{
			if(matrGrid[i][column].isEmpty()) {
				count++;
			}
		}
		return count;
	}
	
	
	/*public Grid[][] createPersonalGoalCard() {
		Grid[][] personalObjectiveCard= new Grid[6][5];
		this.rows=6;
		this.columns=5;
		this.setSlots();
		return personalObjectiveCard;		
	}*/
	
	/*public void setSlots() {
		int number =1;
		for(int row=0;row<rows;row++) {
			for(int column=0;column<columns;column++) {
				//this.slots[row][column]=new Slot(number,row,column);
			//	this.slots[row][column].setId(0);
				number++;
			}
		}
	}

/*	public void printGridNumber() {
		for(int i =1;i<=this.rows;i++) {
			System.out.println("");
			for(int j =1;j<=this.columns;j++) {
				System.out.print(this.getSlot(i,j).getNumber()+"\t");
			}
		}
	}*/
	
	public void printGrid() {
		for(int x = 0; x < this.rows; x++)
		{
			System.out.println("\n");
			System.out.println("------------------------------------------------------------------------");
			
			for(int y = 0; y < this.columns ; y++)
			{
				if(matrGrid[x][y].State())
				{
					System.out.print( "  ("+ x + "," + y + ")" ) ;
					//System.out.print( " " + matrGrid[x][y].getItemTile().getPathImg() + 
							//" lb" + matrGrid[x][y].getItemTile().getId()) ;
				}
				else
					System.out.print(" - ");
		
			}
		}
		System.out.println("\n");
	}

}
