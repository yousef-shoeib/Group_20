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
		
		assignStartButtonController();
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
