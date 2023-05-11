package model;

public class ItemTile {
		private String pathImg;
		private int x;
		private int y;
		private int id;
		private ItemTileType type;
		public int getId() {
			return id;
		}
		private static int cont = 0;
		
		public ItemTile(String pathImg,String color)
		{
			this.pathImg = pathImg;
			this.color = color;
			id = cont;
			cont = cont +1;
			this.type=ItemTileType.assignType(color);
		}
		
		public String getPathImg(){ 
			return pathImg;
		}
		public void setPathImg(String pathImg) {
			this.pathImg = pathImg;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		private String color;
		
		@Override
		public boolean equals(Object obj) {
		// TODO Auto-generated method stub
			ItemTile item = (ItemTile) obj;
			if(this.id == item.getId())
				return true;
		return false;
		}

		public ItemTileType getType() {
			return type;
		}
}
