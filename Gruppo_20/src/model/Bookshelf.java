package model;

import java.util.ArrayList;

public class Bookshelf extends Grid {
	public Bookshelf() {
		super(6, 5);
	}

	public void addItemTiles(int column, ArrayList<ItemTile> tiles) {
		int n = 0;
		for (int i = 0; i < tiles.size(); i++) {
			if (this.getTile(i, column) != null) {
				System.out.println("Not enough slots in the selected column");
				return;
			}
		}

		for (int i = 5; n < tiles.size(); i--) {
			if (this.getTile(i, column) != null) {
				this.setTile(i, column, tiles.get(n));
				n++;
			}
		}
	}

	public ItemTile getTile(int row, int column) {
		return this.matrGrid[row][column].getItemTile();
	}

	public void setTile(int row, int column, ItemTile tile) {
		this.matrGrid[row][column].setItemTile(tile);
	}

	public int maxDrawableTiles() {
		int maxNumberOfTiles = 0;
		for (int column = 0; column < this.columns; column++) {
			maxNumberOfTiles = 0;
			for (int row = 0; row < 3; row++) {
				if (this.getSlot(row, column).getItemTile() == null) {
					maxNumberOfTiles++;
				}
				if (maxNumberOfTiles == 3) {
					return maxNumberOfTiles;
				}
			}
		}
		return maxNumberOfTiles;
	}

	public boolean isComplete() {
		for (int i = 0; i < 5; i++) {
			if (this.matrGrid[0][i].getItemTile() == null) {
				return false;
			}
		}
		return true;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private boolean visited[][];

	public int numberOfGroups() {
		if (this == null || this.rows == 0)
			return 0;
		int m = this.rows;
		int n = this.columns;
		int count = 0;
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (this.getMatrGrid()[i][j].getItemTile().getColor() == "COLORE" && !visited[i][j]) {
					visited[i][j] = true;
					this.search(i + 1, j);
					this.search(i, j + 1);
					this.search(i - 1, j);
					this.search(i, j - 1);
					count++;
				}
			}
		}
		return count;
	}

	private void search(int row, int col) {
		if (row < 0 || row == this.rows || col < 0 || col == this.columns)
			return;
		if (this.getMatrGrid()[row][col].getItemTile().getColor() == "COLORE" && !visited[row][col]) {
			visited[row][col] = true;

			int i = row, j = col;
			this.search(i + 1, j);
			this.search(i, j + 1);
			this.search(i - 1, j);
			this.search(i, j - 1);
		}
	}
}
