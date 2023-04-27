package progetto;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LeavingRoomBoard extends Grid {

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
	
	public LeavingRoomBoard(int nPlayers)
	{
		super(DIM,DIM);
		init(nPlayers);
	}

	/**
	 * Init the grid based on the number of players
	 * @param nPlayer
	 */
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
				Slot slot = new Slot();
				if(tempConfigMatr[x][y] == 1)
					slot.setStato(true);
				
				matrGrid[x][y] = slot;
			}
		}
	}
	
	/**
	 * Randomly assign tiles to the grid
	 * @param listItemTile
	 * @param boardItemTile
	 * @return matriGrid
	 */
	public void putItemTiles(List<ItemTile> listItemTile, HashMap<String, ItemTile> boardItemTile)
	{
		Random random = new Random();
				
		for(int x = 0; x < this.rows; x++)
		{
			for(int y = 0; y < this.columns; y++)
			{
				matrGrid[x][y].setX(x);
				matrGrid[x][y].setY(y);
				
				if(matrGrid[x][y].State())
				{
					ItemTile itemTile = listItemTile.remove(random.nextInt(listItemTile.size()));
					itemTile.setX(x);
					itemTile.setY(y);
					matrGrid[x][y].setItemTile(itemTile);
					boardItemTile.put("lb"+itemTile.getId(), itemTile); 
				}

			}
		}
	}
	
	//Check has free side
	private boolean tileHasFreeSide(ItemTile currentItemTile)
	{			
		int x = currentItemTile.getX();
		int y = currentItemTile.getY();
		
		if(x == 0 || y == 0 || x == 8 || y == 8)
			return true;
		
		Slot slot1 = matrGrid[(x-1)][y];
		Slot slot2 = matrGrid[x][(y-1)];
		Slot slot3 = matrGrid[(x+1)][y];
		Slot slot4 = matrGrid[x][(y+1)];
		
		if(!slot1.State() || slot1.getItemTile() == null)
			return true;
		if(!slot2.State() || slot2.getItemTile() == null)
			return true;
		if(!slot3.State() || slot3.getItemTile() == null)
			return true;
		if(!slot4.State() || slot4.getItemTile() == null)
			return true;
		
		return false;
	}
	
	private boolean tileAreAdjacent(ItemTile currentItemTile, ItemTile gettedItemTile)
	{
		Slot currentSlot = matrGrid[currentItemTile.getX()][currentItemTile.getY()];
		Slot gettedSlot = matrGrid[gettedItemTile.getX()][gettedItemTile.getY()];
		
		//Check its adjacent
		if(currentItemTile.getX() == gettedItemTile.getX())
		{	
			if(currentSlot.getY() - 1 == gettedSlot.getY() || currentSlot.getY() + 1 == gettedSlot.getY())
				return true;
		}
		if(currentSlot.getY() == gettedSlot.getY())
		{	
			if(currentSlot.getX() - 1 == gettedSlot.getX() || currentSlot.getX() + 1 == gettedSlot.getX())
				return true;
		}
		
		return false;
	}
	
	public ItemTile getTile(ItemTile currentItemTile, ItemTile gettedItemTile)
	{
		if(currentItemTile == null)
			throw new NullPointerException("no tile selected");
		
		if (!tileHasFreeSide(currentItemTile))
			return null;
		
		if(gettedItemTile == null)
		{
			this.matrGrid[currentItemTile.getX()][currentItemTile.getY()].setItemTile(null);
			return currentItemTile;
		}
		
		if(tileAreAdjacent(currentItemTile,gettedItemTile))
		{
			this.matrGrid[currentItemTile.getX()][currentItemTile.getY()].setItemTile(null);
			return currentItemTile;
		}
		
		return null;
	}
	
	
}
