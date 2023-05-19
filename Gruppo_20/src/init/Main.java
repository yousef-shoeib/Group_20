package init;

import java.awt.EventQueue;

import controller.MainController;
import controller.SetGameController;
import model.Game;
import model.GameState;
import view.SetGameFrame;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Game game = new Game();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						SetGameFrame setGameFrame = new SetGameFrame();
						SetGameController setGameController = new SetGameController(setGameFrame,game);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	while(game.getState().equals(GameState.NEW_GAME)) {
		
	}
	}
	
}
