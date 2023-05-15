package model;

import java.util.ArrayList;
import java.util.List;

public class Bookshelf extends Grid {
	public Bookshelf() {
		super(6, 5);
		/*
		 * for(int i=0;i<6;i++) { for(int j=0;j<5;j++) { this.matrGrid[i][j]=new Slot();
		 * } }
		 */
	}

	private static ItemTileType types[] = { ItemTileType.CAT, ItemTileType.BOOK, ItemTileType.FRAME,
			ItemTileType.TROPHY, ItemTileType.PLANT, ItemTileType.GAME };
	private List<Integer> adjacentTiles = new ArrayList<>();;
	private String path = "./resources/Assets/boards/bookshelf_orth.png";

	public void addItemTiles(int column, ArrayList<ItemTile> tiles) {
		int n = 0;
		for (int i = 0; i < tiles.size(); i++) {
			if (!this.getSlot(i, column).isEmpty()) {
				throw new IllegalArgumentException("Not enough slots in the selected column");
				// System.out.println("Not enough slots in the selected column");
			}
		}

		for (int i = 5; n < tiles.size(); i--) {
			if (this.getSlot(i, column).isEmpty()) {
				this.setTile(i, column, tiles.get(n));
				n++;
			}
		}
	}

	public ItemTile getTile(int row, int column) {
		if (this.getSlot(row, column).getItemTile() == null) {
			throw new NullPointerException();
		}
		return this.getSlot(row, column).getItemTile();

	}

	public void setTile(int row, int column, ItemTile tile) {
		this.getSlot(row, column).setItemTile(tile);
	}

	public int maxDrawableTiles() {
		int maxNumberOfTiles = 0;
		for (int column = 0; column < this.columns; column++) {
			maxNumberOfTiles = 0;
			for (int row = 0; row < 3; row++) {
				if (this.getSlot(row, column).isEmpty()) {
					maxNumberOfTiles++;
				}
				/*
				 * if(this.getSlot(row, column).getItemTile() != null) { break; }
				 */
				if (maxNumberOfTiles == 3) {
					return maxNumberOfTiles;
				}
			}
		}
		return maxNumberOfTiles;
	}

	public boolean isComplete() {
		for (int i = 0; i < 5; i++) {
			if (this.getSlot(0, i).isEmpty()) {
				return false;
			}
		}
		return true;
	}

	//////////////////// soluzione temporanea
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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
		// numbers of 4 adjacent slots
		int rowNumber[] = new int[] { -1, 0, 0, 1 };
		int colNumber[] = new int[] { 0, -1, 1, 0 };
		visited[row][col] = true;
		int size = 1;// size of the tiles group
		for (int k = 0; k < 4; ++k)
			if (isSafe(row + rowNumber[k], col + colNumber[k], visited, type))
				size += count(row + rowNumber[k], col + colNumber[k], visited, type);
		return size;
	}

	public void countGroups() {
		// int count=0;
		for (ItemTileType type : types) {
			boolean visited[][] = new boolean[rows][columns];
			// adjacentTiles=new ArrayList<>();
			for (int i = 0; i < this.rows; ++i)
				for (int j = 0; j < this.columns; ++j)

					if (!this.getSlot(i, j).isEmpty() && this.getItemTileType(i, j) == type && !visited[i][j]) {
						int size = count(i, j, visited, type);
						// ++count;
						if (size > 1)
							adjacentTiles.add(size);
					}
		}
		// return count;
	}

	public String getPath() {
		return path;
	}

	public List<Integer> getAdjacentTiles() {
		return this.adjacentTiles;
	}

	public ItemTileType getItemTileType(int row, int column) {
		return this.getSlot(row, column).getItemTile().getType();
	}
}
