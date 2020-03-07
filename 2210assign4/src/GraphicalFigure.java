/**
 * @author Maya Michalik
 * November 15 2019
 * This class creates the graphical figure and checks the intersections
 */
public class GraphicalFigure implements GraphicalFigureADT{
	private int identifier;
	private int w;
	private int h;
	private String type;
	private Location offset;
	private BinarySearchTree tree;
	//Initializes variables
	
	/**
	 * Constructor method
	 * @param id
	 * @param width
	 * @param height
	 * @param type
	 * @param pos
	 */
	public GraphicalFigure (int id, int width, int height, String type, Location pos) {
		
		this.identifier = id;
		this.h = height;
		this.w = width;
		this.type = type;
		this.offset = pos;
		
		this.tree = new BinarySearchTree();
	}
	
	/**
	 * getter method for width
	 * @return w
	 */
	public int getWidth() {
		return this.w;
	}

	/**
	 * getter method for height
	 * @return h
	 */
	public int getHeight() {
		return this.h;
	}

	/**
	 * getter method for type
	 * @return type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * getter method for id
	 * @return identifier
	 */
	public int getId() { 
		return this.identifier;
	}

	/**
	 * getter method for offset
	 * @return offset
	 */
	public Location getOffset() {
		return this.offset;
	}

	/**
	 * setter method for offset
	 * @param value
	 */
	public void setOffset(Location value) {
		this.offset = value;
		
	}

	/**
	 * setter method for type
	 * @param type
	 */
	public void setType(String t) {
		this.type = t;
		
	}

	/**
	 * inserts pixel into binary search tree associated with the type
	 * @param pix
	 * @throws DuplicatedKeyException
	 */
	public void addPixel(Pixel pix) throws DuplicatedKeyException {
		
		if (findPixel(pix.getLocation()) == false) {
			tree.put(tree.getRoot(), pix);
		}
		else{
			throw new DuplicatedKeyException();
		}
		
	}

	/**
	 * this method checks if the figure intersects
	 * @param fig
	 * @return true if intersects, false if not
	 */
	public boolean intersects(GraphicalFigure fig) {
		
		int x = getOffset().xCoord();
		int y = getOffset().yCoord();
		
		int figx = fig.getOffset().xCoord();
		int figy = fig.getOffset().yCoord();
		
		Pixel s = null;
		
		try {
			s = fig.tree.smallest(tree.getRoot());
		} catch (EmptyTreeException e) {
			e.printStackTrace();
		}
		
		while(tree.successor(tree.getRoot(), s.getLocation()) != null) {
			//searches through tree
			int xLoc, yLoc;
			
			xLoc = s.getLocation().xCoord() + x - figx;
			yLoc = s.getLocation().yCoord() + y - figy;
			
			Location loc = new Location(x, y);
			
			if(fig.findPixel(loc)) {
				return true;
			}
			
			s = tree.successor(tree.getRoot(), s.getLocation());
		}
		
		return false;
	}
	
	/**
	 * finds pixel in the given location
	 * @param p
	 * @return true if exists false otherwise
	 */
	private boolean findPixel(Location p){
		
		Pixel n = tree.get(tree.getRoot(), p);
		
		if (n == null) {
			return false;
		}
		else {
			return true;
		}
	}
}
