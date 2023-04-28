package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Game;
import model.ItemTile;
import model.LivingRoomBoard;
import model.Slot;
import view.MainFrame;

public class MainController {

	private Game game;
	private MainFrame mainFrame;
	
	public MainController(Game game, MainFrame mainFrame)
	{
		this.game = game;
		this.mainFrame = mainFrame;
		
		assignStartButtonController();
		
	}
	public void assignStartButtonController()
	{
		mainFrame.getStartGameButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numberOfPlayers = Integer.parseInt( mainFrame.getNPlayersComboBox().getSelectedItem().toString());
				game.start(numberOfPlayers);
				mainFrame.fillLeavingRoomBoard(game.getLivingRoomBoard().getMatrGrid());
			}
		} );
	}

}
