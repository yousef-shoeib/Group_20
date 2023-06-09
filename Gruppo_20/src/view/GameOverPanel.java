package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * pannello di fine partita con punti dei vari giocatori e il vincitore
 * @author youse
 *
 */
public class GameOverPanel extends JDialog {

	private JLabel titleLabel;
	private JPanel buttonsPanel;
	private JButton newGameButton;
	private JButton quitGameButton;
	private JPanel panel;
	private JLabel wonLabel;
	private JLabel playerNameLabel_1;
	private JLabel playerNameLabel_2;
	private JLabel playerNameLabel_3;
	private JLabel playerNameLabel_4;
	private JLabel winnerNameLabel;
	private List<JLabel> playersLabels;
	
	
	public GameOverPanel() {
		setUndecorated(true);
		setBackground(Color.DARK_GRAY);
		playersLabels=new ArrayList<>();
		//setBorder(BorderFactory.createEtchedBorder(500,Color.BLACK, Color.BLACK));
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setBackground(Color.DARK_GRAY);
		titleLabel = new JLabel("Game-Over");
		titleLabel.setForeground(Color.RED);
		
		titleLabel.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(titleLabel,BorderLayout.NORTH);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setBackground(Color.DARK_GRAY);
		buttonsPanel.setPreferredSize(new Dimension(150,40));
		getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		newGameButton = new JButton("New Game");
		newGameButton.setFocusable(false);
		newGameButton.setForeground(Color.WHITE);
		newGameButton.setBackground(Color.DARK_GRAY);
		newGameButton.setBorder(new LineBorder((Color.white),1));
		buttonsPanel.add(newGameButton);
		
		quitGameButton = new JButton("Quit Game");
		quitGameButton.setFocusable(false);
		quitGameButton.setForeground(Color.WHITE);
		quitGameButton.setBackground(Color.DARK_GRAY);
		quitGameButton.setBorder(new LineBorder((Color.white),1));
		buttonsPanel.add(quitGameButton);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		winnerNameLabel = new JLabel("");
		winnerNameLabel.setForeground(Color.WHITE);
		winnerNameLabel.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		winnerNameLabel.setBounds(205, 11, 291, 43);
		
		wonLabel = new JLabel("The Winner Is: ");
		wonLabel.setForeground(Color.WHITE);
		wonLabel.setBounds(22, 11, 177, 50);
		wonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wonLabel.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		
		playerNameLabel_1 = new JLabel("");
		playerNameLabel_1.setForeground(Color.WHITE);
		playerNameLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 12));
		playerNameLabel_1.setBounds(22, 79, 474, 36);
		playersLabels.add(playerNameLabel_1);
		playerNameLabel_2 = new JLabel("");
		playerNameLabel_2.setForeground(Color.WHITE);
		playerNameLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 12));
		playerNameLabel_2.setBounds(22, 133, 474, 36);
		playersLabels.add(playerNameLabel_2);
		playerNameLabel_3 = new JLabel("");
		playerNameLabel_3.setForeground(Color.WHITE);
		playerNameLabel_3.setFont(new Font("Snap ITC", Font.PLAIN, 12));
		playerNameLabel_3.setBounds(22, 187, 474, 36);
		playersLabels.add(playerNameLabel_3);
		playerNameLabel_4 = new JLabel("");
		playerNameLabel_4.setForeground(Color.WHITE);
		playerNameLabel_4.setFont(new Font("Snap ITC", Font.PLAIN, 12));
		playerNameLabel_4.setBounds(22, 241, 474, 36);
		playersLabels.add(playerNameLabel_4);
		panel.setLayout(null);
		panel.add(wonLabel);
		panel.add(winnerNameLabel);
		panel.add(playerNameLabel_1);
		panel.add(playerNameLabel_2);
		panel.add(playerNameLabel_3);
		panel.add(playerNameLabel_4);
		
	
	}
	
	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public JPanel getButtonsPanel() {
		return buttonsPanel;
	}

	public JButton getNewGameButton() {
		return newGameButton;
	}

	public JButton getQuitGameButton() {
		return quitGameButton;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JLabel getWonLabel() {
		return wonLabel;
	}

	public JLabel getPlayerNameLabel_1() {
		return playerNameLabel_1;
	}

	public JLabel getPlayerNameLabel_2() {
		return playerNameLabel_2;
	}

	public JLabel getPlayerNameLabel_3() {
		return playerNameLabel_3;
	}

	public JLabel getPlayerNameLabel_4() {
		return playerNameLabel_4;
	}
	public JLabel getWinnerNameLabel() {
		return winnerNameLabel;
	}
	
	public List<JLabel> getPlayersLabels() {
		return playersLabels;
	}
}
