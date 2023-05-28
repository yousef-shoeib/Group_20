package scoringTokens;

public abstract class TokenPoint {

	private String pathImg;
	private int id;
	private int value;
	private int numberOfPlayers;
	private static int cont = 0;

	public TokenPoint()
	{
		
	}

	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
