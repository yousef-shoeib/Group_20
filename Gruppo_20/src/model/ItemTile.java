package model;

public class ItemTile {
		private String pathImg;
		private int x;
		private int y;
		private int id;
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
}
