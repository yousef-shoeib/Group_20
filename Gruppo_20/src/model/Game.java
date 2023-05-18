package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {

	private LivingRoomBoard livingRoomBoard;
	private List<Player> listPlayer;
	private Bag bag;
	private int firstPlayer;
	private GameState state= GameState.NEW_GAME;
	public Game()
	{	
		listPlayer = new ArrayList<>();
	}
	public void start(int numberOfPlayers,List<String> namePlayers)
	{
		livingRoomBoard = new LivingRoomBoard(numberOfPlayers);
		bag = new Bag();
		livingRoomBoard.putItemTiles(bag.getListItemTile());
		addPlayers(numberOfPlayers,namePlayers);
		assignFirstPlayerSeat(numberOfPlayers);
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
	
	
}
