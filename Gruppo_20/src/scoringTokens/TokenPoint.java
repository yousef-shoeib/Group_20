package scoringTokens;
/**
 * classe super per gli scoring token 
 * @author Dario
 *
 */
public abstract class TokenPoint {

	private String pathImg;
	private int value;

	public TokenPoint(){
		
	}

	public String getPathImg() {
		return pathImg;
	}

	public int getValue() {
		return value;
	}

}
