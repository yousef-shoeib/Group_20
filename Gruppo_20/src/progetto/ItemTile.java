package progetto;

public class ItemTile {

	private String Color;
	private int x;
	private int y;
	
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
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
	
	public ItemTile (String Color, int x, int y)
	{
		this.Color=Color;
		this.x=x;
		this.y=y;
		
		
	}
}
