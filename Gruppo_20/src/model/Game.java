package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import commongoal.CommonGoalCard;

public class Game {

	private LivingRoomBoard livingRoomBoard;
	private List<Player> listPlayer;
	private Bag bag;
	private int firstPlayer;
	private GameState state;
	private CommonGoalCard commonGoal;
	private static int currentPlayer;
	public Game()
	{	
		listPlayer = new ArrayList<>();
		this.state=GameState.NEW_GAME;
	}
	public void start(int numberOfPlayers,List<String> namePlayers)
	{
		livingRoomBoard = new LivingRoomBoard(numberOfPlayers);
		bag = new Bag();
		livingRoomBoard.putItemTiles(bag.getListItemTile());
		addPlayers(numberOfPlayers,namePlayers);
		assignFirstPlayerSeat(numberOfPlayers);
		commonGoal=CommonGoalCard.assignCommonGoalCard(null);
	}
	
	public LivingRoomBoard getLivingRoomBoard() {
		return livingRoomBoard;
	}
	private void addPlayers(int numberOfPlayers,List<String> namePlayers)
	{
		for(int i = 0; i < numberOfPlayers; i++)
		{
			Player player = new Player(namePlayers.get(i));
			listPlayer.add(player);
		}
	}
	public List<Player> getListPlayer() {
		return listPlayer;
	}
	
	private void assignFirstPlayerSeat(int numberOfPlayers) {
		Random r= new Random();
		int i= r.nextInt(numberOfPlayers);
		listPlayer.get(i).setFirstPlayerSeat(true);
		this.firstPlayer=i;
		currentPlayer=i;
	}
	
	public void nextPlayer() {
		if(currentPlayer < listPlayer.size()-1) {
		currentPlayer++;
		}
		else {
			currentPlayer=0;
		}
	}
	
	public int getFirstPlayer() {
		return firstPlayer;
	}
	
	public Bag getBag() {
		return bag;
	}
	public GameState getState() {
		return state;
	}
	public void setState(GameState state) {
		this.state = state;
	}
	public void finalPointsCount() {
		for(Player p: listPlayer) {
			p.countPoints();
		}
	}
	public void controlCommonGoal() {
		
	}
	public CommonGoalCard getCommonGoal() {
		return commonGoal;
	}
	public Player currentPlayer() {
		return listPlayer.get(currentPlayer);
	}
	public static int getCurrentPlayerNumber() {
		return currentPlayer;
	}
	
	public void checkCommonGoal() {
		//if(commonGoal.CheckTarget()) {
			int points= commonGoal.ReturnPoints(currentPlayer, listPlayer.size());
			listPlayer.get(currentPlayer).addPoints(points);
		//}
	}
	public Player getWinner() {
		Player winner=listPlayer.get(0);
		for(Player p: listPlayer) {
			if(p.getPoints()>winner.getPoints()) {
				winner=p;
			}
		}
		return winner;
	}
	
}
