package model;

import java.util.List;
import java.util.Random;

import exception.TileAlreadySelectedException;
import exception.TileHasNotFreeSideException;
import exception.TilesAreNotAdjacentException;
import exception.TilesAreNotInlineException;
/**
 * Classe LivingRoomBoard 
 * definisce attributi e metodi per astrarre la Plancia Soggiorno del gioco MyShelfie
 * Estende la classe (abstract) Grid
 * @author Marco
 *
 */
public class LivingRoomBoard extends Grid {

	private int[][] configMatrTwoPlayer = {	{0,0,0,0,0,0,0,0,0}, 
											{0,0,0,1,1,0,0,0,0},
											{0,0,0,1,1,1,0,0,0},
											{0,0,1,1,1,1,1,1,0},
											{0,1,1,1,1,1,1,1,0},
											{0,1,1,1,1,1,1,0,0},
											{0,0,0,1,1,1,0,0,0},
											{0,0,0,0,1,1,0,0,0},
											{0,0,0,0,0,0,0,0,0}};
	
	private int[][] configMatrThreePlayer = {	{0,0,0,1,0,0,0,0,0}, 
												{0,0,0,1,1,0,0,0,0},
												{0,0,1,1,1,1,1,0,0},
												{0,0,1,1,1,1,1,1,1},
												{0,1,1,1,1,1,1,1,0},
												{1,1,1,1,1,1,1,0,0},
												{0,0,1,1,1,1,1,0,0},
												{0,0,0,0,1,1,0,0,0},
												{0,0,0,0,0,1,0,0,0}};
	
	private int[][] configMatrFourPlayer = {	{0,0,0,1,1,0,0,0,0}, 
												{0,0,0,1,1,1,0,0,0},
												{0,0,1,1,1,1,1,0,0},
												{0,1,1,1,1,1,1,1,1},
												{1,1,1,1,1,1,1,1,1},
												{1,1,1,1,1,1,1,1,0},
												{0,0,1,1,1,1,1,0,0},
												{0,0,0,1,1,1,0,0,0},
												{0,0,0,0,1,1,0,0,0}};
	
	private static final int DIM = 9;
	/**
	 * crea una nuova istanza della Plancia Soggiorno.
	 * Setta a false lo stato degli slot non utilizzabili (dipende dal numero di giocatori).
	 * @param nPlayers
	 */
	public LivingRoomBoard(int nPlayers)
	{
		super(DIM,DIM);
		init(nPlayers);
	}

	private void init(int  nPlayer)
	{
		int[][] tempConfigMatr = {};
		
		if(nPlayer == 2)
			tempConfigMatr = configMatrTwoPlayer;
		if(nPlayer == 3)
			tempConfigMatr = configMatrThreePlayer;
		if(nPlayer == 4)
			tempConfigMatr = configMatrFourPlayer;
			
		for(int x = 0; x < this.rows; x++)
		{
			for(int y = 0; y < this.columns; y++)
			{
				if(tempConfigMatr[x][y] == 0){
					matrGrid[x][y].setState(false);
				}
			}
		}
	}
	
	/**
	 * Aggiunge in ordine casuale le tessere all'interno degli slot.
	 * @param listItemTile
	 */
	public void putItemTiles(List<ItemTile> listItemTile)
	{
		Random random = new Random();
				
		for(int x = 0; x < this.rows; x++)
		{
			for(int y = 0; y < this.columns; y++)
			{				
				if(matrGrid[x][y].State() && matrGrid[x][y].isEmpty())
				{
					ItemTile itemTile = listItemTile.remove(random.nextInt(listItemTile.size()));
					matrGrid[x][y].setItemTile(itemTile);
				}

			}
		}
	}
	
	private boolean tileHasFreeSide(ItemTile currentSelectedTile)
	{
		Slot currentSlot = this.getSlotFromTile(currentSelectedTile);
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
	/**
	 * verifica se due tessere sono adiacenti
	 * @param currentSelectedTile
	 * @param lastSelectedTile
	 * @return vero se le tessere sono adiacenti
	 */
	public boolean tilesAreAdjacent(ItemTile currentSelectedTile, ItemTile lastSelectedTile)
	{
		Slot currentSelectedSlot = this.getSlotFromTile(currentSelectedTile);
		Slot lastSelectedSlot = this.getSlotFromTile(lastSelectedTile);
		
		if(currentSelectedSlot.getX() == lastSelectedSlot.getX())
		{	
			if(currentSelectedSlot.getY() - 1 == lastSelectedSlot.getY() || currentSelectedSlot.getY() + 1 == lastSelectedSlot.getY())
				return true;
		}
		if(currentSelectedSlot.getY() == lastSelectedSlot.getY())
		{	
			if(currentSelectedSlot.getX() - 1 == lastSelectedSlot.getX() || currentSelectedSlot.getX() + 1 == lastSelectedSlot.getX())
				return true;
		}
		
		return false;
	}

	private boolean tileIsInline(ItemTile currentSelectedTile, ItemTile lastSelectedTile, ItemTile firstSelectedTile)
	{
		Slot currentSelectedSlot = this.getSlotFromTile(currentSelectedTile);
		Slot lastSelectedSlot = this.getSlotFromTile(lastSelectedTile);
		Slot firstSelectedSlot = this.getSlotFromTile(firstSelectedTile);
		
		if(currentSelectedSlot.getX() == lastSelectedSlot.getX() && currentSelectedSlot.getX() == firstSelectedSlot.getX())
			return true;
		if(currentSelectedSlot.getY() == lastSelectedSlot.getY() && currentSelectedSlot.getY() == firstSelectedSlot.getY())
			return true;

		return false;
	}

	private boolean tilesAlreadySelected(ItemTile currentSelectedTile, ItemTile lastSelectedTile, ItemTile firstSelectedTile)
	{
		if(lastSelectedTile != null)
		{
			if(currentSelectedTile.getId() == lastSelectedTile.getId())
			{
				return true;
			}
		}
		if(firstSelectedTile != null)
		{
			if(currentSelectedTile.getId() == firstSelectedTile.getId())
			{
				return true;
			}
		}
		
		return false;
	}

	public ItemTile getTile(ItemTile currentSelectedTile, ItemTile lastSelectedTile,ItemTile firstSelectedTile) throws Exception
	{
		if(currentSelectedTile == null){
			throw new NullPointerException("no tile selected");
		}
		
		if(tilesAlreadySelected(currentSelectedTile,lastSelectedTile,firstSelectedTile)){
			throw new TileAlreadySelectedException("Tile already Getted");
		}
		if (!tileHasFreeSide(currentSelectedTile)){
			throw new TileHasNotFreeSideException("tile has not free side");
		}
		
		if(lastSelectedTile == null){
			return currentSelectedTile;
		}
		
		if(!tilesAreAdjacent(currentSelectedTile,lastSelectedTile)){
			if(firstSelectedTile == null)
				throw new TilesAreNotAdjacentException("tile are not adjacent");
			else
				if(!tilesAreAdjacent(currentSelectedTile,firstSelectedTile)){
					throw new TilesAreNotAdjacentException("tile are not adjacent");
				}
		}
		
		if(firstSelectedTile == null){
			return currentSelectedTile;
		}
		
		if(!tileIsInline(currentSelectedTile,lastSelectedTile,firstSelectedTile)){
			throw new TilesAreNotInlineException("tile are not inline");
		}
		
		return currentSelectedTile;
	}
	/**
	 * Rimuove le tessere dalla Plancia Soggiorno
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
