package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.ItemTile;
import model.Slot;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;

public class MainFrame extends JFrame {

	private JPanel contentPane;//
	private JLabel background;
	private JLabel itemTileLabel;
	private JButton removeTileButton;
	private List<JLabel> listTileLabel;
	private JButton resetTileButton;

	

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 40, 1280, 780); //Set JFrame Size
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		background = new JLabel();
		
		background.setBackground(new Color(255, 128, 0));
		contentPane.setLayout(null);		
		contentPane.add(background);
		int x = (getWidth()/2)-350;
		background.setBounds(x, 30, 700, 700);
		//background.setLayout(new GridLayout(9, 9, 0, 0));
		background.setLayout(null);
		/////////////////////////
		ImageIcon tempBackground =new ImageIcon("./resources/Assets/boards/livingroom.png");
		//ImageIcon tempBackground =new ImageIcon(".\\Gruppo_20\\resources\\Assets\\boards\\livingroom.png");
		ImageIcon backgroundIcon=new ImageIcon(tempBackground.getImage().getScaledInstance(700, 700,Image.SCALE_SMOOTH));
		background.setIcon(backgroundIcon);
		//////////////////////
		listTileLabel = new ArrayList<>();
		
		removeTileButton = new JButton("Take");
		removeTileButton.setBounds(67, 30, 77, 41);
		contentPane.add(removeTileButton);
		
		resetTileButton = new JButton("Reset");
		resetTileButton.setBounds(67, 93, 77, 41);
		contentPane.add(resetTileButton);
		
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
					tempIcon = new ImageIcon("./resources/Assets/itemTiles/"+ itemTile.getPathImg()+".png");
					//tempIcon = new ImageIcon("./Gruppo_20/resources/Assets/itemTiles/"+ itemTile.getPathImg()+".png");
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
