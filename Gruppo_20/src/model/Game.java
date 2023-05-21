package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import commongoal.CommonGoalCard;
import exception.MaxSelectedItemTileException;
import exception.SameTileSelectedException;

public class Game {

	private LivingRoomBoard livingRoomBoard;
	private List<Player> listPlayer;
	private Bag bag;
	private int firstPlayer;
	private GameState state;
	private CommonGoalCard commonGoal;
	private static int currentPlayer;
	private List<ItemTile> selectedTiles;
	private int maxNumberGettableTile;
	public Game()
	{	
		listPlayer = new ArrayList<>();
		selectedTiles = new ArrayList<>();
		this.state=GameState.NEW_GAME;
	}
	public void start(int numberOfPlayers,List<String> namePlayers)
	{
		livingRoomBoard = new LivingRoomBoard(numberOfPlayers);
		bag = new Bag();
		livingRoomBoard.putItemTiles(bag.getListItemTile());
		addPlayers(numberOfPlayers,namePlayers);
		assignFirstPlayerSeat(numberOfPlayers);
		setCurrentPlayer();
		commonGoal=CommonGoalCard.assignCommonGoalCard();
		this.maxNumberGettableTile = this.listPlayer.get(currentPlayer).getBookshelf().maxDrawableTiles();
	}
	public ItemTile addToSelectedTileList(int row,int column) throws Exception
	{
			if(this.maxNumberGettableTile == 0){
				throw new MaxSelectedItemTileException("you have already selected the maximum number of tiles");
			}
			if(row >= this.livingRoomBoard.rows) {
				throw new IllegalArgumentException("row is not a valid number");
			}
			if(column >= this.livingRoomBoard.columns) {
				throw new IllegalArgumentException("column is not a valid number");
			}
			Slot currentSlot = this.livingRoomBoard.getSlot(row,column);
			ItemTile checkItemTile = null;
			
			if(!currentSlot.isEmpty()) {
				   checkItemTile = currentSlot.getItemTile();
			}
			
			if(checkItemTile == null){
				throw new NullPointerException("Slot is empty");
			}
			
			if(selectedTiles.contains(checkItemTile))
				throw new SameTileSelectedException("list already contains tile");
			
		   ItemTile itemTile = null;

			   if(selectedTiles.size()== 0)  
			   {
				   itemTile = this.livingRoomBoard.getTile(checkItemTile,null,null);
			   }
			   else if(selectedTiles.size() == 1)
			   {
				   itemTile = this.livingRoomBoard.getTile(checkItemTile,selectedTiles.get(0),null); 
			   }

			   else if(selectedTiles.size() >= 2)
			   {
				   itemTile = this.livingRoomBoard.getTile(checkItemTile,selectedTiles.get(1),selectedTiles.get(0));
			   }
			   
			   selectedTiles.add(itemTile);
			   this.maxNumberGettableTile--;
			   
			   return itemTile;
	}
	public boolean deselectFromTakenList(int row,int column)
	{
		if(row >= this.livingRoomBoard.rows) {
			throw new IllegalArgumentException("row is not a valid number");
		}
		if(column >= this.livingRoomBoard.columns) {
			throw new IllegalArgumentException("column is not a valid number");
		}

		Slot currentSlot = this.livingRoomBoard.getSlot(row,column);
		ItemTile item = null;
		
		if(!currentSlot.isEmpty()) {
			item = currentSlot.getItemTile();
		}
		
		if(item == null){
			throw new NullPointerException("Slot is empty");
		}
		if(!selectedTiles.contains(item))
			throw new NullPointerException("tiles in not in the list");
		
		//if(selectedTiles.contains(item)) {
			int index = selectedTiles.indexOf(item);
	
			boolean deselect = true;
			if(selectedTiles.size() == 3)
			{
			   if(index == 0){
				   if(this.livingRoomBoard.tilesAreAdjacent(selectedTiles.get(0), selectedTiles.get(1)) 
						   && this.livingRoomBoard.tilesAreAdjacent(selectedTiles.get(0), selectedTiles.get(2))){
					   deselect = false;
				   }
			   }
			   else if(index == 1){
				   if(this.livingRoomBoard.tilesAreAdjacent(selectedTiles.get(1), selectedTiles.get(0)) 
						   && this.livingRoomBoard.tilesAreAdjacent(selectedTiles.get(1), selectedTiles.get(2))){
					   deselect = false;
				   }
			   }
			   else if(index == 2){
				   if(this.livingRoomBoard.tilesAreAdjacent(selectedTiles.get(2), selectedTiles.get(0)) 
						   && this.livingRoomBoard.tilesAreAdjacent(selectedTiles.get(2), selectedTiles.get(1))){
					   deselect = false;
				   }
			   }
			}
			if(deselect) {
				selectedTiles.remove(index);
				maxNumberGettableTile++;
				return true;
			}
		//}
		return false;
	}
	public void takeTiles()
	{
		if(selectedTiles.size() == 0) {
			throw new NullPointerException("No tile to take");
		}
	
		this.maxNumberGettableTile = 0;
	}
	public int currentPlayerFreeSlot(int column)
	{		
		return this.listPlayer.get(currentPlayer).getBookshelf().freeSlotsInColumn(column);
	}
	public ArrayList<ItemTile> moveTilesToBookshelf(int column)
	{
		ArrayList<ItemTile> tempSelectedTiles = (ArrayList<ItemTile>) getCopyOfTilesList();
		this.listPlayer.get(currentPlayer).getBookshelf().addItemTiles(column, tempSelectedTiles);
		this.livingRoomBoard.removeTile(selectedTiles);
		selectedTiles = new ArrayList<>();

		return tempSelectedTiles;
	}
	public List<ItemTile> getCopyOfTilesList()
	{
		if(selectedTiles.size() == 0) {
			throw new NullPointerException("No tile taken");
		}
		List<ItemTile> tempList = new ArrayList<>();
		for(ItemTile item : selectedTiles)
		{
			ItemTile cloneTile = new ItemTile(item);
			tempList.add(cloneTile);
		}
		return tempList;
	}
	public void swapTiles(int positionToSwap,int i)
	{
		Collections.swap(selectedTiles, positionToSwap, i);
	}
	public boolean endRound()
	{
		increaseCurrentPlayer();
		this.maxNumberGettableTile = this.listPlayer.get(currentPlayer).getBookshelf().maxDrawableTiles();
		if(!this.livingRoomBoard.hasAdjacentTiles())
		{
			this.livingRoomBoard.putItemTiles(this.getBag().getListItemTile());
			return true;
		}
		return false;
	}
	private void setCurrentPlayer() {
		int size=this.listPlayer.size();
		for(int i=0; i<size;i++ ) {
			if(this.listPlayer.get(i).isFirstPlayer()) {
				currentPlayer=i;
			}
		}
	}
	private void increaseCurrentPlayer()
	{
		if(currentPlayer == this.listPlayer.size()-1){
			currentPlayer = 0;
		}
			else{
				currentPlayer++;
			}
	}
	private void addPlayers(int numberOfPlayers,List<String> namePlayers)
	{
		for(int i = 0; i < numberOfPlayers; i++)
		{
			Player player = new Player(namePlayers.get(i));
			listPlayer.add(player);
		}
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
			int points= commonGoal.ReturnPoints(listPlayer.size());
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
	public boolean selectedtTileContains(int row,int column)
	{
		Slot currentSlot = this.livingRoomBoard.getSlot(row,column);
		ItemTile checkItemTile = null;
		
		if(!currentSlot.isEmpty()) {
			   checkItemTile = currentSlot.getItemTile();
			   if(selectedTiles.contains(checkItemTile)) {
				   return true;
			   }
		}
		return false;
	}
	public int getCurrentPlayer() {
		return currentPlayer;
	}
	public String getCurrentPlayerName()
	{
		return listPlayer.get(currentPlayer).getName();
	}
	public int getCurrentPlayerPoints()
	{
		return listPlayer.get(currentPlayer).getPoints();
	}
	public String getCurrentPlayerPersonalGoalCardPath()
	{
		return 	this.listPlayer.get(currentPlayer).getPersonalGoalCard().getPath();
	}
	public Slot[][] getCurrentPlayerBookShelf()
	{
		return this.listPlayer.get(currentPlayer).getBookshelf().getMatrGrid();
	}
	public Slot[][] getLivingRoomBoard()
	{
		return this.livingRoomBoard.getMatrGrid();
	}
	public int getMaxNumberGettableTile() {
		return maxNumberGettableTile;
	}
	public int numberOfSelectedTile()
	{
		return selectedTiles.size();
	}
}
