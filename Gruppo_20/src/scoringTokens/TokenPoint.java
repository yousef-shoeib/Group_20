package scoringTokens;

public abstract class TokenPoint {

	private String pathImg;
	private int value;

	public TokenPoint()
	{
		
	}

	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
