package controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import cards.PersonalGoalCard;
import model.Bookshelf;
import model.Game;
import model.ItemTile;
import model.Player;
import model.SameTileSelectedException;
import model.Slot;
import utility.ConfigPath;
import view.MainFrame;

public class MainController {

	private Game game;
	private MainFrame mainFrame;
	
	private static int currentPlayer=0;
	int maxNumberGettableTile = 0;
	int selectedBookShelfColumn = -1;
	int check = 0;
	boolean placing=false;
	int positionToSwap=0; //to order box getted tiles
	private List<ItemTile> listToRemoveTile;
	private Map<String,JLabel> labelToRemove;

	
	public MainController(Game game, MainFrame mainFrame)
	{
		this.game = game;
		this.mainFrame = mainFrame;
		listToRemoveTile = new ArrayList<>();
		labelToRemove = new HashMap<>();
		

		setCurrentPlayer(game);
		assignLblNewLabelController();
		assignBookShelfTileLabelController();
		assignBoxedGettedTileLabelController();
		assignTakeTileButtonController();
		assignAddBookShelfTileButtonController();
		assignEndRoundButtonController();	
		loadPersonalGoalCard();
		
		maxNumberGettableTile = game.getListPlayer().get(currentPlayer).getBookshelf().maxDrawableTiles();
		mainFrame.getPlayerNameLabel().setText("      Player " + (currentPlayer+1) +": "+ game.getListPlayer().get(currentPlayer).getName());
	}
	private void assignLblNewLabelController()
	{
		for(Entry<String, JLabel> set : mainFrame.getMapLivingTileLabel().entrySet())
		{
				JLabel label = set.getValue();
			
				label.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					if(check == 1)
					{
					   label.setBorder(new LineBorder(new Color(255,255,255), 3));
					   check = 0;
					}
					if(check == 2)
					{
					   label.setBorder(new LineBorder(new Color(50,205,50), 3));
					   check = 0;
					}	
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
						
					   String[] coordinates = label.getName().split("_");
					   int row = Integer.parseInt(coordinates[0]);
					   int column = Integer.parseInt(coordinates[1]);
					   Slot currentSlot = game.getLivingRoomBoard().getSlot(row, column);
					   ItemTile checkItemTile = null;
					   if(!currentSlot.isEmpty()) {
						   checkItemTile = currentSlot.getItemTile();
					   }

					   ItemTile itemTile = null;

					   try 
					   {
						   if(listToRemoveTile.size()== 0)  
						   {
							   itemTile = game.getLivingRoomBoard().getTile(checkItemTile,null,null,maxNumberGettableTile);
						   }
						   else if(listToRemoveTile.size() == 1)
						   {
							   itemTile = game.getLivingRoomBoard().getTile(checkItemTile,listToRemoveTile.get(0),null,maxNumberGettableTile); 
						   }

						   else if(listToRemoveTile.size() >= 2)
						   {
							   itemTile = game.getLivingRoomBoard().getTile(checkItemTile,listToRemoveTile.get(1),listToRemoveTile.get(0),maxNumberGettableTile);
						   }
							   
						   label.setBorder(new LineBorder(new Color(50,205,50), 3));
						   System.out.println("allow to take");
						   listToRemoveTile.add(itemTile);
						   labelToRemove.put(String.valueOf(itemTile.getId()), label);
						   maxNumberGettableTile--;
									   
					   }catch (SameTileSelectedException e2) 
					   {
						   System.out.println(e2.getMessage());
						   deselectItemTile(label);
					   }
					   catch(IllegalArgumentException e3)
					   {
						   System.out.println(e3.getMessage());
						   deselectItemTile(label);
					   }
					   catch (Exception e4) 
					   {
						   System.out.println(e4.getMessage());
						   label.setBorder(new LineBorder(new Color(255, 0, 0), 3));
						   check = 1;
					   }
						
					  if(listToRemoveTile.size() > 0) {
							mainFrame.getTakeTileButton().setEnabled(true);
					  }
					  else {
						  mainFrame.getTakeTileButton().setEnabled(false);
					  }
				}
			});
		}
	}	
	private void assignTakeTileButtonController()
	{
		mainFrame.getTakeTileButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				int i = 0;
				for(ItemTile item : listToRemoveTile)
				{
					JLabel tempLabel = labelToRemove.get(String.valueOf(item.getId()));
					ImageIcon tempIcon = new ImageIcon(ConfigPath.getItemTilePath()+item.getPathImg()+".png");
					ImageIcon icon = new ImageIcon(tempIcon.getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH));
					mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel_"+i).setIcon(icon);
					mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel_"+i).setVisible(true);
					tempLabel.setVisible(false);

					i++;
				}
				maxNumberGettableTile = 0;
				
				if(listToRemoveTile.size() > 0) {
					mainFrame.getTakeTileButton().setEnabled(false);
					mainFrame.getAddTileButton().setEnabled(true);
				}
			}
		});
	}
	private void assignAddBookShelfTileButtonController()
	{
		mainFrame.getAddTileButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int i = game.getListPlayer().get(currentPlayer).getBookshelf().freeSlotsInColumn(selectedBookShelfColumn)-1;//
				
				for(ItemTile item : listToRemoveTile)
				{
					game.getListPlayer().get(currentPlayer).getBookshelf().setTile(i, selectedBookShelfColumn,item);
					
					ImageIcon tempIcon =new ImageIcon(ConfigPath.getItemTilePath()+item.getPathImg()+".png");
					ImageIcon icon= new ImageIcon(tempIcon.getImage().getScaledInstance(55,55, Image.SCALE_SMOOTH));
					mainFrame.getMapBookShelfTileLabel().get(i+"_"+selectedBookShelfColumn).setIcon(icon);

					game.getLivingRoomBoard().removeTile(item);
					
					i--;
				}	
				
				deselectAllSlot();
				hideBoxedGettedTileLabels();
				selectedBookShelfColumn = -1;
				listToRemoveTile = null;
				listToRemoveTile = new ArrayList<>();
				mainFrame.getAddTileButton().setEnabled(false);/////
			}
		});
	}
	private void assignEndRoundButtonController()
	{
		mainFrame.getEndRoundButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				increaseCurrentPlayer();
				loadBookshelf();
				loadPersonalGoalCard();
				maxNumberGettableTile = game.getListPlayer().get(currentPlayer).getBookshelf().maxDrawableTiles();
				mainFrame.getPlayerNameLabel().setText("      Player " + (currentPlayer+1) +": "+ game.getListPlayer().get(currentPlayer).getName());
				if(!game.getLivingRoomBoard().hasAdjacentTiles())
				{
					game.getLivingRoomBoard().putItemTiles(game.getBag().getListItemTile());
					mainFrame.fillLeavingRoomBoard(game.getLivingRoomBoard().getMatrGrid(),game.getLivingRoomBoard().getRows(),game.getLivingRoomBoard().getColumns());
				}
			}
		});
	}
	private void assignBookShelfTileLabelController()
	{
		for(Entry<String, JLabel> set : mainFrame.getMapBookShelfTileLabel().entrySet())
		{
				JLabel label = set.getValue();
		
				label.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					if(check == 1)
					{
					   label.setBorder(new LineBorder(new Color(101,67,53), 3));
					   check = 0;
					}
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {

					   String[] slotCoordinate;
					   slotCoordinate = label.getName().split("_");

					   selectedBookShelfColumn = Integer.parseInt(slotCoordinate[1]);
						
					   int freeSlot = game.getListPlayer().get(currentPlayer).getBookshelf().numberOfEmptySlot(selectedBookShelfColumn);
					   if(freeSlot > 0)
						{
							deselectAllSlot();
							selectAllFreeSlot(selectedBookShelfColumn,freeSlot);
						}
					   else
					   {
						   label.setBorder(new LineBorder(new Color(255, 0, 0), 3));
						   check = 1;
					   }	   
				}
			});
		}
	}
	private void assignBoxedGettedTileLabelController()
	{
		
		for(Entry<String, JLabel> set : mainFrame.getBoxedGettedTileLabel().entrySet())
		{
				JLabel label = set.getValue();
				label.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					label.setBorder(new LineBorder(new Color(255, 255, 255), 3));
				}
				
				@Override
				public void mousePressed(MouseEvent e) {///////////
					String[] index = label.getName().split("_");
					int i= Integer.parseInt(index[1]);
					if(!placing) {
						
						positionToSwap=i;
						label.setBorder(new LineBorder(new Color(0, 150, 255), 3));
						placing=true;
					}
					else {
						Collections.swap(listToRemoveTile, positionToSwap, i);
						int n = 0;
						for(ItemTile item : listToRemoveTile)
						{
							ImageIcon tempIcon = new ImageIcon(ConfigPath.getItemTilePath()+item.getPathImg()+".png");
							ImageIcon icon = new ImageIcon(tempIcon.getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH));
							mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel_"+n).setIcon(icon);
							label.setBorder(new LineBorder(new Color(255, 255, 255), 3));
							mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel_"+n).setVisible(true);

							n++;
						}
						placing=false;
					}
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					if(check == 1)
					{
						label.setBorder(new LineBorder(new Color(255,255,255), 3));
						check = 0;
					}	
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
		}
	}
	private void loadBookshelf()
	{
		Bookshelf bookshelf = game.getListPlayer().get(currentPlayer).getBookshelf();
		int numRows = bookshelf.getRows();
		int numColumns = bookshelf.getColumns();
		
		mainFrame.fillBookShelf(bookshelf.getMatrGrid(), numRows, numColumns);
	}
	private void loadPersonalGoalCard()
	{
		PersonalGoalCard personalGoal = game.getListPlayer().get(currentPlayer).getPersonalGoalCard();
		
					ImageIcon tempIcon =new ImageIcon(personalGoal.getPath());
					ImageIcon icon= new ImageIcon(tempIcon.getImage().getScaledInstance(150, 250,Image.SCALE_SMOOTH));
					mainFrame.getPersonalGoalCardLabel().setIcon(icon);
	}
	private void deselectAllSlot()
	{
		for(Entry<String, JLabel> set : mainFrame.getMapBookShelfTileLabel().entrySet())
		{
			JLabel label = set.getValue();
			label.setBorder(new LineBorder(new Color(101,67,53), 3));	
		}
	}
	private void selectAllFreeSlot(int column,int freeSlot)
	{	
		for(int i = 0; i < freeSlot; i++)
		{
			mainFrame.getMapBookShelfTileLabel().get(i+"_"+column).setBorder(new LineBorder(new Color(50,205,50), 3));
		}
	}
	private void deselectItemTile(JLabel label)
	{
		String[] coordinates = label.getName().split("_");
		int row = Integer.parseInt(coordinates[0]);
		int column = Integer.parseInt(coordinates[1]);
		Slot currentSlot = game.getLivingRoomBoard().getSlot(row, column);
		ItemTile item = null;
		
		if(!currentSlot.isEmpty()) {
		   item = currentSlot.getItemTile();
		}
		
		int index = listToRemoveTile.indexOf(item);
		   
		boolean deselect = true;
		if(listToRemoveTile.size() == 3)
		{
		   if(index == 0){
			   if(game.getLivingRoomBoard().tilesAreAdjacent(listToRemoveTile.get(0), listToRemoveTile.get(1)) 
					   && game.getLivingRoomBoard().tilesAreAdjacent(listToRemoveTile.get(0), listToRemoveTile.get(2))){
				   deselect = false;
			   }
		   }
		   else if(index == 1){
			   if(game.getLivingRoomBoard().tilesAreAdjacent(listToRemoveTile.get(1), listToRemoveTile.get(0)) 
					   && game.getLivingRoomBoard().tilesAreAdjacent(listToRemoveTile.get(1), listToRemoveTile.get(2))){
				   deselect = false;
			   }
		   }
		   else if(index == 2){
			   if(game.getLivingRoomBoard().tilesAreAdjacent(listToRemoveTile.get(2), listToRemoveTile.get(0)) 
					   && game.getLivingRoomBoard().tilesAreAdjacent(listToRemoveTile.get(2), listToRemoveTile.get(1))){
				   deselect = false;
			   }
		   }
		}	   
		if(deselect){
		   listToRemoveTile.remove(index);
		   label.setBorder(new LineBorder(new Color(255,255,255), 3));
		   maxNumberGettableTile++;
		}
		else {
		   System.out.println("can't deselect this tile"); 
		   label.setBorder(new LineBorder(new Color(255, 0, 0), 3));
		   check = 2;
		}
	}
	private void hideBoxedGettedTileLabels()
	{
		for(int i = 0; i < 3; i++)
		{
			mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel_"+i).setIcon(null);
			mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel_"+i).setVisible(false);
			mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel_"+i).setBorder(new LineBorder(new Color(255,255,255), 3));
		}
	}
	public void setCurrentPlayer(Game game) {
		int size=game.getListPlayer().size();
		for(int i=0; i<size;i++ ) {
			if(game.getListPlayer().get(i).isFirstPlayer()) {
				currentPlayer=i;
			}
		}
	}
	private void increaseCurrentPlayer()
	{
		if(currentPlayer == game.getListPlayer().size()-1){
			currentPlayer = 0;
		}
			else{
				currentPlayer++;
			}
	}
}
