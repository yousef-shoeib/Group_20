package controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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
	private List<ItemTile> listToRemoveTile;
	int maxNumberGettableTile = 0;
	int check = 0;
	int selectedBookShelfColumn = -1;
	private Map<String,JLabel> labelToRemove;
	private static int currentPlayer=0;
	
	public MainController(Game game, MainFrame mainFrame)
	{
		this.game = game;
		this.mainFrame = mainFrame;
		listToRemoveTile = new ArrayList<>();
		labelToRemove = new HashMap<>();
		

		setCurrentPlayer(game);
		assignLblNewLabelController();
		assignBookShelfTileLabelController();
		assignboxedGettedTileLabelController();
		assignTakeTileButtonController();
		assignAddBookShelfTileButtonController();
		assignEndRoundButtonController();	
		loadPersonalGoalCard();
		
		
		maxNumberGettableTile = game.getListPlayer().get(currentPlayer).getBookshelf().maxDrawableTiles();
		mainFrame.getPlayerNameLabel().setText("Player " + (currentPlayer+1) +": "+ game.getListPlayer().get(currentPlayer).getName());
	}
	private void assignLblNewLabelController()
	{

		for(JLabel lblNewLabel : mainFrame.getListTileLabel())
		{
				
				lblNewLabel.addMouseListener(new MouseListener() {
				
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
					   lblNewLabel.setBorder(new LineBorder(new Color(255,255,255), 3));
					   check = 0;
					}
					if(check == 2)
					{
					   lblNewLabel.setBorder(new LineBorder(new Color(50,205,50), 3));
					   check = 0;
					}
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
						
					   String keyTile = lblNewLabel.getName();
					   ItemTile checkItemTile = game.getLivingRoomBoard().contains(Integer.parseInt(keyTile));
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
							   
						   lblNewLabel.setBorder(new LineBorder(new Color(50,205,50), 3));
						   System.out.println("allow to take");
						   listToRemoveTile.add(itemTile);
						   labelToRemove.put(String.valueOf(itemTile.getId()), lblNewLabel);
						   maxNumberGettableTile--;
						   
					   }catch (SameTileSelectedException e2) 
					   {
						   System.out.println(e2.getMessage());
						   deselectItemTile(lblNewLabel);
					   }
					   catch(IllegalArgumentException e3)
					   {
						   System.out.println(e3.getMessage());
						   deselectItemTile(lblNewLabel);
					   }
					   catch (Exception e4) 
					   {
						   System.out.println(e4.getMessage());
						   lblNewLabel.setBorder(new LineBorder(new Color(255, 0, 0), 3));
						   check = 1;
					   }
					   
				}
			});
		}
	}
	
	private void assignTakeTileButtonController()
	{
		mainFrame.getRemoveTileButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				int i = 0;
				for(ItemTile item : listToRemoveTile)
				{
					JLabel tempLabel = labelToRemove.get(String.valueOf(item.getId()));
					ImageIcon tempIcon = new ImageIcon(ConfigPath.getItemTilePath()+item.getPathImg()+".png");
					ImageIcon icon = new ImageIcon(tempIcon.getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH));
					mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel"+i).setIcon(icon);
					
					tempLabel.setVisible(false);
					mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel"+i).setVisible(true);

					i++;
				}
				
				maxNumberGettableTile = 0;
			}
		});
	}
	
	private void assignAddBookShelfTileButtonController()
	{
		mainFrame.getAddTileButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int i = game.getListPlayer().get(currentPlayer).getBookshelf().freeSlotsInColumn(selectedBookShelfColumn)-1;
				
				for(ItemTile item : listToRemoveTile)
				{
					game.getListPlayer().get(currentPlayer).getBookshelf().setTile(i, selectedBookShelfColumn,item);
					
					ImageIcon tempIcon =new ImageIcon(ConfigPath.getItemTilePath()+item.getPathImg()+".png");
					ImageIcon icon= new ImageIcon(tempIcon.getImage().getScaledInstance(55,55, Image.SCALE_SMOOTH));
					
					for(Entry<String, JLabel> set : mainFrame.getMapBookShelfTileLabel().entrySet())
					{
							JLabel label1 = set.getValue();
							
						if(label1.getName().equals((selectedBookShelfColumn+"_"+i)))
						{
							label1.setIcon(icon);
						}

					}
					i--;

					game.getLivingRoomBoard().removeTile(item);
				}	
				
				
				deselectSlot();
				svuotaBoxedGettedTileLabel();
				selectedBookShelfColumn = -1;
				listToRemoveTile = null;
				listToRemoveTile = new ArrayList<>();

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
				mainFrame.getPlayerNameLabel().setText("Player " + (currentPlayer+1) +": "+ game.getListPlayer().get(currentPlayer).getName());
			}
		});
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
	private void svuotaBoxedGettedTileLabel()
	{
		for(int i = 0; i < 3; i++)
		{
			mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel"+i).setIcon(null);
			mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel"+i).setVisible(false);
			mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel"+i).setBorder(new LineBorder(new Color(255,255,255), 3));
		}
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
					/*if(check == 2)
					{
					   label.setBorder(new LineBorder(new Color(50,205,50), 3));
					   check = 0;
					}*/
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {

					   String[] slotCoordinate;
					   slotCoordinate = label.getName().split("_");

					   selectedBookShelfColumn = Integer.parseInt(slotCoordinate[0]);
					   String row = slotCoordinate[1];
						
					   int freeSlot = game.getListPlayer().get(currentPlayer).getBookshelf().numberOfEmptySlot(selectedBookShelfColumn);
					   if(freeSlot > 0)
						{
							deselectSlot();
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
	private void assignboxedGettedTileLabelController()
	{
		
		for(Entry<String, JLabel> set : mainFrame.getBoxedGettedTileLabel().entrySet())
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
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
						
					   //String keyTile = label.getName();
					   /*ItemTile checkItemTile = game.getLivingRoomBoard().checkTile(Integer.parseInt(keyTile));
					   ItemTile itemTile = null;*/
					   
					   label.setBorder(new LineBorder(new Color(50,205,50), 3));
					   //listToRemoveTile.add(itemTile);	   
				}
			});
		}
	}
	private void loadBookshelf()
	{
		Bookshelf bookshelf = game.getListPlayer().get(currentPlayer).getBookshelf();
		int numRows = bookshelf.getRows();
		int numColumns = bookshelf.getColumns();
		
		for(int row = 0; row < numRows; row++ )
		{
			for(int column = 0; column < numColumns; column++ )
			{
				if(!bookshelf.getSlot(row, column).isEmpty())
				{
					ImageIcon tempIcon =new ImageIcon(ConfigPath.getItemTilePath()+bookshelf.getSlot(row, column).getItemTile().getPathImg()+".png");
					ImageIcon icon= new ImageIcon(tempIcon.getImage().getScaledInstance(55,55, Image.SCALE_SMOOTH));
					mainFrame.getMapBookShelfTileLabel().get(column+"_"+row).setIcon(icon);
				}
				else{
					mainFrame.getMapBookShelfTileLabel().get(column+"_"+row).setIcon(null);
				}
			}
		}
	}
	private void loadPersonalGoalCard()
	{
		PersonalGoalCard personalGoal = game.getListPlayer().get(currentPlayer).getPersonalGoalCard();
		
					ImageIcon tempIcon =new ImageIcon(personalGoal.getPath());
					ImageIcon icon= new ImageIcon(tempIcon.getImage().getScaledInstance(150, 250,Image.SCALE_SMOOTH));
					mainFrame.getPersonalGoalCardLabel().setIcon(icon);
	}
				
		
	
	private void deselectSlot()
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
			mainFrame.getMapBookShelfTileLabel().get(column+"_"+i).setBorder(new LineBorder(new Color(50,205,50), 3));
		}
	}
	private void deselectItemTile(JLabel label)
	{
		ItemTile item = game.getLivingRoomBoard().contains(Integer.parseInt(label.getName()));
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
	public void setCurrentPlayer(Game game) {
		int size=game.getListPlayer().size();
		for(int i=0; i<size;i++ ) {
			if(game.getListPlayer().get(i).isFirstPlayer()) {
				currentPlayer=i;
			}
		}
	}
}
