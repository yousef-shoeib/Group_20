package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import cards.PersonalGoalCard;
import commongoal.CommonGoalCard;
import exception.MaxSelectedItemTileException;
import exception.SameTileSelectedException;
import model.Bookshelf;
import model.Game;
import model.GameState;
import model.ItemTile;
import model.Player;
import model.Slot;
import utility.ConfigPath;
import view.MainFrame;
import view.SetGameFrame;

public class MainController {

	private Game game;
	private MainFrame mainFrame;
	
	int selectedBookShelfColumn = -1;
	int check = 0;
	boolean placing=false;
	boolean taken = false;
	int positionToSwap=0; //to order box getted tiles
	private Map<String,JLabel> labelToRemove;

	
	public MainController(Game game, MainFrame mainFrame)
	{
		this.game = game;
		this.mainFrame = mainFrame;
		labelToRemove = new HashMap<>();
		
		assignQuitGameButtonController();
		game.getFirstPlayer();
		assignLivingTileLabelController();
		assignBookShelfTileLabelController();
		assignBoxedGettedTileLabelController();
		assignGettedTilesBoxController();
		assignTakeTileButtonController();
		assignEndRoundButtonController();	
		loadPersonalGoalCard();
		loadCommonGoalCards();
		flipPersonalGoalCard();
		mainFrame.getPlayerNameLabel().setText("Player " + (game.getCurrentPlayer()+1) +": "+ game.getCurrentPlayerName());
		mainFrame.getPlayerPointsLabel().setText("Points: "+ game.getCurrentPlayerPoints());
	}
	private void assignLivingTileLabelController()
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
					
