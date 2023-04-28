package view;

import java.awt.EventQueue;

import controller.MainController;
import controller.SetGameController;
import model.Game;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame mainFrame = null;
					SetGameFrame setGameframe = new SetGameFrame();
					Game game = new Game();
					SetGameController setGameController = new SetGameController(setGameframe,mainFrame,game);
					MainController mainController = new MainController(game,mainFrame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
