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
import java.awt.Insets;

import javax.swing.border.LineBorder;
import java.awt.Color;

public class SetGameFrame extends JFrame {

	private JPanel contentPane;
	private JButton startGameButton;
	private JComboBox nPlayersComboBox;
	private JTextField playerTextField;
	private JLabel lblNewLabel;
	private JButton addPlayerButton;
	private JLabel playerLabel;


	/**
	 * Create the frame.
	 */
	public SetGameFrame() {
		setBackground(Color.DARK_GRAY);
		setTitle("My Shelfie - Set Players");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\resources\\Assets\\PublisherMaterial\\Icon 50x50px.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, 550, 350);
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		startGameButton = new JButton("START");
		startGameButton.setEnabled(false);
		startGameButton.setBounds(207, 247, 114, 35);
		contentPane.add(startGameButton);
		
		nPlayersComboBox = new JComboBox();
		nPlayersComboBox.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		nPlayersComboBox.setBounds(192, 105, 159, 26);
		contentPane.add(nPlayersComboBox);
		
		JLabel numberOfPlayersLabel = new JLabel("Number Of Players");
		numberOfPlayersLabel.setForeground(Color.WHITE);
		numberOfPlayersLabel.setBounds(62, 112, 159, 13);
		contentPane.add(numberOfPlayersLabel);
		
		playerLabel = new JLabel("Player 1");
		playerLabel.setForeground(Color.WHITE);
		playerLabel.setBounds(62, 169, 92, 13);
		contentPane.add(playerLabel);
		
		playerTextField = new JTextField();
		playerTextField.setToolTipText("Enter player' name");
		playerTextField.setBounds(192, 163, 159, 26);
		playerTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		contentPane.add(playerTextField);
		playerTextField.setColumns(10);
		
		lblNewLabel = new JLabel("SET PLAYERS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(207, 34, 114, 35);
		contentPane.add(lblNewLabel);
		
		addPlayerButton = new JButton("Add Player");
		addPlayerButton.setForeground(Color.WHITE);
		addPlayerButton.setEnabled(false);
		addPlayerButton.setBounds(384, 158, 100, 35);
		addPlayerButton.setBackground(Color.DARK_GRAY);
		//addPlayerButton.setBorderPainted(false);
		addPlayerButton.setBorder(new LineBorder((Color.white),1));
		contentPane.add(addPlayerButton);
	}

	public JButton getStartGameButton() {
		return startGameButton;
	}

	public JComboBox getNPlayersComboBox() {
		return nPlayersComboBox;
	}

	public JTextField getPlayer1TextField() {
		return playerTextField;
	}

	public JButton getAddPlayerButton() {
		return addPlayerButton;
	}

	public JLabel getPlayerLabel() {
		return playerLabel;
	}
}
