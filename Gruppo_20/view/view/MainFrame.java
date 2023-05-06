package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ItemTile;
import model.Slot;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	private JPanel contentPane;//
	private JLabel background;
	private JLabel itemTileLabel;
	private JButton removeTileButton;
	private List<JLabel> listTileLabel;

	

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
		background.setLayout(new GridLayout(9, 9, 0, 0));
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
		
		

	}
	
	public void fillLeavingRoomBoard(Slot[][] matrGrid)
	{
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
					icon = new ImageIcon(tempIcon.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH));
					itemTileLabel.setName(String.valueOf(itemTile.getId()));
					itemTileLabel.setIcon(icon);
					itemTileLabel.setText("");
				
					background.add(itemTileLabel);
					itemTileLabel.setVisible(true);
				
				}
				else
				{
					itemTileLabel = new JLabel("New label");
					background.add(itemTileLabel);
					itemTileLabel.setName(String.valueOf(-1));
					itemTileLabel.setVisible(false);
				}
				
				listTileLabel.add(itemTileLabel);		
			}
	
		}
		//repaint();
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
}
