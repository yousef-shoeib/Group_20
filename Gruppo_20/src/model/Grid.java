package model;

import java.util.List;

/**
 * Classe Grid
 * Definisce metodi e attributi per la classe astratta Grid
 * @author Marco
 *
 */
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
	/**
	 * verifica se due tessere sono adiacenti
	 * @param tile1
	 * @param tile2
	 * @return vero se le tessere sono adiacenti
	 */
	public boolean tilesAreAdjacent(ItemTile tile1, ItemTile tile2)
	{
		Slot slot1 = this.getSlotFromTile(tile1);
		Slot slot2 = this.getSlotFromTile(tile2);
		
		if(slot1 == null)
			throw new NullPointerException("Grid does not contain itemTile1");
		if(slot2 == null)
			throw new NullPointerException("Grid does not contain itemTile2");
		
		if(slot1.getX() == slot2.getX())
		{	
			if(slot1.getY() - 1 == slot2.getY() || slot1.getY() + 1 == slot2.getY())
				return true;
		}
		if(slot1.getY() == slot2.getY())
		{	
			if(slot1.getX() - 1 == slot2.getX() || slot1.getX() + 1 == slot2.getX())
				return true;
		}
		
		return false;
	}
	public boolean tilesAreAdjacent(ItemTile tile1, ItemTile tile2,ItemTile tile3)
	{
		Slot slot1 = this.getSlotFromTile(tile1);
		Slot slot2 = this.getSlotFromTile(tile2);
		Slot slot3 = this.getSlotFromTile(tile2);
		
		if(slot1 == null)
			throw new NullPointerException("Grid does not contain itemTile1");
		if(slot2 == null)
			throw new NullPointerException("Grid does not contain itemTile2");
		if(slot3 == null)
			throw new NullPointerException("Grid does not contain itemTile3");
		
		if(!tilesAreAdjacent(tile1,tile2) && !tilesAreAdjacent(tile1,tile3))
			return false;
		if(!tilesAreAdjacent(tile2,tile1) && !tilesAreAdjacent(tile2,tile3))
			return false;
		if(!tilesAreAdjacent(tile3,tile1) && !tilesAreAdjacent(tile3,tile2))
			return false;
		
		return true;
	}
	protected boolean tileHasFreeSide(ItemTile tileToCheck)
	{
		Slot currentSlot = this.getSlotFromTile(tileToCheck);
		
		if(currentSlot == null)
			throw new NullPointerException("Grid does not contain itemTile");
		
		int x = currentSlot.getX();
		int y = currentSlot.getY();
		
		if(x == 0 || y == 0 || x == 8 || y == 8)
			return true;
		
		Slot slot1 = matrGrid[(x-1)][y];
		Slot slot2 = matrGrid[x][(y-1)];
		Slot slot3 = matrGrid[(x+1)][y];
		Slot slot4 = matrGrid[x][(y+1)];
		
		if(!slot1.State() || slot1.isEmpty())
			return true;
		if(!slot2.State() || slot2.isEmpty())
			return true;
		if(!slot3.State() || slot3.isEmpty())
			return true;
		if(!slot4.State() || slot4.isEmpty())
			return true;
		
		return false;
	}
	protected boolean tileIsInline(ItemTile tile1, ItemTile tile2, ItemTile tile3)
	{
		Slot slot1 = this.getSlotFromTile(tile1);
		Slot slot2 = this.getSlotFromTile(tile2);
		Slot slot3 = this.getSlotFromTile(tile3);
		
		if(slot1 == null)
			throw new NullPointerException("Grid does not contain itemTile1");
		if(slot2 == null)
			throw new NullPointerException("Grid does not contain itemTile2");
		if(slot3 == null)
			throw new NullPointerException("Grid does not contain itemTile3");

		
		if(slot1.getX() == slot2.getX() && slot1.getX() == slot3.getX())
			return true;
		if(slot1.getY() == slot2.getY() && slot1.getY() == slot3.getY())
			return true;

		return false;
	}
	/**
	 * Rimuove le tessere dalla Griglia
	 * @param selectedTiles
	 */
	public void removeTile(List<ItemTile> selectedTiles) {
		for(ItemTile item : selectedTiles)
		{
			this.removeTile(item);
		}
	}
	private int removeTile(ItemTile item) {
		
		for(int x = 0; x < this.rows; x++)
		{	
			for(int y = 0; y < this.columns ; y++)
			{
				if(matrGrid[x][y].State() && !matrGrid[x][y].isEmpty())
				{
					if(matrGrid[x][y].getItemTile().getId() == item.getId())
					{
						matrGrid[x][y].setItemTile(null);;
						return 1;
					}
					
				}
			}
		}
		return -1;
	}
}
