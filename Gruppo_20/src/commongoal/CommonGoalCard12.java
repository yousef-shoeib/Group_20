package commongoal;

import model.Bookshelf;

public class CommonGoalCard12 extends CommonGoalCard{
	
	private String path = "./resources/Assets/commonGoalCard/12.png";
	
	public CommonGoalCard12() {}
	
	private boolean isTriangularSX_DX(Bookshelf bookshelf) {
		int count1=0;
		int count2=0;
		
		for(int i=1; i<bookshelf.getRows(); i++) {
			for(int j=0; j<i; j++) {
				if(bookshelf.getSlot(i, j).isEmpty()==false) count1++;
			}
		}
		
		for(int i=1; i<bookshelf.getRows(); i++) {
			for(int j=i;j<bookshelf.getColumns();j++) {
				if(bookshelf.getSlot(i, j).isEmpty()==false) count2++; 
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
				if(bookshelf.getSlot(i, j).isEmpty()==false) count1++;
			}
		}
		for(int i=1; i<bookshelf.getRows(); i++) {
			for(int j=0; j<bookshelf.getColumns(); j++) {
				if(j>=bookshelf.getRows()-i-1) {
					if(bookshelf.getSlot(i, j).isEmpty()==false) count2++;
				}
			}
		}
		if((count1+count2)==25) return true;
		else return false;
	}

	@Override
	boolean CheckTarget(Bookshelf bookshelf) {
		boolean checkGoal;
		checkGoal = isTriangularSX_DX(bookshelf) || isTriangularDX_SX(bookshelf);
		if(checkGoal) return true;
		else return false;
	}
	
	public String getPath() {
		return path;
	}
}
