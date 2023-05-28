package exception;

@SuppressWarnings("serial")
public class AlreadySelectedTileException extends Exception {

	public AlreadySelectedTileException (String message)
	{
		super(message);
	}
}
