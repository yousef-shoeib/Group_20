package exception;

/**
 * AlreadySelectedTileException : Checked Exception
 * Constructs an AlreadySelectedTileException with the specified detail message
 * @author Marco
 *
 */
public class AlreadySelectedTileException extends Exception {

	public AlreadySelectedTileException (String message)
	{
		super(message);
	}
}
