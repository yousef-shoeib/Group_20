package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class SetGameFrame extends JFrame {

	private JPanel contentPane;
	private JButton startGameButton;
	private JComboBox nPlayersComboBox;


	/**
	 * Create the frame.
	 */
	public SetGameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		startGameButton = new JButton("Start");
		startGameButton.setBounds(179, 183, 85, 21);
		contentPane.add(startGameButton);
		
		nPlayersComboBox = new JComboBox();
		nPlayersComboBox.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		nPlayersComboBox.setBounds(57, 40, 101, 26);
		contentPane.add(nPlayersComboBox);
	}

	public JButton getStartGameButton() {
		return startGameButton;
	}

	public JComboBox getNPlayersComboBox() {
		return nPlayersComboBox;
	}
}
