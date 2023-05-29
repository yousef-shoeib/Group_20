package commongoal;

import model.Bookshelf;
import model.ItemTileType;

public class CommonGoalCard11 extends CommonGoalCard {
	
	private String path = "./resources/Assets/commonGoalCards/11.jpg";
	
	public CommonGoalCard11() {}
	
	private boolean checkMainDiagonal(Bookshelf bookshelf) {
		ItemTileType type1 = null;
		ItemTileType type2= null;
		boolean control1=true;
		boolean control2=true;
		if(bookshelf.getSlot(0, 0).isEmpty()&&bookshelf.getSlot(1, 0).isEmpty()) {
			return false;
		}
		if(!bookshelf.getSlot(0, 0).isEmpty())
		 type1=bookshelf.getItemTileType(0, 0);
		if(!bookshelf.getSlot(1, 0).isEmpty())
		 type2=bookshelf.getItemTileType(1, 0);
		for(int i=1; i < bookshelf.getColumns();i++) {
			if(bookshelf.getSlot(i, i).isEmpty())
				control1=false;
			else
				if(!bookshelf.getItemTileType(i,i).equals(type1))
					control1=false;
			
			if(bookshelf.getSlot(i+1, i).isEmpty())
				control2=false;
			else
				if(!bookshelf.getItemTileType(i+1,i).equals(type2))
					control2=false;
			
			if(control1== false && control2==false) {
				return false;
			}
		}
		return true;
		
	}
	private boolean checkSecondDiagonal(Bookshelf bookshelf) {
		ItemTileType type1 = null;
		ItemTileType type2= null;
		boolean control1=true;
		boolean control2=true;
		if(bookshelf.getSlot(4, 0).isEmpty()&&bookshelf.getSlot(5, 0).isEmpty()) {
			return false;
		}
		if(!bookshelf.getSlot(4, 0).isEmpty())
		 type1=bookshelf.getItemTileType(4, 0);
		if(!bookshelf.getSlot(5, 0).isEmpty())
		 type2=bookshelf.getItemTileType(5, 0);
		for(int i=1; i < bookshelf.getColumns();i++) {
			if(bookshelf.getSlot(4-i, i).isEmpty())
				control1=false;
			else
				if(!bookshelf.getItemTileType(4-i,i).equals(type1))
					control1=false;
			
			if(bookshelf.getSlot(5-i, i).isEmpty())
				control2=false;
			else
				if(!bookshelf.getItemTileType(5-i,i).equals(type2))
					control2=false;
			
			if(control1== false && control2==false) {
				return false;
			}
		}
		return true;
		/////
		/*if(bookshelf.getSlot(4, 0).isEmpty()&&bookshelf.getSlot(5, 0).isEmpty()) {
			return false;
		}
		
		ItemTileType type1=bookshelf.getItemTileType(4, 0);
		ItemTileType type2=bookshelf.getItemTileType(5, 0);
		for(int i=1; i < bookshelf.getColumns();i++) {
			if(bookshelf.getSlot(4-i, i).isEmpty()&&bookshelf.getSlot(5-i, i).isEmpty()) {
				return false;
			}
			if(!bookshelf.getItemTileType(4-i,i).equals(type1)&& !bookshelf.getItemTileType(5-i,i).equals(type2)) {
				return false;
			}			
		}
		return true;*/
	}
	
	@Override
	public boolean CheckTarget(Bookshelf bookshelf) {
		if(checkMainDiagonal(bookshelf)||checkSecondDiagonal(bookshelf))
			return true;
		return false;
		/*for(int i=0; i<bookshelf.getRows()-1; i++) {
			for(int j=0; j<bookshelf.getColumns()-1;j++) {
				int count=1;
				
				for(int k=1; k<5 && i+k < bookshelf.getColumns() && j+k <bookshelf.getRows(); k++) {
					if(!bookshelf.getSlot(i+k, j+k).isEmpty()  && !bookshelf.getSlot(i, j).isEmpty()) {
							if(bookshelf.getTile(i+k, j+k).equals(bookshelf.getTile(i, j))){
								count++;
									if(count==5) return true;
									else break;
						}
					}
				}
			}
		}
	return false;*/
	}
	
	public String getPath() {
		return path;
	}
}
