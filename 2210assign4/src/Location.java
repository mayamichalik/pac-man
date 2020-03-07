/**
 * @author Maya Michalik
 * November 15 2019
 * This class is to represent the coordinate position of a pixel 
 */

public class Location {
	
	private int x;
	private int y;
	// initializing variables
	
	/**
	 * Constructor method
	 * @param x
	 * @param y
	 */
	public Location(int x, int y) {	
		this.x = x;
		this.y = y;
	}
	
	/** 
	 * getter method for x coordinate 
	 * @return x
	 */
	public int xCoord() {
		return this.x;
	}
	
	/**
	 * getter method for y coordinate 
	 * @return y
	 */
	public int yCoord() {
		return this.y;
	}
	
	/**
	 * compares the given location p with the current one
	 * @param p
	 * @return 1 if current location > p
	 * @return 0 if current = p
	 * @return -1 if current < p
	 */
	public int compareTo (Location p) {
		if (this.x > p.xCoord()) {
			return 1;
		}
		else if(this.x < p.xCoord()) {
			return -1;
		}
		else {
			if(this.y > p.yCoord()) {
				return 1;
			}
			else if(this.y < p.yCoord()) {
				return -1;
			}
			else return 0;
		}
	}
}
