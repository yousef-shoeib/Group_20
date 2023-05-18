package exception;

@SuppressWarnings("serial")
public class SameTileSelectedException extends Exception {

	public SameTileSelectedException (String message)
	{
		super(message);
	}
}
