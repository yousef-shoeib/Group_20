package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import model.Game;
import model.ItemTile;
import model.Player;
import model.SameTileSelectedException;
import view.MainFrame;

public class MainController {

	private Game game;
	private MainFrame mainFrame;
	private List<ItemTile> listToRemoveTile;
	int cont = 0;
	int check = 0;
	
	public MainController(Game game, MainFrame mainFrame)
	{
		this.game = game;
		this.mainFrame = mainFrame;
		listToRemoveTile = new ArrayList<>();
		
		assignLblNewLabelController();
		assignRemoveTileButtonController();
		assignResetTileButtonController();
		
		Player player1 = new Player("pippo");
		//int emptySlot = player1.getBookshelf().maxDrawableTiles();
		int emptySlot = 5;
		if(emptySlot > 2)
			cont = 3;
		else
			cont = emptySlot;
	}
	
	private void assignLblNewLabelController()
	{

		for(JLabel lblNewLabel : mainFrame.getListTileLabel())
		{
			if(Integer.parseInt(lblNewLabel.getName())!= -1)
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
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(cont != 0)
					{
					   String keyTile = lblNewLabel.getName();
					   ItemTile checkItemTile = game.getLivingRoomBoard().checkTile(Integer.parseInt(keyTile));
					   ItemTile itemTile = null;
					
					   try 
					   {
						   if(listToRemoveTile.size()== 0)   
							   itemTile = game.getLivingRoomBoard().getTile(checkItemTile,null,null);
						   else if(listToRemoveTile.size() == 1)
							   itemTile = game.getLivingRoomBoard().getTile(checkItemTile,listToRemoveTile.get(0),null);
						   else if(listToRemoveTile.size() == 2)
							   itemTile = game.getLivingRoomBoard().getTile(checkItemTile,listToRemoveTile.get(1),listToRemoveTile.get(0));
							   
						   lblNewLabel.setBorder(new LineBorder(new Color(50,205,50), 3));
						   System.out.println("allow to take");
						   listToRemoveTile.add(itemTile);
						   cont--;
					
					   }catch (SameTileSelectedException e2) 
					   {
						   System.out.println(e2.getMessage());
					   }
					   catch (Exception e3) 
					   {
						   System.out.println(e3.getMessage());
						   lblNewLabel.setBorder(new LineBorder(new Color(255, 0, 0), 3));
						   check = 1;
					   }
						   
						 
					}
				}
			});
		}
		}
	}
	
	private void assignRemoveTileButtonController()
	{
		mainFrame.getRemoveTileButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cont = 3;
				
				for(ItemTile item : listToRemoveTile)
				{
					int result = game.getLivingRoomBoard().removeTile(item);
					System.out.println(result);
					for(JLabel label : mainFrame.getListTileLabel())
					{
						if(label.getName().equals(String.valueOf(item.getId())))
							{
								label.setVisible(false);
							}
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
				
				cont = 3;
				
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

}
