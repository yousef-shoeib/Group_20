package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import commongoal.*;

public class Test {

	public static void main(String[] args) {
		Player p1 = new Player("test1");
		Player p2= new Player("test2");
		
		//int number=p.getPersonalGoalCard().getCardNumber();
		//System.out.println(number);
		ItemTile tile1=new ItemTile("blu", "blu");
		ItemTile tile2=new ItemTile("verde", "verde");
		ItemTile tile3=new ItemTile("bianco", "bianco");
		ItemTile tile4=new ItemTile("azzurro", "azzurro");
		ItemTile tile5=new ItemTile("arancione", "arancione");
		ItemTile tile6=new ItemTile("rosa", "rosa");
		ArrayList<ItemTile> tiles=new ArrayList<>();
		tiles.add(tile4);
		tiles.add(tile1);
		tiles.add(tile3);
		ArrayList<ItemTile> tiles2=new ArrayList<>();
		tiles2.add(tile4);
		tiles2.add(tile2);
		tiles2.add(tile3);
		ArrayList<ItemTile> tiles3=new ArrayList<>();
		tiles3.add(tile4);
		tiles3.add(tile1);
		tiles3.add(tile2);
		//p1.getBookshelf().addItemTiles(0, tiles);
		//p1.getBookshelf().addItemTiles(1, tiles2);
		//p1.getBookshelf().addItemTiles(2, tiles3);
		
		//number=p.getPersonalGoalCard().countMatches(p.getBookshelf());
		for(int i=0;i<5;i++) {
			//p1.getBookshelf().setTile(0, i, tile1);
		}
		for(int i=0;i<5;i++) {
			//p1.getBookshelf().setTile(1, i, tile1);
			}
		for(int i=0;i<5;i++) {
			//p1.getBookshelf().setTile(2, i, tile1);
			}
		for(int i=0;i<5;i++) {
			//p1.getBookshelf().setTile(3, i, tile1);
			}
		for(int i=0;i<2;i++) {
			p1.getBookshelf().setTile(4, i, tile1);
			}
		for(int i=0;i<2;i++) {
			p1.getBookshelf().setTile(5, i, tile1);
			}
		for(int i=2;i<4;i++) {
			p1.getBookshelf().setTile(4, i, tile2);
			}
		for(int i=2;i<4;i++) {
			p1.getBookshelf().setTile(5, i, tile2);
			}
		
		
		CommonGoalCard commonGoal=new CommonGoalCard1();
		p1.getBookshelf().printBookshelf();
		System.out.println(commonGoal.CheckTarget(p1.getBookshelf()));
		//commonGoal.CheckTarget(p1.getBookshelf());
		//p.getBookshelf().setTile(4, 0, new ItemTile("blu", "blu"));
		//p.getBookshelf().setTile(3, 0, new ItemTile("blu", "blu"));
		
		/*p1.getBookshelf().countGroups();
		p2.getBookshelf().countGroups();
		List <Integer> test= p1.getBookshelf().getAdjacentTiles();
		for(int i=0;i<test.size();i++) {
			System.out.println(test.get(i));
		}
		List <Integer> test2= p2.getBookshelf().getAdjacentTiles();
		for(int i=0;i<test2.size();i++) {
			System.out.println(test2.get(i));
		}*/
		//System.out.println(p1.getBookshelf().isComplete());
		//System.out.println(p1.getBookshelf().adjacentTilesPoints());
		//System.out.println(p2.getBookshelf().adjacentTilesPoints());
		//System.out.println(number);
		//System.out.println(p.getPersonalGoalCard().getPath());
		/*
		int numberOfPlayers = 3;
		//commit di prova name
		//Check GIT
		ArrayList<ItemTile> listItemTile = new ArrayList<ItemTile>();
		
		LivingRoomBoard leavingRoomBoard = new LivingRoomBoard(numberOfPlayers);
		
		readFile(listItemTile);
		
		leavingRoomBoard.putItemTiles(listItemTile);
		
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
			//int idTile = leavingRoomBoard.getSlot(x, y).getItemTile().getId();
			//ItemTile currentItemTile = boardItemTile.get("lb"+idTile);
			//ItemTile adjacentItemTile = null;
			
			//tile = leavingRoomBoard.getTile(currentItemTile,null);		
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
				//ItemTile itemTile = new ItemTile(pathImg);
				//listItemTile.add(itemTile);
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