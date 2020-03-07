/**
 * @author Maya Michalik
 * November 15 2019
 * This class creates the pixels that are the items stored in the tree 
 */

public class Pixel {
	
	private Location location;
	private int colour;
	//Initializes variables 
	
	/**
	 * constructor method
	 * @param p
	 * @param color
	 */
	public Pixel(Location p, int color) {
		
		this.location = p;
		this.colour = color;
		
	}
	
	/**
	 * getter method for location
	 * @return location
	 */
	public Location getLocation() {
		return this.location;
	}
	
	/**
	 * getter method for color
	 * @return colour
	 */
	 public int getColor() {
		return this.colour;
	 }

}
