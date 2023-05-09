package controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import model.Game;
import model.ItemTile;
import model.Player;
import model.SameTileSelectedException;
import utility.ConfigPath;
import view.MainFrame;

public class MainController {

	private Game game;
	private MainFrame mainFrame;
	private List<ItemTile> listToRemoveTile;
	int maxNumberGettableTile = 0;
	int check = 0;
	int selectedBookShelfColumn = -1;
	
	public MainController(Game game, MainFrame mainFrame)
	{
		this.game = game;
		this.mainFrame = mainFrame;
		listToRemoveTile = new ArrayList<>();
		
		assignLblNewLabelController();
		assignBookShelfTileLabelController();
		assignRemoveTileButtonController();
		assignResetTileButtonController();
		
		Player player1 = new Player("pippo");
		//int emptySlot = player1.getBookshelf().maxDrawableTiles();
		int emptySlot = 5;
		if(emptySlot > 2)
			maxNumberGettableTile = 3;
		else
			maxNumberGettableTile = emptySlot;
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
					   ItemTile checkItemTile = game.getLivingRoomBoard().checkTile(Integer.parseInt(keyTile));
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
	
	private void assignRemoveTileButtonController()
	{
		mainFrame.getRemoveTileButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				maxNumberGettableTile = 3;

				int i = 5;
				for(ItemTile item : listToRemoveTile)
				{
					for(JLabel label : mainFrame.getListTileLabel())
					{
						if(label.getName().equals(String.valueOf(item.getId())))
							{
								label.setVisible(false);
								game.getListPlayer().get(0).getBookshelf().setTile(i, selectedBookShelfColumn,item);
								ImageIcon tempIcon =new ImageIcon(ConfigPath.getItemTilePath()+item.getPathImg()+".png");
								ImageIcon icon= new ImageIcon(tempIcon.getImage().getScaledInstance(55,55, Image.SCALE_SMOOTH));
								for(JLabel label1 : mainFrame.getListBookShelfTileLabel())
								{
									if(label1.getName().equals((selectedBookShelfColumn+"_"+i)))
									{
										label1.setIcon(icon);
									}

								}
								i--;
							}
						game.getLivingRoomBoard().removeTile(item);
					}	
				}
				listToRemoveTile = null;
				listToRemoveTile = new ArrayList<>();

			}
		} );
	}
	
	private void assignResetTileButtonController()
	{
		mainFrame.getResetTileButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				maxNumberGettableTile = 3;
				
				for(ItemTile item : listToRemoveTile)
				{
					for(JLabel label : mainFrame.getListTileLabel())
					{
						if(label.getName().equals(String.valueOf(item.getId())))
							{	
								label.setBorder(new LineBorder(new Color(255,255,255), 3));
							}
					}		
				}
				listToRemoveTile = null;
				listToRemoveTile = new ArrayList<>();

			}
		} );
	}
	private void assignBookShelfTileLabelController()
	{

		for(JLabel label : mainFrame.getListBookShelfTileLabel())
		{
				
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
						
					   int freeSlot = game.getListPlayer().get(0).getBookshelf().numberOfEmptySlot(selectedBookShelfColumn);
					   if(freeSlot > 0)
						{
							label.setBorder(new LineBorder(new Color(50,205,50), 3));
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
	private void selectAllFreeSlot(int column,int freeSlot)
	{
		for(JLabel label : mainFrame.getListBookShelfTileLabel())
		{
			label.setBorder(new LineBorder(new Color(101,67,53), 3));	
		}
		for(int i = 0; i < freeSlot; i++)
		{
			for(JLabel label : mainFrame.getListBookShelfTileLabel())
			{
				if(label.getName().equals(column+"_"+i) )
				{
					label.setBorder(new LineBorder(new Color(50,205,50), 3));
				}			
			}
		}
	}
	private void deselectItemTile(JLabel lblNewLabel)
	{
		ItemTile item = game.getLivingRoomBoard().checkTile(Integer.parseInt(lblNewLabel.getName()));
		   int index = listToRemoveTile.indexOf(item);
		   
		   if(index == -1)
		   {
			   lblNewLabel.setBorder(new LineBorder(new Color(255, 0, 0), 3));
			   check = 1;
		   }
		   
		   if(listToRemoveTile.size() == 3)
		   {
			   if(index == 0)
			   {
				   if(game.getLivingRoomBoard().tilesAreAdjacent(listToRemoveTile.get(0), listToRemoveTile.get(1)) 
						   && game.getLivingRoomBoard().tilesAreAdjacent(listToRemoveTile.get(0), listToRemoveTile.get(2)))
				   {
					   System.out.println("can't deselect this tile");
					   lblNewLabel.setBorder(new LineBorder(new Color(255, 0, 0), 3));
					   check = 2;
				   }
				   else
				   {
					   listToRemoveTile.remove(index);
					   lblNewLabel.setBorder(new LineBorder(new Color(255,255,255), 3));
					   maxNumberGettableTile++;
				   }
			   }
			   if(index == 1)
			   {
				   if(game.getLivingRoomBoard().tilesAreAdjacent(listToRemoveTile.get(1), listToRemoveTile.get(0)) 
						   && game.getLivingRoomBoard().tilesAreAdjacent(listToRemoveTile.get(1), listToRemoveTile.get(2)))
				   {
					   System.out.println("can't deselect this tile");
					   lblNewLabel.setBorder(new LineBorder(new Color(255, 0, 0), 3));
					   check = 2;
				   }
				   else
				   {
					   listToRemoveTile.remove(index);
					   lblNewLabel.setBorder(new LineBorder(new Color(255,255,255), 3));
					   maxNumberGettableTile++;
				   }
			   }
			   if(index == 2)
			   {
				   if(game.getLivingRoomBoard().tilesAreAdjacent(listToRemoveTile.get(2), listToRemoveTile.get(0)) 
						   && game.getLivingRoomBoard().tilesAreAdjacent(listToRemoveTile.get(2), listToRemoveTile.get(1)))
				   {
					   System.out.println("can't deselect this tile"); 
					   lblNewLabel.setBorder(new LineBorder(new Color(255, 0, 0), 3));
					   check = 2;
				   }
				   else
				   {
					   listToRemoveTile.remove(index);
					   lblNewLabel.setBorder(new LineBorder(new Color(255,255,255), 3));
					   maxNumberGettableTile++;
				   }
			   }
		   }
		   else
		   {
			   ItemTile item1 = listToRemoveTile.remove(index);
			   lblNewLabel.setBorder(new LineBorder(new Color(255,255,255), 3));
			   maxNumberGettableTile++;
		   }
	}
}
