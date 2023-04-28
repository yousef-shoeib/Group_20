package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bag {
private List<ItemTile>listItemTile;
	
	public Bag()
	{
		listItemTile = new ArrayList<>();
		readFile();
		
	}
	public List<ItemTile> getListItemTile() {
		return listItemTile;
	}
	private void readFile()
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
				String[] components;
				components = scanner.nextLine().split(",");
				if(components.length == 2)
				{
					System.out.println(components.length);
					String pathImg = components[0];
					String color = components[1];
	
					ItemTile itemTile = new ItemTile(pathImg,color);
					listItemTile.add(itemTile);
				}
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
