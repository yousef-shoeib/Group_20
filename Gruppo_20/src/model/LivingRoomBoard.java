package model;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import exception.EqualsTilesException;
import exception.AlreadySelectedTileException;
import exception.NoFreeSideTileException;
import exception.NoAdjacentTilesException;
import exception.NotInlineTilesException;
/**
 * Classe LivingRoomBoard 
 * definisce attributi e metodi per astrarre la Plancia Soggiorno del gioco MyShelfie
 * Estende la classe (abstract) Grid
 * @author Marco
 *
 */
public class LivingRoomBoard extends Grid {

	private final int[][] configMatrTwoPlayer = {	{0,0,0,0,0,0,0,0,0}, 
											{0,0,0,1,1,0,0,0,0},
											{0,0,0,1,1,1,0,0,0},
											{0,0,1,1,1,1,1,1,0},
											{0,1,1,1,1,1,1,1,0},
											{0,1,1,1,1,1,1,0,0},
											{0,0,0,1,1,1,0,0,0},
											{0,0,0,0,1,1,0,0,0},
											{0,0,0,0,0,0,0,0,0}};
	
	private final int[][] configMatrThreePlayer = {	{0,0,0,1,0,0,0,0,0}, 
												{0,0,0,1,1,0,0,0,0},
												{0,0,1,1,1,1,1,0,0},
												{0,0,1,1,1,1,1,1,1},
												{0,1,1,1,1,1,1,1,0},
												{1,1,1,1,1,1,1,0,0},
												{0,0,1,1,1,1,1,0,0},
												{0,0,0,0,1,1,0,0,0},
												{0,0,0,0,0,1,0,0,0}};
	
	private final int[][] configMatrFourPlayer = {	{0,0,0,1,1,0,0,0,0}, 
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
					matrGrid[x][y].setState(State.INACTIVE);
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
		Collections.shuffle(listItemTile);
		for(int x = 0; x < this.rows; x++)
		{
			for(int y = 0; y < this.columns; y++)
			{				
				if(matrGrid[x][y].isActive() && matrGrid[x][y].isEmpty())
				{
					ItemTile itemTile = listItemTile.remove(random.nextInt(listItemTile.size()));
					matrGrid[x][y].setItemTile(itemTile);
				}

			}
		}
	}
	/**
	 * Verifica se una tessera è prendibile.
	 * @param tileToCheck
	 * @return vero se è prendibile.
	 * @throws @NoFreeSideTileException se la tessera non ha lati liberi
	 */
	public boolean takeableTile(ItemTile tileToCheck) throws Exception
	{
		if(tileToCheck == null){
			throw new NullPointerException("tile is null");
		}
		if (!hasFreeSide(tileToCheck)){
			throw new NoFreeSideTileException("tile has not free side");
		}	
		return true;
	}
	/**
	 * verifica se due tessere sono prendibili.
	 * @param tile1
	 * @param tile2
	 * @return vero se le tessere sono prendibili
	 * @throws @NoAdjacentTilesException se le tessere non sono adiacenti
	 */
	public boolean takeableTile(ItemTile tile1, ItemTile tile2) throws Exception
	{
		this.takeableTile(tile2);
		this.takeableTile(tile1);
		
		if(tile1.equals(tile2)){
			throw new EqualsTilesException("Tiles are equals");
		}
		if(!areAdjacent(tile1,tile2)){
			throw new NoAdjacentTilesException("tiles are not adjacent");
		}
		return true;
	}
	/**
	 * verifica se tre tessere sono prendibili.
	 * @param tile1
	 * @param tile2
	 * @param tile3
	 * @return vero se sono prendibili
	 * @throws @NoAdjacentTilesException se non sono adiacenti
	 * @throws @NotInlineTilesException se non sono tutte sulla stessa riga o colonna
	 */
	public boolean takeableTile(ItemTile tile1, ItemTile tile2,ItemTile tile3) throws Exception
	{
		this.takeableTile(tile1);
		this.takeableTile(tile2);
		this.takeableTile(tile3);
		
		if(tile1.equals(tile3) || tile1.equals(tile2) || tile3.equals(tile2)){
			throw new EqualsTilesException("Almost two Tiles are equals");
		}
		if(!this.areAdjacent(tile1,tile2,tile3)) {
				throw new NoAdjacentTilesException("tiles are not adjacent");
		}
		if(!this.areInline(tile1,tile2,tile3)){
			throw new NotInlineTilesException("tiles are not inline");
		}
		return true;
	}
}
