package exception;

@SuppressWarnings("serial")
public class TileAlreadySelectedException extends Exception {

	public TileAlreadySelectedException (String message)
	{
		super(message);
	}
}
