package view;

import java.awt.EventQueue;

import controller.MainController;
import model.Game;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					Game game = new Game();
					MainController mainController = new MainController(game,frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
