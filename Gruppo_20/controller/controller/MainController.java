package controller;

import model.Game;
import view.MainFrame;

public class MainController {

	private Game game;
	private MainFrame mainFrame;
	
	public MainController(Game game, MainFrame mainFrame)
	{
		this.game = game;
		this.mainFrame = mainFrame;
		
	}

}
