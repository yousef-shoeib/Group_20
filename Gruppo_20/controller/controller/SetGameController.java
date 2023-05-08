package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Game;
import view.MainFrame;
import view.SetGameFrame;

public class SetGameController {
	
	private MainFrame mainFrame;
	private MainController mainController;
	private SetGameFrame setGameFrame;
	private Game game;
	
	public SetGameController(SetGameFrame setGameFrame,MainFrame mainFrame,Game game, MainController mainController)
	{
		this.game = game;
		this.setGameFrame = setGameFrame;
		this.mainFrame = mainFrame;
		this.mainController = mainController;

		assignNPlayersComboBoxController();
		assignStartButtonController();
	}
	private void assignNPlayersComboBoxController()
	{
		setGameFrame.getNPlayersComboBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			int choice = Integer.parseInt((String) setGameFrame.getNPlayersComboBox().getSelectedItem());
				
				if(choice == 2) {
					setGameFrame.getPlayer1TextField().setEditable(true);
					setGameFrame.getPlayer2TextField().setEditable(true);
					setGameFrame.getPlayer3TextField().setEditable(false);
					setGameFrame.getPlayer4TextField().setEditable(false);
					setGameFrame.getPlayer3TextField().setText("");
					setGameFrame.getPlayer4TextField().setText("");
				}
				if(choice == 3) {
						setGameFrame.getPlayer3TextField().setEditable(true);
						setGameFrame.getPlayer4TextField().setEditable(false);
						setGameFrame.getPlayer4TextField().setText("");
				}
				if(choice == 4) {
						setGameFrame.getPlayer3TextField().setEditable(true);
						setGameFrame.getPlayer4TextField().setEditable(true);
				}
			}
		});
	}
	private void assignStartButtonController()
	{
		setGameFrame.getStartGameButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numberOfPlayers = Integer.parseInt( setGameFrame.getNPlayersComboBox().getSelectedItem().toString());
				game.start(numberOfPlayers);
				mainFrame = new MainFrame();
				mainFrame.fillLeavingRoomBoard(game.getLivingRoomBoard().getMatrGrid());
				mainController = new MainController(game,mainFrame);
				
				setGameFrame.setVisible(false);
			}
		} );
	}
}
