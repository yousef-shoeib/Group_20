package init;

import java.awt.EventQueue;

import controller.MainController;
import controller.SetGameController;
import model.Game;
import model.GameState;
import model.Player;
import view.SetGameFrame;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Game game = new Game();
		SetGameFrame setGameFrame;
		SetGameController setGameController;
	
	do {// il ciclo non controlla ancora il gioco
		if(Game.getState().equals(GameState.NEW_GAME)) {
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
			Game.setState(GameState.PLAY);
		}
	if(Game.getState().equals(GameState.GAME_OVER)) {
		game.finalPointsCount();
		Player winner = game.getWinner();
		System.out.println(winner.toString());
	}
	
	}while(!Game.getState().equals(GameState.QUIT));
}
}