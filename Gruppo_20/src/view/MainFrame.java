package view;

import java.awt.Color;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.ItemTile;
import model.LivingRoomBoard;
import model.Slot;
import utility.ConfigPath;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Font;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel livingPane;
	private JPanel bookShelfPane;
	private JPanel commonGoalCardsPane;
	private JPanel playerInfoPane;
	private JLabel background;
	private JLabel bookShelfLabel;
	private JLabel personalGoalCardLabel;
	private JLabel commonGoalCard1Label;
	private JLabel commonGoalCard2Label;
	private JLabel boxGettedTileLabel;
	private JLabel playerNameLabel;
	private JLabel playerPointsLabel;
	private JButton takeTileButton;
	private JButton endRoundButton;
	private JButton addTileButton;
	private Map<String,JLabel> mapLivingTileLabel;
	private Map<String,JLabel> mapBookShelfTileLabel;
	private Map<String,JLabel> boxedGettedTileLabel;
	

	/**
	 * Create the frame.
	 */
	public MainFrame(Slot[][] matrGrindLiving, int rows, int columns) {
		//getting screen resolution
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		
		//JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, width, height); //Set JFrame Size
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("My Shelfie");
		ImageIcon frameIcon= new ImageIcon("./resources/Assets/PublisherMaterial/Icon 50x50px.png");
		setIconImage(frameIcon.getImage());
		setVisible(true);
		
		//Master Panel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setBounds(0, 0, 1500, 920);
		contentPane.setLayout(null);
		
		//LivingRoomBoard Panel
		livingPane = new JPanel();
		livingPane.setBorder(new LineBorder(new Color(0,0,0), 3));
		livingPane.setBounds(10, 0, 850, 780);
		livingPane.setLayout(null);
		contentPane.add(livingPane);
		
		//BookShelf Panel
		bookShelfPane = new JPanel();
		bookShelfPane.setBorder(new LineBorder(new Color(0,0,0), 3));
		bookShelfPane.setBounds(850, 180, 680, 600);
		bookShelfPane.setLayout(null);
		contentPane.add(bookShelfPane);
		
		//CommonGoalCards Panel
		commonGoalCardsPane = new JPanel();
		commonGoalCardsPane.setBorder(new LineBorder(new Color(0,0,0), 3));
		commonGoalCardsPane.setBounds(850,0, 680, 180);
		commonGoalCardsPane.setLayout(null);
		contentPane.add(commonGoalCardsPane);
		
		//LivingRoomBoard Label
		background = new JLabel();		
		//int x = (getWidth()/2)-350;
		background.setBounds(20, 50, 700, 700);
		background.setLayout(null);
		ImageIcon tempBackground =new ImageIcon(ConfigPath.getLivingRoomBoardPath());
		ImageIcon backgroundIcon=new ImageIcon(tempBackground.getImage().getScaledInstance(700, 700,Image.SCALE_SMOOTH));
		background.setIcon(backgroundIcon);
		livingPane.add(background);
		
		
		//boxGettedTileLabel
		boxGettedTileLabel = new JLabel("");		
		boxGettedTileLabel.setBounds(743, 250, 77, 228);
		boxGettedTileLabel.setBorder(new LineBorder(new Color(0,0,0), 3));
		boxGettedTileLabel.setLayout(null);
		boxGettedTileLabel.setVisible(true);
		livingPane.add(boxGettedTileLabel);
				
		//bookShelfLabel
		bookShelfLabel = new JLabel();	
		bookShelfLabel.setBounds(20, 165, 405, 416);
		bookShelfLabel.setLayout(null);
		ImageIcon tempbookShelfBackGround =new ImageIcon(ConfigPath.getBookshelfPath());
		ImageIcon tempbookShelfBackGroundIcon=new ImageIcon(tempbookShelfBackGround.getImage().getScaledInstance(405, 416,Image.SCALE_SMOOTH));
		bookShelfLabel.setIcon(tempbookShelfBackGroundIcon);
		bookShelfPane.add(bookShelfLabel);
		
		//personalGoalCardLabel
		personalGoalCardLabel = new JLabel();	
		personalGoalCardLabel.setBounds(470, 200, 150, 250);
		personalGoalCardLabel.setLayout(null);
		ImageIcon tempPersonalGoalCard =new ImageIcon("./resources/Assets/personalGoalCards/back.jpg");
		ImageIcon tempPersonalGoalCardIcon=new ImageIcon(tempPersonalGoalCard.getImage().getScaledInstance(150, 250,Image.SCALE_SMOOTH));
		personalGoalCardLabel.setIcon(tempPersonalGoalCardIcon);
		bookShelfPane.add(personalGoalCardLabel);
		
		//commonGoalCard1Label
		commonGoalCard1Label = new JLabel();	
		commonGoalCard1Label.setBounds(70, 40, 170, 120);
		commonGoalCard1Label.setLayout(null);
		ImageIcon tempCommonGoalCard1 =new ImageIcon(".\\resources\\Assets\\commonGoalCards\\1.jpg");
		ImageIcon tempCommonGoalCard1Icon=new ImageIcon(tempCommonGoalCard1.getImage().getScaledInstance(170, 120,Image.SCALE_SMOOTH));
		commonGoalCard1Label.setIcon(tempCommonGoalCard1Icon);
		commonGoalCardsPane.add(commonGoalCard1Label);
		
		//commonGoalCard2Label
		commonGoalCard2Label = new JLabel();	
		commonGoalCard2Label.setBounds(300, 40, 170, 120);
		commonGoalCard2Label.setLayout(null);
		ImageIcon tempCommonGoalCard2 =new ImageIcon(".\\resources\\Assets\\commonGoalCards\\2.jpg");
		ImageIcon tempCommonGoalCard2Icon=new ImageIcon(tempCommonGoalCard2.getImage().getScaledInstance(170, 120,Image.SCALE_SMOOTH));
		commonGoalCard2Label.setIcon(tempCommonGoalCard2Icon);
		commonGoalCardsPane.add(commonGoalCard2Label);
		
		//playerInfoPane
		playerInfoPane = new JPanel();		
		playerInfoPane.setBounds(100, 50, 250, 100);
		playerInfoPane.setBorder(new LineBorder(new Color(0,0,0), 3));
		playerInfoPane.setBackground(new Color(0, 127, 255));
		playerInfoPane.setLayout(null);
		playerInfoPane.setVisible(true);
		bookShelfPane.add(playerInfoPane);
		
		//Player Name Label
		playerNameLabel = new JLabel("");	
		playerNameLabel.setBounds(20, 0, 250, 50);
		playerNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		playerNameLabel.setLayout(null);
		playerInfoPane.add(playerNameLabel);
		
		//Player Points Label
		playerPointsLabel = new JLabel("");	
		playerPointsLabel.setBounds(20, 40, 250, 50);
		playerPointsLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		playerPointsLabel.setLayout(null);
		playerInfoPane.add(playerPointsLabel);
		
		takeTileButton = new JButton("Take");
		takeTileButton.setBounds(743, 200, 77, 41);
		takeTileButton.setEnabled(false);///
		livingPane.add(takeTileButton);
		
		addTileButton = new JButton("Add");
		addTileButton.setBounds(743, 490, 77, 41);
		addTileButton.setEnabled(false);///
		livingPane.add(addTileButton);
		
		endRoundButton = new JButton("End");
		endRoundButton.setBounds(743, 540, 77, 41);
		endRoundButton.setEnabled(false);
		livingPane.add(endRoundButton);
		
		mapLivingTileLabel = new HashMap<>();
		mapBookShelfTileLabel = new HashMap<>();
		boxedGettedTileLabel = new HashMap<>();
		
		createLeavingTilesLabels(matrGrindLiving,rows,columns);
		createBookShelf();
		createBoxedLabel();
	}
	
	public JLabel getPersonalGoalCardLabel() {
		return personalGoalCardLabel;
	}

	//Create boxedGettedTileLabel
	private void createBoxedLabel()
	{
		int y = 151;
		for(int i = 0; i < 3; i++)
		{
			JLabel label = new JLabel("");
			label.setName("boxedGettedTileLabel_"+i);
			label.setBounds(1, y, 75, 75);
			label.setBorder(new LineBorder(new Color(255,255,255), 3));
			label.setLayout(null);
			label.setVisible(false);
			boxGettedTileLabel.add(label);
			boxedGettedTileLabel.put(label.getName(), label);
			y-= 75;
		}
	}
	//Create LivingRoomBoard Tiles Labels
	private void createLeavingTilesLabels(Slot[][] matrGrindLiving, int rows, int columns)
	{
		int first = 34;
		int second = 35;
		
		for(int x = 0; x < rows; x++)
		{			
			for(int y = 0; y < columns; y++)
			{
				if(matrGrindLiving[x][y].State())
				{	
					ItemTile itemTile = matrGrindLiving[x][y].getItemTile();
					JLabel itemTileLabel = new JLabel("");
					ImageIcon tempIcon = new ImageIcon(ConfigPath.getItemTilePath()+ itemTile.getPathImg()+".png");
					ImageIcon icon = new ImageIcon(tempIcon.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH));
					itemTileLabel.setName(x+"_"+y);
					itemTileLabel.setIcon(icon);
					itemTileLabel.setBounds(first, second, 65, 65);
					itemTileLabel.setBorder(new LineBorder(new Color(255,255,255), 3));
					itemTileLabel.setVisible(true);
					background.add(itemTileLabel);
					mapLivingTileLabel.put(itemTileLabel.getName(),itemTileLabel);
					first+= 70;
				}
				else {
					first+= 70;
				}
			}
			
			first = 34;
			if(x>2) {
				second = second + 71;
			}
			else {
				second = second + 70;
			}
		}
	}
	//Fill LivingRoomBoard Tiles Labels
	public void fillLeavingRoomBoard(Slot[][] matrGrindLiving, int rows, int columns)
	{
		for(int x = 0; x < rows; x++)
		{			
			for(int y = 0; y < columns; y++)
			{
				if(matrGrindLiving[x][y].State() && !matrGrindLiving[x][y].isEmpty())
				{	
					ItemTile itemTile = matrGrindLiving[x][y].getItemTile();
					ImageIcon tempIcon = new ImageIcon(ConfigPath.getItemTilePath()+ itemTile.getPathImg()+".png");
					ImageIcon icon = new ImageIcon(tempIcon.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH));
					mapLivingTileLabel.get(x+"_"+y).setBorder(new LineBorder(new Color(255,255,255), 3));
					mapLivingTileLabel.get(x+"_"+y).setIcon(icon);
					mapLivingTileLabel.get(x+"_"+y).setVisible(true);
				}
			}
		}
	}
	//Create BookShelf Label
	private void createBookShelf()
	{
		int first = 49;
		int second = 28;
		JLabel bookShelfSlotLabel = null;
		
		for(int row = 0; row < 6; row++)
		{			
			for(int column = 0; column < 5; column++)
			{	
				bookShelfSlotLabel = new JLabel("");
				bookShelfSlotLabel.setName(row+"_"+column); 
				bookShelfSlotLabel.setBounds(first, second, 50, 50);
				bookShelfSlotLabel.setBorder(new LineBorder(new Color(101,67,53), 3));
				bookShelfSlotLabel.setVisible(true);
				bookShelfLabel.add(bookShelfSlotLabel);
	
				mapBookShelfTileLabel.put(bookShelfSlotLabel.getName(),bookShelfSlotLabel);	
				
				first+= 65;
			}
			
			first = 49;
			if(row > 1){
				second = second + 57;
			}
			else{
				second = second + 58;
			}
		}
	}
	//Fill BookShelf Label
	public void fillBookShelf(Slot[][] matrGridBookShelf, int rows, int columns)
	{
		JLabel bookShelfSlotLabel = null;
		
		for(int row = 0; row < rows; row++)
		{			
			for(int column = 0; column < columns; column++)
			{	
				bookShelfSlotLabel = mapBookShelfTileLabel.get(row+"_"+column);
				
				if(!matrGridBookShelf[row][column].isEmpty())
				{
					ItemTile itemTile = matrGridBookShelf[row][column].getItemTile();
					ImageIcon tempIcon =new ImageIcon(ConfigPath.getItemTilePath()+itemTile.getPathImg()+".png");
					ImageIcon icon= new ImageIcon(tempIcon.getImage().getScaledInstance(55,55, Image.SCALE_SMOOTH));
					bookShelfSlotLabel.setIcon(icon);
				}
				else{
					bookShelfSlotLabel.setIcon(null);
				}
				
				bookShelfSlotLabel.setVisible(true);
			}
		}
	}
	public JButton getTakeTileButton() {
		return takeTileButton;
	}

	public Map<String,JLabel> getMapBookShelfTileLabel() {
		return mapBookShelfTileLabel;
	}

	public Map<String, JLabel> getBoxedGettedTileLabel() {
		return boxedGettedTileLabel;
	}

	public JButton getAddTileButton() {
		return addTileButton;
	}

	public JButton getEndRoundButton() {
		return endRoundButton;
	}

	public JLabel getPlayerNameLabel() {
		return playerNameLabel;
	}

	public Map<String, JLabel> getMapLivingTileLabel() {
		return mapLivingTileLabel;
	}

	public JLabel getPlayerPointsLabel() {
		return playerPointsLabel;
	}
}
