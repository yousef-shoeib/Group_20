package progetto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		int numberOfPlayers = 3;
		
		ArrayList<ItemTile> listItemTile = new ArrayList<ItemTile>();
		HashMap<String, ItemTile> boardItemTile = new HashMap<String, ItemTile>();
		
		LeavingRoomBoard leavingRoomBoard = new LeavingRoomBoard(numberOfPlayers);
		
		readFile(listItemTile);
		
		leavingRoomBoard.putItemTiles(listItemTile, boardItemTile);
		
		leavingRoomBoard.printGrid();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Scegli tessera coord x");
		int x = sc.nextInt();
		System.out.println("Scegli tessera coord y");
		int y = sc.nextInt();
		sc.close();
		
		ItemTile tile = null;
		try
		{
			int idTile = leavingRoomBoard.getSlot(x, y).getItemTile().getId();
			ItemTile currentItemTile = boardItemTile.get("lb"+idTile);
			//ItemTile adjacentItemTile = null;
			
			tile = leavingRoomBoard.getTile(currentItemTile,null);		
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		
		if(tile != null)
			System.out.println("allow to take");
		else
			System.out.println("access denied");
	}
	//Read File item.txt
	private  static void readFile(ArrayList<ItemTile> listItemTile)
	{
		/**
		 * Carica ItemTiles da File
		 */
		File file = new File("./resources/item.txt");
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(file);
			while(scanner.hasNext())
			{
				String pathImg = scanner.nextLine();
				ItemTile itemTile = new ItemTile(pathImg);
				listItemTile.add(itemTile);
				//System.out.println(itemTile.getId()); 
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			scanner.close();
		}
	

	}

}