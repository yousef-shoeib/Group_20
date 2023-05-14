package model;

public abstract class Grid {
	
	protected int rows;
	protected int columns;
	protected Slot[][] matrGrid;
	

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
	public Slot[][] getMatrGrid() {
		return matrGrid;
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
	/**
	 * Check if the currentItem has adjacentTile
	 * @param currentItem
	 * @return true if currentItem has an adjacent tile
	 */
	public boolean hasAdjacentTile(ItemTile currentItem)
	{
		if(currentItem ==  null)
			throw new NullPointerException("itemTile is null");
		
		Slot currentSlot = this.getSlotFromTile(currentItem);
		int x = currentSlot.getX();
		int y = currentSlot.getY();
		
		if(x > 0) {
			if(this.matrGrid[(x-1)][y].State() && !this.matrGrid[(x-1)][y].isEmpty()) {
				return true;
			}
		}
		if(x < (this.rows-1)) {
			if(this.matrGrid[(x+1)][y].State() && !this.matrGrid[(x+1)][y].isEmpty()) {
				return true;
			}
		}
		if(y > 0) {
			if(this.matrGrid[x][(y-1)].State() && !this.matrGrid[x][(y-1)].isEmpty()) {
				return true;
			}
		}
		if(y < (this.columns-1)) {
			if(this.matrGrid[x][(y+1)].State() && !this.matrGrid[x][(y+1)].isEmpty()) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Check if there are any adjacent tiles
	 * @returns true if there are two adjacent tiles
	 */
	public boolean hasAdjacentTiles()
	{
		for(int row = 0; row < this.rows; row ++)
		{
			for(int column = 0; column < this.columns; column ++)
			{
				if(matrGrid[row][column].State() && !matrGrid[row][column].isEmpty())
				{
					 if(hasAdjacentTile(matrGrid[row][column].getItemTile())){
						 return true;
					 }
				}
			}
		}
		return false;
	}
}
