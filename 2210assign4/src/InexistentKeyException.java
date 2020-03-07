/**
 * @author Maya Michalik
 * November 15 2019
 * This is the inexistent key exception that is thrown
 */

public class InexistentKeyException extends Exception {
	
	InexistentKeyException(){
		super("Key does not exist");
	}

}