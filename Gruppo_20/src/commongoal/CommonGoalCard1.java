package commongoal;

import model.Bookshelf;
import model.ItemTileType;

/**
 * La CommonGoalCard1 ha come obiettivo due gruppi separati di 4 tessere dello
 * stesso tipo che formano un quadrato 2x2.Le tessere dei due gruppi devono
 * essere dello stesso tipo.
 * 
 * @author Anton
 *
 */
public class CommonGoalCard1 extends CommonGoalCard {
	private String path = "./resources/Assets/commonGoalCards/1.jpg";

	public CommonGoalCard1() {
	}

	private int rowNumber[] = new int[] { 0, 0, 1, 1 };
	private int colNumber[] = new int[] { 0, 1, 0, 1 };

	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		int count = 0;
		boolean visited[][] = new boolean[bookshelf.getRows()][bookshelf.getColumns()];
		for (int i = 0; i < bookshelf.getRows() - 1; i++) {
			for (int j = 0; j < bookshelf.getColumns() - 1; j++) {
				if (!bookshelf.getSlot(i, j).isEmpty() && !bookshelf.getSlot(i, j + 1).isEmpty()
						&& !bookshelf.getSlot(i + 1, j).isEmpty() && !bookshelf.getSlot(i + 1, j + 1).isEmpty()) {
					// associo al variabile type il tipo di riferimento da controllare
					if (!visited[i][j]) {
						ItemTileType type = bookshelf.getTile(i, j).getType();
						if (type.equals(bookshelf.getTile(i, j + 1).getType())
								&& type.equals(bookshelf.getTile(i + 1, j).getType())
								&& type.equals(bookshelf.getTile(i + 1, j + 1).getType())) {
							count++;
							for (int k = 0; k < 4; ++k) {
								visited[i + rowNumber[k]][j + colNumber[k]] = true;
							}
						}
					}
				}
				if (count >= 2)
					return true;
			}
		}
			return false;
	}

	public String getPath() {
		return path;
	}
}
