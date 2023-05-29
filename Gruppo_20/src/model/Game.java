package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import commongoal.CommonGoalCard;
import exception.MaxSelectedTileException;
import scoringTokens.TokenPoint;
import scoringTokens.TokenPoint2;
import scoringTokens.TokenPoint4;
import scoringTokens.TokenPoint6;
import scoringTokens.TokenPoint8;
import exception.AlreadySelectedTileException;
import utility.ConfigPath;
/**
 * Classe Game
 * Definisce attributi e metodi che implementano la logica del gioco.
 * @author Marco, Yousef
 *
 */
public class Game {

	private LivingRoomBoard livingRoomBoard;
	private List<Player> playersList;
	private Bag bag;
	private int firstPlayer;
	private static GameState state= GameState.NEW_GAME;
	private CommonGoalCard commonGoal1;
	private CommonGoalCard commonGoal2;
	private int currentPlayer;
	private List<ItemTile> selectedTiles;
	private int maxNumberGettableTile;
	private List <TokenPoint> tokensList1;
	private List <TokenPoint> tokensList2;
	private int tokenCounter1;
	private int tokenCounter2;
	
	public Game()
	{	
		playersList = new ArrayList<>();
		selectedTiles = new ArrayList<>();
		tokensList1 = new ArrayList<>();
		tokensList2 = new ArrayList<>();
		tokenCounter1=0;
		tokenCounter2=0;
	}
	public void start(int numberOfPlayers,List<String> namePlayers)
	{
		livingRoomBoard = new LivingRoomBoard(numberOfPlayers);
		bag = new Bag();
		bag.fill(ConfigPath.getItemFilePath());
		livingRoomBoard.putItemTiles(bag.getItemTileList());
		addPlayers(numberOfPlayers,namePlayers);
		assignFirstPlayerSeat(numberOfPlayers);
		setCurrentPlayer();
		commonGoal1=CommonGoalCard.assignCommonGoalCard();
		commonGoal2=CommonGoalCard.assignCommonGoalCard();
		tokenCounter1=0;
		tokenCounter2=0;
		fillScoringTokens(numberOfPlayers);
		this.maxNumberGettableTile = this.playersList.get(currentPlayer).getBookshelf().maxDrawableTiles();
	}
	/**
	 * Aggiunge una tessera alla lista delle tessere prendibili
	 * @param row riga in cui si trova la tessera
	 * @param column colonna in cui si trova la tessera
	 * @return la tessera se è stata aggiunta.
	 * @throws @MaxSelectedItemTileException se già sono state aggiunte il numero massimo di tessere prendibili
	 * @throws @TileAlreadySelectedException se già è stata aggiunta la tessera alla lista
	 * @throws @throwsTileHasNotFreeSideException se la tessera non ha un lato libero
	 * @throws @throwsTilesAreNotAdjacentException se la tessera non è adiacente alle tessere aggiunte precendentemente
	 * @throws @throwsTilesAreNotInlineException se la tessera non è in linea con le tessere aggiunte precedentemente
	 */
	public int addToSelectedTileList(int row,int column) throws Exception   
	{
			if(this.maxNumberGettableTile == 0){
				throw new MaxSelectedTileException("you have already selected the maximum number of tiles");
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
				throw new AlreadySelectedTileException("list already contains tile");
			
			boolean result = false;

			   if(selectedTiles.size()== 0){
				   result = this.livingRoomBoard.takeableTile(checkItemTile);
			   }
			   else if(selectedTiles.size() == 1){
				   result = this.livingRoomBoard.takeableTile(checkItemTile,selectedTiles.get(0)); 
			   }
			   else if(selectedTiles.size() >= 2){
				   result = this.livingRoomBoard.takeableTile(checkItemTile,selectedTiles.get(0),selectedTiles.get(1));
			   }
			  if(result){
				   selectedTiles.add(checkItemTile);
				   this.maxNumberGettableTile--;
				   return checkItemTile.getId();
			  }
			   return -1;
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
		if(!selectedTiles.contains(item)) {
			throw new NullPointerException("tiles in not in the list");
		}
		
		int index = selectedTiles.indexOf(item);

		boolean deselect = true;
		if(selectedTiles.size() == 3){
			
		   if(index == 0){
			   if(this.livingRoomBoard.areAdjacent(selectedTiles.get(0), selectedTiles.get(1)) 
					   && this.livingRoomBoard.areAdjacent(selectedTiles.get(0), selectedTiles.get(2))){
				   deselect = false;
			   }
		   }
		   else if(index == 1){
			   if(this.livingRoomBoard.areAdjacent(selectedTiles.get(1), selectedTiles.get(0)) 
					   && this.livingRoomBoard.areAdjacent(selectedTiles.get(1), selectedTiles.get(2))){
				   deselect = false;
			   }
		   }
		   else if(index == 2){
			   if(this.livingRoomBoard.areAdjacent(selectedTiles.get(2), selectedTiles.get(0)) 
					   && this.livingRoomBoard.areAdjacent(selectedTiles.get(2), selectedTiles.get(1))){
				   deselect = false;
			   }
		   }
		}
		if(deselect) {
			selectedTiles.remove(index);
			maxNumberGettableTile++;
			return true;
		}
			
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
		return this.playersList.get(currentPlayer).getBookshelf().freeSlotsInColumn(column);
	}
	public List<ItemTile> moveTilesToBookshelf(int column)
	{
		List<ItemTile> tempSelectedTiles = this.getTilesList();
		this.playersList.get(currentPlayer).getBookshelf().addItemTiles(column, tempSelectedTiles);
		this.livingRoomBoard.removeTile(selectedTiles);
		selectedTiles = new ArrayList<>();

		return tempSelectedTiles;
	}
	public List<ItemTile> getTilesList()
	{
		if(selectedTiles.size() == 0) {
			throw new NullPointerException("No tile taken");
		}
		return Collections.unmodifiableList(selectedTiles);
	}
	public void swapTiles(int positionToSwap,int i)
	{
		Collections.swap(selectedTiles, positionToSwap, i);
	}
	public boolean endRound()
	{
		increaseCurrentPlayer();
		this.maxNumberGettableTile = this.playersList.get(currentPlayer).getBookshelf().maxDrawableTiles();
		if(!this.livingRoomBoard.hasAdjacent())
		{
			this.livingRoomBoard.putItemTiles(this.bag.getItemTileList());
			return true;
		}
		return false;
	}
	private void setCurrentPlayer() {
		int size=this.playersList.size();
		for(int i=0; i<size;i++ ) {
			if(this.playersList.get(i).isFirstPlayer()) {
				currentPlayer=i;
			}
		}
	}
	private void increaseCurrentPlayer()
	{
		if(currentPlayer == this.playersList.size()-1){
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
			playersList.add(player);
		}
	}
	private void assignFirstPlayerSeat(int numberOfPlayers) {
		Random r= new Random();
		int i= r.nextInt(numberOfPlayers);
		playersList.get(i).setFirstPlayerSeat(true);
		this.firstPlayer=i;
		currentPlayer=i;
	}
	
	public void nextPlayer() {
		if(currentPlayer < playersList.size()-1) {
		currentPlayer++;
		}
		else {
			currentPlayer=0;
		}
	}
	
	public int getFirstPlayer() {
		return firstPlayer;
	}
	

	public static GameState getState() {
		return state;
	}
	public static void setState(GameState new_state) {
		state = new_state;
	}
	public void finalPointsCount() {
		for(Player p: playersList) {
			p.countPoints();
		}
	}
	public void controlCommonGoal() {
		
	}
	public CommonGoalCard getCommonGoal1() {
		return commonGoal1;
	}
	public Player currentPlayer() {
		return playersList.get(currentPlayer);
	}
	public int getCurrentPlayerNumber() {
		return currentPlayer;
	}
	
	public void checkCommonGoal() {
		checkCommonGoal1();
		checkCommonGoal2();
	}
	private void checkCommonGoal1() {
		if(playersList.get(currentPlayer).getScoringToken1()== null 
				&&commonGoal1.CheckTarget(currentPlayer().getBookshelf())) {
			playersList.get(currentPlayer).setScoringToken1(tokensList1.get(tokenCounter1));
			playersList.get(currentPlayer).addPoints(getScoringToken1Points());
		}
	}
	private void checkCommonGoal2() {
		if(playersList.get(currentPlayer).getScoringToken2()== null 
				&&commonGoal2.CheckTarget(currentPlayer().getBookshelf())) {
			playersList.get(currentPlayer).setScoringToken2(tokensList2.get(tokenCounter2));
			playersList.get(currentPlayer).addPoints(getScoringToken2Points());
		}
	}
	public Player getWinner() {
		Player winner=playersList.get(0);
		for(Player p: playersList) {
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
	private void fillScoringTokens(int numberOfPlayers) {
		switch(numberOfPlayers) {
		case 2:
			tokensList1.add(new TokenPoint8());
			tokensList1.add(new TokenPoint4());

			tokensList2.add(new TokenPoint8());
			tokensList2.add(new TokenPoint4());	
			break;
		case 3:
			tokensList1.add(new TokenPoint8());
			tokensList1.add(new TokenPoint6());
			tokensList1.add(new TokenPoint4());
			
			tokensList2.add(new TokenPoint8());
			tokensList2.add(new TokenPoint6());
			tokensList2.add(new TokenPoint4());	
			break;
		case 4:
			tokensList1.add(new TokenPoint8());
			tokensList1.add(new TokenPoint6());
			tokensList1.add(new TokenPoint4());
			tokensList1.add(new TokenPoint2());
			
			tokensList2.add(new TokenPoint8());
			tokensList2.add(new TokenPoint6());
			tokensList2.add(new TokenPoint4());	
			tokensList2.add(new TokenPoint2());
			break;
		}
	}
	public int getScoringToken1Points() {
		int points=tokensList1.get(tokenCounter1).getValue();
		if(tokenCounter1<tokensList1.size()-1)
		tokenCounter1++;
		return points;
	}
	public int getScoringToken2Points() {
		int points=tokensList2.get(tokenCounter2).getValue();
		if(tokenCounter2<tokensList2.size()-1)
		tokenCounter2++;
		return points;
	}
	public int getCurrentPlayer() {
		return currentPlayer;
	}
	public String getCurrentPlayerName()
	{
		return playersList.get(currentPlayer).getName();
	}
	public int getCurrentPlayerPoints()
	{
		return playersList.get(currentPlayer).getPoints();
	}
	public String getCurrentPlayerPersonalGoalCardPath()
	{
		return 	this.playersList.get(currentPlayer).getPersonalGoalCard().getPath();
	}
	public Slot[][] getCurrentPlayerBookShelf()
	{
		return this.playersList.get(currentPlayer).getBookshelf().getMatrGrid();
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
	public List<Player> getListPlayer() {
		return Collections.unmodifiableList(playersList);
	}
	public CommonGoalCard getCommonGoal2() {
		return commonGoal2;
	}
	public List <TokenPoint> getTokensList1() {
		return tokensList1;
	}
	public List <TokenPoint> getTokensList2() {
		return tokensList2;
	}
	public int getTokenCounter1() {
		return tokenCounter1;
	}
	public int getTokenCounter2() {
		return tokenCounter2;
	}
	public int getNumberOfPlayers() {
		return playersList.size();
	}
}
