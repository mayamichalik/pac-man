/**
 * @author Maya Michalik
 * November 15 2019
 * this is the duplicated key exception that is thrown
 */

public class DuplicatedKeyException extends Exception{
	
	public DuplicatedKeyException()
	{
		super ("Duplicated key");
	}
}