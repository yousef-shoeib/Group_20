package commongoal;

import model.Bookshelf;

public class CommonGoalCard12 extends CommonGoalCard{
	
	private String path = "./resources/Assets/commonGoalCards/12.jpg";
	
	public CommonGoalCard12() {}
	
	/*private boolean isTriangularSX_DX(Bookshelf bookshelf) {
		int count1=0;
		int count2=0;
		
		for(int i=1; i<bookshelf.getRows(); i++) {
			for(int j=0; j<i; j++) {
				if(!bookshelf.getSlot(i, j).isEmpty()) count1++;
			}
		}
		
		for(int i=1; i<bookshelf.getRows(); i++) {
			for(int j=i;j<bookshelf.getColumns();j++) {
				if(!bookshelf.getSlot(i, j).isEmpty()) count2++; 
			}
		}
		if((count1+count2)==25) return true;
		else return false;
	}
	
	private boolean isTriangularDX_SX(Bookshelf bookshelf) {
		int count1=0;
		int count2=0;
		
		for(int i=1; i<bookshelf.getRows(); i++) {
			for(int j=0; j<bookshelf.getRows()-i-1; j++) {
				if(!bookshelf.getSlot(i, j).isEmpty()) count1++;
			}
		}
		for(int i=1; i<bookshelf.getRows(); i++) {
			for(int j=0; j<bookshelf.getColumns(); j++) {
				if(j>=bookshelf.getRows()-i-1) {
					if(!bookshelf.getSlot(i, j).isEmpty()) count2++;
				}
			}
		}
		if((count1+count2)==25) return true;
		else return false;
	}*/
	private boolean decreasingHeight(Bookshelf bookshelf) {// or increasing
		int heightFirstColumn=bookshelf.freeSlotsInColumn(0);
		for(int column=1;column<bookshelf.getColumns();column++) {
			if(bookshelf.freeSlotsInColumn(column)-column!=heightFirstColumn) {
				return false;
			}
		}
		return true;
	}
	private boolean increasingHeight(Bookshelf bookshelf) {// or increasing
		int heightFirstColumn=bookshelf.freeSlotsInColumn(0);
		for(int column=1;column<bookshelf.getColumns();column++) {
			if(bookshelf.freeSlotsInColumn(column)+column!=heightFirstColumn) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		if(increasingHeight(bookshelf)||decreasingHeight(bookshelf)) {
			return true;
		}
		else return false;
	}
	
	public String getPath() {
		return path;
	}
}
