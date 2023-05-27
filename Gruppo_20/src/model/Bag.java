package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utility.ConfigPath;

/**
 * Classe Bag
 * attributi e metodi che astraggono il sacchetto di Myshelfie
 * @author Marco
 *
 */
public class Bag {
private List<ItemTile>itemTileList;
	
	public Bag()
	{
		itemTileList = new ArrayList<>();
	}
	/**
	 * Riempie il sacchetto con le tessere.
	 * Le informazioni delle tessere vengono lette dal file di testo il cuo percorso è passato come parametro.
	 * @param path percorso del file di testo
	 */
	public void fill(String path)
	{
		File file = new File(path);
		try
		{
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext())
			{
				String[] components;
				components = scanner.nextLine().split(",");
				
					String pathImg = components[0];
					String color = components[1];
	
					ItemTile itemTile = new ItemTile(pathImg,color);
					itemTileList.add(itemTile);
			}
			scanner.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Restituisce una lista contenente le tessere presenti nel sacchetto
	 */
	public List<ItemTile> getItemTileList() {
		return itemTileList;
	}
}
