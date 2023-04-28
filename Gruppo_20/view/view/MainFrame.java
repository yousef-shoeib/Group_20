package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox nPlayersComboBox;
	private JButton startGameButton;
	private JPanel panel;

	

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
		
		nPlayersComboBox = new JComboBox();
		nPlayersComboBox.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		nPlayersComboBox.setBounds(34, 41, 101, 26);
		contentPane.add(nPlayersComboBox);
		
		startGameButton = new JButton("Start");
		startGameButton.setBounds(34, 85, 85, 21);
		contentPane.add(startGameButton);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		contentPane.setLayout(null);		
		contentPane.add(panel);
		int x = (getWidth()/2)-350;
		panel.setBounds(x, 30, 700, 700);

	}
	
	public void fillLeavingRoomBoard(Slot[][] matrGrid)
	{
		for(int x = 0; x < 9; x++)
		{			
			for(int y = 0; y < 9; y++)
			{
				ItemTile itemTile = null;
				JLabel lblNewLabel =null;
				ImageIcon tempIcon =null;
				ImageIcon icon=null;
				if(matrGrid[x][y].State())
				{	
					itemTile = matrGrid[x][y].getItemTile();
					lblNewLabel = new JLabel("New label");
					tempIcon = new ImageIcon(".\\Gruppo_20\\Assets\\itemTiles\\"+ itemTile.getPathImg()+".png");
					icon = new ImageIcon(tempIcon.getImage().getScaledInstance(70, 70, 70));
					lblNewLabel.setName("lb"+itemTile.getId());
					lblNewLabel.setIcon(icon);
					lblNewLabel.setText("");
				
					panel.add(lblNewLabel);
					lblNewLabel.setVisible(true);
				
				}
				else
				{
					lblNewLabel = new JLabel("New label");
					tempIcon = new ImageIcon(".\\Gruppo_20\\Assets\\itemTiles\\vuoto.jpg");
					icon = new ImageIcon(tempIcon.getImage().getScaledInstance(70, 70, 70));
					lblNewLabel.setName("lbNull"+y);
					//gestire opacita casella
					lblNewLabel.setIcon(icon);
					lblNewLabel.setText("");
					
					panel.add(lblNewLabel);
					lblNewLabel.setVisible(true);
				}
								

						
			}
	
		}
		//repaint();
	}
	
	public JComboBox getNPlayersComboBox() {
		return nPlayersComboBox;
	}



	public JButton getStartGameButton() {
		return startGameButton;
	}}

