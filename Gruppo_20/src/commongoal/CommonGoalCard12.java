package commongoal;

import model.Bookshelf;

public class CommonGoalCard12 extends CommonGoalCard{
	Bookshelf bookshelf;
	private String path = "./resources/Assets/commonGoalCard/12.png";
	public CommonGoalCard12(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}
	
	private boolean isTriangularSX_DX() {
		int count1=0;
		int count2=0;
		
		for(int i=1; i<this.bookshelf.getRows(); i++) {
			for(int j=0; j<i; j++) {
				if(this.bookshelf.getSlot(i, j).isEmpty()==false) count1++;
			}
		}
		
		for(int i=1; i<this.bookshelf.getRows(); i++) {
			for(int j=i;j<this.bookshelf.getColumns();j++) {
				if(this.bookshelf.getSlot(i, j).isEmpty()==false) count2++; 
			}
		}
		if((count1+count2)==25) return true;
		else return false;
	}
	
	private boolean isTriangularDX_SX() {
		int count1=0;
		int count2=0;
		
		for(int i=1; i<this.bookshelf.getRows(); i++) {
			for(int j=0; j<this.bookshelf.getRows()-i-1; j++) {
				if(this.bookshelf.getSlot(i, j).isEmpty()==false) count1++;
			}
		}
		for(int i=1; i<this.bookshelf.getRows(); i++) {
			for(int j=0; j<this.bookshelf.getColumns(); j++) {
				if(j>=this.bookshelf.getRows()-i-1) {
					if(this.bookshelf.getSlot(i, j).isEmpty()==false) count2++;
				}
			}
		}
		if((count1+count2)==25) return true;
		else return false;
	}

	@Override
	boolean CheckTarget() {
		boolean checkGoal;
		checkGoal = isTriangularSX_DX() || isTriangularDX_SX();
		if(checkGoal) return true;
		else return false;
	}
}
