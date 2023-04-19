package progetto;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LeavingRoomBoard extends Grid {

	//private Slot [][] matrGrid;
	
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
	
	public LeavingRoomBoard(int nPlayers)
	{
		super(9,9);
		//matrGrid = new Slot[9][9];
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
			
		for(int x = 0; x < 9; x++)
		{
			for(int y = 0; y < 9; y++)
			{
				Slot slot = new Slot();
				if(tempConfigMatr[x][y] == 1)
					slot.setStato(true);
				
				matrGrid[x][y] = slot;
			}
		}
	}
	
	//Assign Item Tile a slot
	public Slot[][] assegnaItemTile(List<ItemTile> listItemTile, HashMap<String, ItemTile> boardItemTile)
	{
		Random random = new Random();
				
		for(int x = 0; x < 9; x++)
		{
			for(int y = 0; y < 9; y++)
			{
				if(matrGrid[x][y].isState() == "T")
				{
					ItemTile itemTile = listItemTile.remove(random.nextInt(listItemTile.size()));
					//itemTile.setX(x);
					//itemTile.setY(y);
					//matrGrid[x][y].setItemTile(itemTile);
					//boardItemTile.put("lb"+itemTile.getId(), itemTile); 
				//System.out.println(matrGriglia[x][y].getItemTile().getColor());
				}

			}
		}
		return matrGrid;
	}
	
	//Check has free side
	public boolean hasFreeSide(int x, int y)
	{			
		
		if(x == 0 || y == 0 || x == 8 || y == 8)
			return true;
		
		Slot slot1 = matrGrid[(x-1)][y];
		Slot slot2 = matrGrid[x][(y-1)];
		Slot slot3 = matrGrid[(x+1)][y];
		Slot slot4 = matrGrid[x][(y+1)];
		
		if(slot1.isState().equals("F") || slot1.getItemTile().equals(null))
			return true;
		if(slot2.isState().equals("F") || slot2.getItemTile().equals(null))
			return true;
		if(slot3.isState().equals("F") || slot3.getItemTile().equals(null))
			return true;
		if(slot4.isState().equals("F") || slot4.getItemTile().equals(null))
			return true;
		
		return false;
	}
}
