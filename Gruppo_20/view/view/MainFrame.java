package view;

import java.awt.Color;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

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
	private JLabel background;
	private JLabel bookShelfLabel;
	private JLabel personalGoalCardLabel;
	private JLabel commonGoalCard1Label;
	private JLabel commonGoalCard2Label;
	private JLabel itemTileLabel;
	private JLabel bookShelfSlotLabel;
	private JButton removeTileButton;
	private List<JLabel> listTileLabel;
	private JButton resetTileButton;

	

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 40, 1280, 780); //Set JFrame Size
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBounds(0, 0, 1500, 920);
		contentPane.setLayout(null);
		
		//LivingRoomBoard
		background = new JLabel();
		contentPane.setLayout(null);		
		contentPane.add(background);
		//int x = (getWidth()/2)-350;
		background.setBounds(20, 50, 700, 700);
		background.setLayout(null);

		ImageIcon tempBackground =new ImageIcon(ConfigPath.getLivingRoomBoardPath());
		ImageIcon backgroundIcon=new ImageIcon(tempBackground.getImage().getScaledInstance(700, 700,Image.SCALE_SMOOTH));
		background.setIcon(backgroundIcon);

		//Bookshelf
		bookShelfLabel = new JLabel();	
		bookShelfLabel.setBounds(850, 305, 455, 466);
		bookShelfLabel.setLayout(null);
		
		ImageIcon tempbookShelfBackGround =new ImageIcon(ConfigPath.getBookshelfPath());
		ImageIcon tempbookShelfBackGroundIcon=new ImageIcon(tempbookShelfBackGround.getImage().getScaledInstance(455, 465,Image.SCALE_SMOOTH));
		bookShelfLabel.setIcon(tempbookShelfBackGroundIcon);
		contentPane.add(bookShelfLabel);
		
		//Bookshelf
		personalGoalCardLabel = new JLabel();	
		personalGoalCardLabel.setBounds(1350, 400, 150, 250);
		personalGoalCardLabel.setLayout(null);
		//ImageIcon tempBackground =new ImageIcon("./resources/Assets/personalGoalCards/Personal_Goals1.png");
		ImageIcon tempPersonalGoalCard =new ImageIcon(".\\Gruppo_20\\resources\\Assets\\personalGoalCards\\Personal_Goals1.png");
		ImageIcon tempPersonalGoalCardIcon=new ImageIcon(tempPersonalGoalCard.getImage().getScaledInstance(150, 250,Image.SCALE_SMOOTH));
		personalGoalCardLabel.setIcon(tempPersonalGoalCardIcon);
		contentPane.add(personalGoalCardLabel);
		
		//Bookshelf
		commonGoalCard1Label = new JLabel();	
		commonGoalCard1Label.setBounds(850, 50, 200, 150);
		commonGoalCard1Label.setLayout(null);
		//ImageIcon tempBackground =new ImageIcon("./resources/Assets/commonGoalCards\\1.jpg");
		ImageIcon tempCommonGoalCard1 =new ImageIcon(".\\Gruppo_20\\resources\\Assets\\commonGoalCards\\1.jpg");
		ImageIcon tempCommonGoalCard1Icon=new ImageIcon(tempCommonGoalCard1.getImage().getScaledInstance(200, 150,Image.SCALE_SMOOTH));
		commonGoalCard1Label.setIcon(tempCommonGoalCard1Icon);
		contentPane.add(commonGoalCard1Label);
		
		//Bookshelf
		commonGoalCard2Label = new JLabel();	
		commonGoalCard2Label.setBounds(1150, 50, 200, 150);
		commonGoalCard2Label.setLayout(null);
		//ImageIcon tempBackground =new ImageIcon("./resources/Assets/commonGoalCards\\2.jpg");
		ImageIcon tempCommonGoalCard2 =new ImageIcon(".\\Gruppo_20\\resources\\Assets\\commonGoalCards\\2.jpg");
		ImageIcon tempCommonGoalCard2Icon=new ImageIcon(tempCommonGoalCard2.getImage().getScaledInstance(200, 150,Image.SCALE_SMOOTH));
		commonGoalCard2Label.setIcon(tempCommonGoalCard2Icon);
		contentPane.add(commonGoalCard2Label);
		
		
		removeTileButton = new JButton("Take");
		removeTileButton.setBounds(763, 65, 77, 41);
		contentPane.add(removeTileButton);
		
		resetTileButton = new JButton("Reset");
		resetTileButton.setBounds(763, 150, 77, 41);
		contentPane.add(resetTileButton);
		
		listTileLabel = new ArrayList<>();
		
		fillBookShelf();
	}
	
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
	
	public void fillBookShelf()
	{
		int first = 57;
		int second = 35;
		for(int x = 0; x < 6; x++)
		{			
			for(int y = 0; y < 5; y++)
			{	
				bookShelfSlotLabel = new JLabel("New label");
				ImageIcon tempIcon =new ImageIcon("./Gruppo_20/resources/Assets/itemTiles/Cornici1.1.png");
				ImageIcon icon= new ImageIcon(tempIcon.getImage().getScaledInstance(55,55, Image.SCALE_SMOOTH));
				//itemTileLabel.setName(String.valueOf(itemTile.getId()));
				bookShelfSlotLabel.setIcon(icon);
					//bookShelfSlotLabel.setText("");
				bookShelfSlotLabel.setBounds(first, second, 55, 55);
				bookShelfSlotLabel.setBorder(new LineBorder(new Color(101,67,53), 3));
				bookShelfLabel.add(bookShelfSlotLabel);
				bookShelfSlotLabel.setVisible(true);
					
					if(x<3)
						first+= 72;
					else
						first+= 71;
						
					//listTileLabel.add(itemTileLabel);	
			}
			
			first = 58;
			second = second + 62;
		}
	}
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
}
