package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class SetGameFrame extends JFrame {

	private JPanel contentPane;
	private JButton startGameButton;
	private JComboBox nPlayersComboBox;
	private JTextField player1TextField;
	private JTextField player2TextField;
	private JTextField player3TextField;
	private JTextField player4TextField;
	private JLabel lblNewLabel;


	/**
	 * Create the frame.
	 */
	public SetGameFrame() {
		setTitle("My Shelfie - Set Players");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\resources\\Assets\\PublisherMaterial\\Icon 50x50px.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, 450, 550);
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		startGameButton = new JButton("START");
		startGameButton.setBounds(163, 426, 114, 35);
		contentPane.add(startGameButton);
		
		nPlayersComboBox = new JComboBox();
		nPlayersComboBox.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		nPlayersComboBox.setBounds(192, 105, 159, 26);
		contentPane.add(nPlayersComboBox);
		
		JLabel numberOfPlayersLabel = new JLabel("Number Of Players");
		numberOfPlayersLabel.setBounds(62, 112, 159, 13);
		contentPane.add(numberOfPlayersLabel);
		
		JLabel player1Label = new JLabel("Player 1");
		player1Label.setBounds(62, 169, 159, 13);
		contentPane.add(player1Label);
		
		player1TextField = new JTextField();
		player1TextField.setToolTipText("Enter player1' name");
		player1TextField.setBounds(192, 163, 159, 26);
		contentPane.add(player1TextField);
		player1TextField.setColumns(10);
		
		player2TextField = new JTextField();
		player2TextField.setToolTipText("Enter player2' name");
		player2TextField.setColumns(10);
		player2TextField.setBounds(192, 223, 159, 26);
		contentPane.add(player2TextField);
		
		JLabel player2Label = new JLabel("Player 2");
		player2Label.setBounds(62, 229, 159, 13);
		contentPane.add(player2Label);
		
		player3TextField = new JTextField();
		player3TextField.setEditable(false);
		player3TextField.setToolTipText("Enter player3' name");
		player3TextField.setColumns(10);
		player3TextField.setBounds(192, 285, 159, 26);
		contentPane.add(player3TextField);
		
		JLabel player3Label = new JLabel("Player 3");
		player3Label.setBounds(62, 291, 159, 13);
		contentPane.add(player3Label);
		
		player4TextField = new JTextField();
		player4TextField.setEditable(false);
		player4TextField.setToolTipText("Enter player4' name");
		player4TextField.setColumns(10);
		player4TextField.setBounds(192, 345, 159, 26);
		contentPane.add(player4TextField);
		
		JLabel player4Label = new JLabel("Player 4");
		player4Label.setBounds(62, 351, 159, 13);
		contentPane.add(player4Label);
		
		lblNewLabel = new JLabel("SET PLAYERS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(163, 34, 114, 35);
		contentPane.add(lblNewLabel);
	}

	public JButton getStartGameButton() {
		return startGameButton;
	}

	public JComboBox getNPlayersComboBox() {
		return nPlayersComboBox;
	}

	public JTextField getPlayer1TextField() {
		return player1TextField;
	}

	public JTextField getPlayer2TextField() {
		return player2TextField;
	}

	public JTextField getPlayer3TextField() {
		return player3TextField;
	}

	public JTextField getPlayer4TextField() {
		return player4TextField;
	}
}
