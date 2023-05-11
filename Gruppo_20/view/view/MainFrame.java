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
import model.Slot;
import utility.ConfigPath;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel livingPane;
	private JPanel bookShelfPane;
	private JPanel commonGoalCardsPane;
	private JLabel background;
	private JLabel bookShelfLabel;
	private JLabel personalGoalCardLabel;
	private JLabel commonGoalCard1Label;
	private JLabel commonGoalCard2Label;
	private JLabel itemTileLabel;
	private JLabel boxGettedTileLabel;
	private JButton removeTileButton;
	private JButton addTileButton;
	private List<JLabel> listTileLabel;
	private JButton resetTileButton;
	private List<JLabel> listBookShelfTileLabel;
	private Map<String,JLabel> boxedGettedTileLabel;
	

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		
		//JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 40, 1280, 780); //Set JFrame Size
		setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		boxGettedTileLabel.setBounds(100, 10, 228, 77);
		boxGettedTileLabel.setBorder(new LineBorder(new Color(0,0,0), 3));
		boxGettedTileLabel.setLayout(null);
		boxGettedTileLabel.setVisible(true);
		bookShelfPane.add(boxGettedTileLabel);
				
		//bookShelfLabel
		bookShelfLabel = new JLabel();	
		bookShelfLabel.setBounds(20, 105, 455, 466);
		bookShelfLabel.setLayout(null);
		ImageIcon tempbookShelfBackGround =new ImageIcon(ConfigPath.getBookshelfPath());
		ImageIcon tempbookShelfBackGroundIcon=new ImageIcon(tempbookShelfBackGround.getImage().getScaledInstance(455, 465,Image.SCALE_SMOOTH));
		bookShelfLabel.setIcon(tempbookShelfBackGroundIcon);
		bookShelfPane.add(bookShelfLabel);
		
		//personalGoalCardLabel
		personalGoalCardLabel = new JLabel();	
		personalGoalCardLabel.setBounds(470, 200, 150, 250);
		personalGoalCardLabel.setLayout(null);
		//ImageIcon tempBackground =new ImageIcon("./resources/Assets/personalGoalCards/Personal_Goals1.png");
		ImageIcon tempPersonalGoalCard =new ImageIcon(".\\Gruppo_20\\resources\\Assets\\personalGoalCards\\Personal_Goals1.png");
		ImageIcon tempPersonalGoalCardIcon=new ImageIcon(tempPersonalGoalCard.getImage().getScaledInstance(150, 250,Image.SCALE_SMOOTH));
		personalGoalCardLabel.setIcon(tempPersonalGoalCardIcon);
		bookShelfPane.add(personalGoalCardLabel);
		
		//commonGoalCard1Label
		commonGoalCard1Label = new JLabel();	
		commonGoalCard1Label.setBounds(70, 40, 170, 120);
		commonGoalCard1Label.setLayout(null);
		//ImageIcon tempBackground =new ImageIcon("./resources/Assets/commonGoalCards\\1.jpg");
		ImageIcon tempCommonGoalCard1 =new ImageIcon(".\\Gruppo_20\\resources\\Assets\\commonGoalCards\\1.jpg");
		ImageIcon tempCommonGoalCard1Icon=new ImageIcon(tempCommonGoalCard1.getImage().getScaledInstance(170, 120,Image.SCALE_SMOOTH));
		commonGoalCard1Label.setIcon(tempCommonGoalCard1Icon);
		commonGoalCardsPane.add(commonGoalCard1Label);
		
		//commonGoalCard2Label
		commonGoalCard2Label = new JLabel();	
		commonGoalCard2Label.setBounds(300, 40, 170, 120);
		commonGoalCard2Label.setLayout(null);
		//ImageIcon tempBackground =new ImageIcon("./resources/Assets/commonGoalCards\\2.jpg");
		ImageIcon tempCommonGoalCard2 =new ImageIcon(".\\Gruppo_20\\resources\\Assets\\commonGoalCards\\2.jpg");
		ImageIcon tempCommonGoalCard2Icon=new ImageIcon(tempCommonGoalCard2.getImage().getScaledInstance(170, 120,Image.SCALE_SMOOTH));
		commonGoalCard2Label.setIcon(tempCommonGoalCard2Icon);
		commonGoalCardsPane.add(commonGoalCard2Label);
		
		removeTileButton = new JButton("Take");
		removeTileButton.setBounds(743, 150, 77, 41);
		livingPane.add(removeTileButton);
	
		resetTileButton = new JButton("Reset");
		resetTileButton.setBounds(743, 230, 77, 41);
		livingPane.add(resetTileButton);
		
		addTileButton = new JButton("Add");
		addTileButton.setBounds(350, 30, 77, 41);
		bookShelfPane.add(addTileButton);
		
		
		listTileLabel = new ArrayList<>();
		listBookShelfTileLabel = new ArrayList<>();
		boxedGettedTileLabel = new HashMap<>();
		
		fillBookShelf();
		createBoxedLabel();
	}
	
	//Create boxedGettedTileLabel
	private void createBoxedLabel()
	{
		int x = 1;
		for(int i = 0; i < 3; i++)
		{
			JLabel label = new JLabel("");
			label.setName("boxedGettedTileLabel"+i);
			label.setBounds(x, 1, 75, 75);
			label.setBorder(new LineBorder(new Color(255,255,255), 3));
			label.setLayout(null);
			label.setVisible(false);
			boxGettedTileLabel.add(label);
			boxedGettedTileLabel.put(label.getName(), label);
			x+= 75;
		}
	}
	//Fill LivingRoomBoard with Tiles Label
	public void fillLeavingRoomBoard(Slot[][] matrGrid)
	{
		int first = 34;
		int second = 35;
		for(int x = 0; x < 9; x++)
		{			
			for(int y = 0; y < 9; y++)
			{
				ItemTile itemTile = null;
				itemTileLabel = null;
				
				ImageIcon tempIcon =null;
				ImageIcon icon=null;
				if(matrGrid[x][y].State())
				{	
					itemTile = matrGrid[x][y].getItemTile();
					itemTileLabel = new JLabel("New label");
					tempIcon = new ImageIcon(ConfigPath.getItemTilePath()+ itemTile.getPathImg()+".png");
					icon = new ImageIcon(tempIcon.getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH));
					itemTileLabel.setName(String.valueOf(itemTile.getId()));
					itemTileLabel.setIcon(icon);
					itemTileLabel.setText("");
					itemTileLabel.setBounds(first, second, 65, 65);
					itemTileLabel.setBorder(new LineBorder(new Color(255,255,255), 3));
					first+= 70;
					background.add(itemTileLabel);
					itemTileLabel.setVisible(true);
					
					listTileLabel.add(itemTileLabel);	
				
				}
				else
				{
					first+= 70;
				}
				
			}
			
			first = 34;
			if(x>2)
				second = second + 71;
			else
				second = second + 70;
	
		}
	}
	
	//Fill BookShelf with Tiles Label
	public void fillBookShelf()
	{
		int first = 57;
		int second = 35;
		JLabel bookShelfSlotLabel = null;
		
		for(int x = 0; x < 6; x++)
		{			
			for(int y = 0; y < 5; y++)
			{	
				bookShelfSlotLabel = new JLabel("New label");
				//ImageIcon tempIcon =new ImageIcon("./Gruppo_20/resources/Assets/itemTiles/Cornici1.1.png");
				//ImageIcon icon= new ImageIcon(tempIcon.getImage().getScaledInstance(55,55, Image.SCALE_SMOOTH));
				bookShelfSlotLabel.setName(y+"_"+x); 
				//bookShelfSlotLabel.setIcon(icon);
				bookShelfSlotLabel.setText("");
				
				bookShelfSlotLabel.setBounds(first, second, 55, 55);
				bookShelfSlotLabel.setBorder(new LineBorder(new Color(101,67,53), 3));
				bookShelfSlotLabel.setVisible(true);
				
				bookShelfLabel.add(bookShelfSlotLabel);
					
					if(x<3)
						first+= 72;
					else
						first+= 71;
						
					listBookShelfTileLabel.add(bookShelfSlotLabel);	
			}
			
			first = 58;
			second = second + 62;
		}
	}
	
	//Getters
	public JLabel getItemTileLabel() {
		return itemTileLabel;
	}

	public List<JLabel> getListTileLabel() {
		return listTileLabel;
	}

	public JButton getRemoveTileButton() {
		return removeTileButton;
	}

	public JButton getResetTileButton() {
		return resetTileButton;
	}

	public List<JLabel> getListBookShelfTileLabel() {
		return listBookShelfTileLabel;
	}

	public Map<String, JLabel> getBoxedGettedTileLabel() {
		return boxedGettedTileLabel;
	}

	public JButton getAddTileButton() {
		return addTileButton;
	}
}
