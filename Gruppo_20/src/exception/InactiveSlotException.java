package exception;
/**
 * InactiveSlotException : Unchecked Exception
 * Constructs an InactiveSlotException with the specified detail message
 * @author Marco
 *
 */
public class InactiveSlotException extends RuntimeException {
	public InactiveSlotException (String message)
	{
		super(message);
	}
}