					if(!taken) {
						String[] coordinates = label.getName().split("_");
						int row = Integer.parseInt(coordinates[0]);
						int column = Integer.parseInt(coordinates[1]);
					   
						ItemTile checkItemTile = null;
						try{
							checkItemTile = game.addToSelectedTileList(row,column);
							label.setBorder(new LineBorder(new Color(50,205,50), 3));
							labelToRemove.put(String.valueOf(checkItemTile.getId()), label);
							System.out.println("allow to take");
						}
						catch(MaxSelectedItemTileException ex2){
							System.out.println(ex2.getMessage());
							if(game.selectedtTileContains(row, column))
							{
								if(game.deselectFromTakenList(row,column)){
								label.setBorder(new LineBorder(new Color(255,255,255), 3));
								}
							else{
								label.setBorder(new LineBorder(new Color(255, 0, 0), 3));
								check = 2;
								}
							}
						}
						catch(SameTileSelectedException ex1){
							System.out.println(ex1.getMessage());
							if(game.deselectFromTakenList(row,column)){
								label.setBorder(new LineBorder(new Color(255,255,255), 3));
							}
							else{
								label.setBorder(new LineBorder(new Color(255, 0, 0), 3));
								check = 2;
							}
						}
						catch (Exception e1) {
							System.out.println(e1.getMessage());
							label.setBorder(new LineBorder(new Color(255, 0, 0), 3));
							check = 1;
						}
	
						  if(game.numberOfSelectedTile() > 0) {
								mainFrame.getTakeTileButton().setEnabled(true);
						  }
						  else {
							  mainFrame.getTakeTileButton().setEnabled(false);
						  }
					}
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
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
					// TODO Auto-generated method stub	
				}
			});
		}
	}	
	private void assignTakeTileButtonController()
	{
		mainFrame.getTakeTileButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					
				game.takeTiles();
				List<ItemTile> takenTilesList = game.getTilesList();
				int i = 0;
				for(ItemTile item : takenTilesList)
				{
					JLabel tempLabel = labelToRemove.get(String.valueOf(item.getId()));
					ImageIcon tempIcon = new ImageIcon(ConfigPath.getItemTilePath()+item.getPathImg()+".png");
					ImageIcon icon = new ImageIcon(tempIcon.getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH));
					mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel_"+i).setIcon(icon);
					mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel_"+i).setVisible(true);
					tempLabel.setVisible(false);
					taken = true;

					i++;
				}
				
				if(takenTilesList.size() > 0) {
					mainFrame.getTakeTileButton().setEnabled(false);
				}
			}
		});
	}
	private void assignGettedTilesBoxController()
	{
		mainFrame.getBoxGettedTileLabel().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(game.numberOfSelectedTile() > 0) {
					game.takeTiles();
					List<ItemTile> takenTilesList = game.getTilesList();
					int i = 0;
					for(ItemTile item : takenTilesList)
					{
						JLabel tempLabel = labelToRemove.get(String.valueOf(item.getId()));
						ImageIcon tempIcon = new ImageIcon(ConfigPath.getItemTilePath()+item.getPathImg()+".png");
						ImageIcon icon = new ImageIcon(tempIcon.getImage().getScaledInstance(75,75, Image.SCALE_SMOOTH));
						mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel_"+i).setIcon(icon);
						mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel_"+i).setVisible(true);
						tempLabel.setVisible(false);
						taken = true;
	
						i++;
					}
					
					if(takenTilesList.size() > 0) {
						mainFrame.getTakeTileButton().setEnabled(false);
					}
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	private void assignEndRoundButtonController()
	{
		mainFrame.getEndRoundButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean fill = game.endRound();
				if(fill)
				{
					mainFrame.fillLeavingRoomBoard(game.getLivingRoomBoard(),9,9);
				}
				deselectAllSlot();
				selectedBookShelfColumn = -1;
				loadBookshelf();
				loadPersonalGoalCard();
				mainFrame.getPlayerNameLabel().setText("Player " + (game.getCurrentPlayer()+1) +": "+ game.getCurrentPlayerName());
				mainFrame.getPlayerPointsLabel().setText("Points: " + game.getCurrentPlayerPoints());

				mainFrame.getEndRoundButton().setEnabled(false);
				assignFirstPlayerTokenLabel();
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
					
					if(taken) {

						   String[] slotCoordinate;
						   slotCoordinate = label.getName().split("_");

						   int tempColumn = Integer.parseInt(slotCoordinate[1]);
						   
						   int freeSlot = game.currentPlayerFreeSlot(tempColumn);
						   if(freeSlot > 0 && freeSlot >= game.numberOfSelectedTile())
							{
								/*deselectAllSlot();
								selectedBookShelfColumn = tempColumn;
								selectAllFreeSlot(selectedBookShelfColumn,freeSlot);
								mainFrame.getAddTileButton().setEnabled(true);*/
							   	selectedBookShelfColumn = tempColumn;
								selectAllFreeSlot(selectedBookShelfColumn,freeSlot,new Color(50,205,50));
								int i = game.currentPlayerFreeSlot(selectedBookShelfColumn)-1;
								List<ItemTile> takenTilesList = game.moveTilesToBookshelf(selectedBookShelfColumn);
								for(ItemTile item : takenTilesList)
								{	
									ImageIcon tempIcon =new ImageIcon(ConfigPath.getItemTilePath()+item.getPathImg()+".png");
									ImageIcon icon= new ImageIcon(tempIcon.getImage().getScaledInstance(55,55, Image.SCALE_SMOOTH));
									mainFrame.getMapBookShelfTileLabel().get(i+"_"+selectedBookShelfColumn).setIcon(icon);
									
									i--;
								}	
								
								//deselectAllSlot();
								hideBoxedGettedTileLabels();
								selectedBookShelfColumn = -1;
								taken = false;
								mainFrame.getEndRoundButton().setEnabled(true);
								game.checkCommonGoal();
								if(game.currentPlayer().getBookshelf().isComplete()) {
									game.finalPointsCount();
									createGameOverPanel();
									Game.setState(GameState.GAME_OVER);
								}
							}
						   else
						   {
							   selectAllFreeSlot(tempColumn,freeSlot,new Color(255,0,0));
						   }
						   check = 1;
						}
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					if(check == 1)
					{
						deselectAllSlot();
						check = 0;
					}
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e){
					// TODO Auto-generated method stub
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
					//label.setBorder(new LineBorder(new Color(255, 255, 255), 3));
				}
				
				@Override
				public void mousePressed(MouseEvent e) {///////////
					String[] index = label.getName().split("_");
					int i= Integer.parseInt(index[1]);
					if(!placing) {
						
						positionToSwap=i;
						label.setBorder(new LineBorder(new Color(50,205,50), 3));
						placing=true;
					}
					else {
						mainFrame.getBoxedGettedTileLabel().get("boxedGettedTileLabel_"+positionToSwap).setBorder(new LineBorder(new Color(255, 255, 255), 3));
						game.swapTiles(positionToSwap, i);
						List<ItemTile> takenTilesList = game.getTilesList();
						int n = 0;
						for(ItemTile item : takenTilesList)
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
					//label.setBorder(new LineBorder(new Color(255, 255, 255), 3));
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
	private void flipPersonalGoalCard()
	{	
		JLabel label=mainFrame.getPersonalGoalCardLabel();
		ImageIcon tempFaceDownIcon= new ImageIcon("./resources/Assets/personalGoalCards/back.jpg");
		ImageIcon FaceDownIcon= new ImageIcon(tempFaceDownIcon.getImage().getScaledInstance(150, 250,Image.SCALE_SMOOTH));
		
				mainFrame.getPersonalGoalCardLabel().addMouseListener(new MouseListener() {
				
				
				
				@Override
				public void mouseExited(MouseEvent e) {
					label.setIcon(FaceDownIcon);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {	
					ImageIcon tempIcon =new ImageIcon(game.getCurrentPlayerPersonalGoalCardPath());
					ImageIcon icon= new ImageIcon(tempIcon.getImage().getScaledInstance(150, 250,Image.SCALE_SMOOTH));
					label.setIcon(icon);
					
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				
			});
		
	}
	private void loadBookshelf()
	{
		mainFrame.fillBookShelf(game.getCurrentPlayerBookShelf(), 6, 5);
	}
	private void loadPersonalGoalCard()
	{
		PersonalGoalCard personalGoal = game.currentPlayer().getPersonalGoalCard();	
		//ImageIcon tempIcon =new ImageIcon(personalGoal.getPath());
		//ImageIcon icon= new ImageIcon(tempIcon.getImage().getScaledInstance(150, 250,Image.SCALE_SMOOTH));
		//mainFrame.getPersonalGoalCardLabel().setIcon(icon);
	}
	private void loadCommonGoalCards()
	{
		CommonGoalCard commonGoal1 = game.getCommonGoal1();
		ImageIcon tempIcon1 =new ImageIcon(commonGoal1.getPath()); //metodo da creare in commongoal card
		ImageIcon icon1= new ImageIcon(tempIcon1.getImage().getScaledInstance(170, 120,Image.SCALE_SMOOTH));
		mainFrame.getCommonGoalCard1Label().setIcon(icon1);
		CommonGoalCard commonGoal2 = game.getCommonGoal2();
		ImageIcon tempIcon2 =new ImageIcon(commonGoal2.getPath()); //metodo da creare in commongoal card
		ImageIcon icon2= new ImageIcon(tempIcon2.getImage().getScaledInstance(170, 120,Image.SCALE_SMOOTH));
		mainFrame.getCommonGoalCard2Label().setIcon(icon2);
	}
	private void deselectAllSlot()
	{
		for(Entry<String, JLabel> set : mainFrame.getMapBookShelfTileLabel().entrySet())
		{
			JLabel label = set.getValue();
			label.setBorder(new LineBorder(new Color(101,67,53), 3));	
		}
	}
	private void selectAllFreeSlot(int column,int freeSlot,Color color)
	{	
		for(int i = 0; i < freeSlot; i++)
		{
			mainFrame.getMapBookShelfTileLabel().get(i+"_"+column).setBorder(new LineBorder(color,3));
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
	private void assignQuitGameButtonController()
	{
		mainFrame.getQuitGameButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame confirmFrame= new JFrame("");
				if(JOptionPane.showConfirmDialog(confirmFrame, "Do you want to quit the game?","",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
	}
	private void createGameOverPanel() {
		mainFrame.createGameOverPanel();
		assignQuitGameOverButtonController();
		assignNewGameButtonController();
		assignWinner();
		assignPlayersList();
		mainFrame.getQuitGameButton().setEnabled(false);
	}
	private void assignWinner() {
		mainFrame.getGameOverPanel().getWinnerNameLabel().setText(game.getWinner().getName());
	}
	private void assignPlayersList() { 
		for(int i=0; i<game.getListPlayer().size();i++) {
			JLabel playerLabel=mainFrame.getGameOverPanel().getPlayersLabels().get(i);
			String playerName=game.getListPlayer().get(i).getName();
			int points=game.getListPlayer().get(i).getPoints();
			playerLabel.setText("Player"+ (i+1)+ ": "+playerName+" Points: "+points);
		}
	}
	
	private void assignQuitGameOverButtonController()
	{
		mainFrame.getGameOverPanel().getQuitGameButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame confirmFrame= new JFrame("");
				confirmFrame.setAlwaysOnTop(true);
				if(JOptionPane.showConfirmDialog(confirmFrame, "Do you want to quit the game?","",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		
	}
	private void assignNewGameButtonController()
	{
		mainFrame.getGameOverPanel().getNewGameButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//mainFrame.getGameOverPanel().setVisible(false);
				//mainFrame.remove(mainFrame.getGameOverPanel());
				mainFrame.dispose();
				mainFrame.getGameOverPanel().dispose();
				mainFrame.getGlassPane().setVisible(false);
				Game.setState(GameState.NEW_GAME);//////////////////
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {	
								Game game=new Game();
								SetGameFrame setGameFrame = new SetGameFrame();
								SetGameController setGameController = new SetGameController(setGameFrame,game);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}
	private void assignFirstPlayerTokenLabel() {
		if(game.currentPlayer().isFirstPlayer()) {
		mainFrame.getFirstPlayerTokenLabel().setVisible(true);		
		}
		else {
			mainFrame.getFirstPlayerTokenLabel().setVisible(false);
		}
	}
}
