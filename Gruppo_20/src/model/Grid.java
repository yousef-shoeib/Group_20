package model;

import java.util.List;

/**
 * Classe Grid
 * Definisce metodi e attributi per la classe astratta Grid
 * @author Marco
 *
 */
public abstract class Grid {
	
	protected final int rows;
	protected final int columns;
	protected final Slot[][] matrGrid;
	
	/**
	 * Crea una Griglia con righe e colonne specificate
	 * @param rows
	 * @param columns
	 */
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
				Slot slot = new Slot(x,y);
				matrGrid[x][y] = slot;
			}
		}
	}
	/**
	 * Restituisce il numero delle righe della Griglia
	 */
	public int getRows() {
		return this.rows;
	}
	/**
	 * Restituisce il numero delle colonne della Griglia
	 */
	public int getColumns() {
		return this.columns;
	}
	/**
	 * Restituisce la matrice di Slot della Griglia
	 */
	public Slot[][] getMatrGrid() {
		return matrGrid;
	}
	/**
	 * Restituisce lo slot avente le coordinate fornite come parametri
	 * @param x
	 * @param y
	 */
	public Slot getSlot(int x,int y)
	{
		return matrGrid[x][y];
	}
	/**
	 * Restituisce lo slot in cui si trova una specifica tessera
	 * @param itemTile
	 * @return null se la tessera non si trova nella Griglia
	 */
	public Slot getSlot(ItemTile itemTile)
	{
		if(itemTile == null)
			throw new NullPointerException("itemTile is null");
		
		for(int x = 0; x < this.rows; x++)
		{	
			for(int y = 0; y < this.columns ; y++)
			{
				if(matrGrid[x][y].getState() && !matrGrid[x][y].isEmpty())
				{
					if(matrGrid[x][y].getItemTile().getId() == itemTile.getId())
						return matrGrid[x][y];
				}
			}
		}
		return null;
	}
	/**
	 * Restituisce 
	 */
	public ItemTile contains(int tileId)
	{
		for(int x = 0; x < this.rows; x++)
		{	
			for(int y = 0; y < this.columns ; y++)
			{
				if(matrGrid[x][y].getState() && !matrGrid[x][y].isEmpty())
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
		
		Slot currentSlot = this.getSlot(currentItem);
		int x = currentSlot.getX();
		int y = currentSlot.getY();
		
		if(x > 0) {
			if(this.matrGrid[(x-1)][y].getState() && !this.matrGrid[(x-1)][y].isEmpty()) {
				return true;
			}
		}
		if(x < (this.rows-1)) {
			if(this.matrGrid[(x+1)][y].getState() && !this.matrGrid[(x+1)][y].isEmpty()) {
				return true;
			}
		}
		if(y > 0) {
			if(this.matrGrid[x][(y-1)].getState() && !this.matrGrid[x][(y-1)].isEmpty()) {
				return true;
			}
		}
		if(y < (this.columns-1)) {
			if(this.matrGrid[x][(y+1)].getState() && !this.matrGrid[x][(y+1)].isEmpty()) {
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
				if(matrGrid[row][column].getState() && !matrGrid[row][column].isEmpty())
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
		Slot slot1 = this.getSlot(tile1);
		Slot slot2 = this.getSlot(tile2);
		
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
		Slot slot1 = this.getSlot(tile1);
		Slot slot2 = this.getSlot(tile2);
		Slot slot3 = this.getSlot(tile2);
		
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
		Slot currentSlot = this.getSlot(tileToCheck);
		
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
		
		if(!slot1.getState() || slot1.isEmpty())
			return true;
		if(!slot2.getState() || slot2.isEmpty())
			return true;
		if(!slot3.getState() || slot3.isEmpty())
			return true;
		if(!slot4.getState() || slot4.isEmpty())
			return true;
		
		return false;
	}
	protected boolean tileIsInline(ItemTile tile1, ItemTile tile2, ItemTile tile3)
	{
		Slot slot1 = this.getSlot(tile1);
		Slot slot2 = this.getSlot(tile2);
		Slot slot3 = this.getSlot(tile3);
		
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
				if(matrGrid[x][y].getState() && !matrGrid[x][y].isEmpty())
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
