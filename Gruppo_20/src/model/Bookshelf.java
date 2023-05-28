package model;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe bookShelf per creare una libreria 
 * estende la classe Grid
 * @author youse
 *
 */
public class Bookshelf extends Grid {
	
	/**
	 * Costruttore per creare una libreria 
	 * con 6 righe e 5 colonne
	 */
	public Bookshelf() {
		super(6, 5);
	}

	private static final ItemTileType types[] = { ItemTileType.CAT, ItemTileType.BOOK, ItemTileType.FRAME,
			ItemTileType.TROPHY, ItemTileType.PLANT, ItemTileType.GAME };
	private List<Integer> adjacentTiles = new ArrayList<>();;
	private String path = "./resources/Assets/boards/bookshelf_orth.png";
	/**
	 * metodo per mettere le tessere nella libreria
	 * @param column la colonna nella quale si vuole inserire le tessere
	 * @param tiles	una lista di tessere 
	 */
	public void addItemTiles(int column, List<ItemTile> tiles) {
		int n = 0;
		for (int i = 0; i < tiles.size(); i++) {
			if (!this.getSlot(i, column).isEmpty()) {
				throw new IllegalArgumentException("Not enough slots in the selected column");
			}
		}

		for (int i = 5; n < tiles.size(); i--) {
			if (this.getSlot(i, column).isEmpty()) {
				this.setTile(i, column, tiles.get(n));
				n++;
			}
		}
	}
	/**
	 * metodo per ritornare la tessera nella casella alla riga e colonna scelta 
	 * @param row riga della casella
	 * @param column colonna della casella 
	 * @return
	 */
	public ItemTile getTile(int row, int column) {
		if (this.getSlot(row, column).isEmpty()) {
			throw new NullPointerException("This slot is Empty");
		}
		return this.getSlot(row, column).getItemTile();

	}
	//questo metodo resta "public" solo per la fase di test 
	//usare il metodo addItemTiles per implementazioni permanenti
	public void setTile(int row, int column, ItemTile tile) {
		this.getSlot(row, column).setItemTile(tile);
	}
	/**
	 * metodo per controllare il massimo numero di tessere che 
	 * si possono pescare in base al numero di caselle libere 
	 * in ogni colonna della libreria
	 * @return numero massimo di caselle pescabili
	 */
	public int maxDrawableTiles() {
		int maxNumberOfTiles = 0;
		for (int column = 0; column < this.columns; column++) {
			int freeSlots = 0;
			for (int row = 0; row < 3; row++) {
				if (this.getSlot(row, column).isEmpty()) {
					freeSlots++;
				}
				if(freeSlots>maxNumberOfTiles) {
					maxNumberOfTiles=freeSlots;
				}
				if (maxNumberOfTiles == 3) {
					return maxNumberOfTiles;
				}
			}
		}
		return maxNumberOfTiles;
	}
	/**
	 * metodo per controllare se la libreria è piena
	 * @return true se la libreria è piena
	 */
	public boolean isComplete() {
		for (int i = 0; i < 5; i++) {
			if (this.getSlot(0, i).isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * metodo per avere il numero di celle libere nella colonna scelta
	 * @param column colonna da controllare 
	 * @return numero delle caselle libere della colonna 
	 */
	public int freeSlotsInColumn(int column) {
		int rows = this.getRows();
		int freeSlots = 0;
		for (int i = 0; i < rows; i++) {
			if (this.getSlot(i, column).isEmpty()) {
				freeSlots++;
			} else {
				return freeSlots;
			}
		}
		return freeSlots;
	}

	/**
	 * metodo per contare i punti per le tessere adiacenti 
	 * @return il totale dei punti delle tessere adiacenti
	 */
	public int adjacentTilesPoints() {
		int points=0;
		this.countGroups();
		for(int i:this.adjacentTiles) {
			if(i==3)
				points+=2;
			if(i==4)
				points+=3;
			if(i==5)
				points+=5;
			if(i>=6)
				points+=8;
		}
		return points;
	}
	private boolean isSafe(int row, int col, boolean visited[][], ItemTileType type) {
		return (row >= 0) && (row < this.rows) && (col >= 0) && (col < this.columns)
				&& !this.getSlot(row, col).isEmpty()
				&& (this.getItemTileType(row, col).equals(type) && !visited[row][col]);
	}

	private int count(int row, int col, boolean visited[][], ItemTileType type) {
		int rowNumber[] = new int[] { -1, 0, 0, 1 };
		int colNumber[] = new int[] { 0, -1, 1, 0 };
		visited[row][col] = true;
		int size = 1;
		for (int k = 0; k < 4; ++k)
			if (isSafe(row + rowNumber[k], col + colNumber[k], visited, type))
				size += count(row + rowNumber[k], col + colNumber[k], visited, type);
		return size;
	}

	private void countGroups() {
		for (ItemTileType type : types) {
			boolean visited[][] = new boolean[rows][columns];
			for (int i = 0; i < this.rows; ++i)
				for (int j = 0; j < this.columns; ++j)

					if (!this.getSlot(i, j).isEmpty() && this.getItemTileType(i, j) == type && !visited[i][j]) {
						int size = count(i, j, visited, type);
						if (size > 2)
							adjacentTiles.add(size);
					}
		}
	}

	public String getPath() {
		return path;
	}

	public List<Integer> getAdjacentTiles() {
		return this.adjacentTiles;
	}
	/**
	 * metodo per avere il tipo della tessera in una data cella
	 * @param row riga della cella 
	 * @param column colonna della cella 
	 * @return tipo della tessera
	 */
	public ItemTileType getItemTileType(int row, int column) {
		return this.getSlot(row, column).getItemTile().getType();
	}
}
