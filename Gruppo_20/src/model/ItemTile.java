package model;

public class ItemTile {
		private String pathImg;
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
		public ItemTile (ItemTile item) {
			this.pathImg = item.pathImg;
			this.color = item.color;
			id = item.id;
			this.type=item.type;
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
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		private String color;
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof ItemTile){
				ItemTile item = (ItemTile) obj;
				return this.id == item.getId();
			}
			return false;
		}

		public ItemTileType getType() {
			return type;
		}
}
