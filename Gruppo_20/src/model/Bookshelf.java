package model;

import java.util.ArrayList;

public class Bookshelf extends Grid {
	public Bookshelf() {
		super(6, 5);
	}
	private String path="./resources/Assets/boards/bookshelf_orth.png";
	public void addItemTiles(int column, ArrayList<ItemTile> tiles) {
		int n = 0;
		for (int i = 0; i < tiles.size(); i++) {
			if (!this.getSlot(i, column).isEmpty()) {
				System.out.println("Not enough slots in the selected column");
				return;
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
		if(this.matrGrid[row][column].getItemTile()== null) {
			throw new NullPointerException();
		}
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
				if (this.getSlot(row, column).isEmpty()) {
					maxNumberOfTiles++;
				}
				/*if(this.getSlot(row, column).getItemTile() != null) {
					break;
				}*/
				if (maxNumberOfTiles == 3) {
					return maxNumberOfTiles;
				}
			}
		}
		return maxNumberOfTiles;
	}

	public boolean isComplete() {
		for (int i = 0; i < 5; i++) {
			if (this.matrGrid[0][i].isEmpty()) {
				return false;
			}
		}
		return true;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private boolean visited[][];

	public int numberOfGroups() {
		int numberOfElements=0;
		ArrayList<Integer> elementsPerGroup= new ArrayList<>();
		if (this == null || this.rows == 0)
			return 0;
		int rows = this.rows;
		int columns = this.columns;
		int count = 0;
		visited = new boolean[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
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

	public String getPath() {
		return path;
	}
}
