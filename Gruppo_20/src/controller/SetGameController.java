package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import model.Game;
import view.MainFrame;
import view.SetGameFrame;

public class SetGameController {
	
	private MainFrame mainFrame;
	private MainController mainController;
	private SetGameFrame setGameFrame;
	private Game game;
	private List<String> namePlayers;
	
	public SetGameController(SetGameFrame setGameFrame,Game game)
	{
		this.game = game;
		this.setGameFrame = setGameFrame;
		namePlayers = new ArrayList<>();

		assignNodeFieldController();
		assignStartButtonController();
		assignAddPlayerButtonController();
	}
	
	private void assignStartButtonController()
	{
		setGameFrame.getStartGameButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int numberOfPlayers = Integer.parseInt( setGameFrame.getNPlayersComboBox().getSelectedItem().toString());
				
				
				game.start(numberOfPlayers,namePlayers);
				mainFrame = new MainFrame(game.getLivingRoomBoard().getMatrGrid(),game.getLivingRoomBoard().getRows(),game.getLivingRoomBoard().getColumns());
				mainController = new MainController(game,mainFrame);
				setGameFrame.setVisible(false);
			}
		} );
	}
	private void assignAddPlayerButtonController()
	{
		setGameFrame.getAddPlayerButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int numPlayers = Integer.parseInt((String) setGameFrame.getNPlayersComboBox().getSelectedItem());
				setGameFrame.getNPlayersComboBox().setEnabled(false);
				
				namePlayers.add(setGameFrame.getPlayer1TextField().getText());
				
				setGameFrame.getPlayerLabel().setText("Player "+ (namePlayers.size()+1));
				setGameFrame.getPlayer1TextField().setText("");
				
				if(namePlayers.size() == numPlayers) {
					setGameFrame.getStartGameButton().setEnabled(true);
					setGameFrame.getAddPlayerButton().setEnabled(false);
					setGameFrame.getPlayer1TextField().setEditable(false);
					setGameFrame.getPlayerLabel().setText("Player");
				}
			}
		} );
	}
	private void assignNodeFieldController() {
		setGameFrame.getPlayer1TextField().getDocument()
				.addDocumentListener(new JButtonStateController(setGameFrame.getAddPlayerButton()));
	}
}
