/**
 * @author Maya Michalik
 * November 15 2019
 * this class represents the node of the binary search tree which is a pixel object
 */

public class BinaryNode {
	
	private Pixel val;
	private BinaryNode left;
	private BinaryNode right;
	private BinaryNode par;
	//Initializes variables
	
	/**
	 * a constructor method 
	 * @param value
	 * @param left
	 * @param right
	 * @param parent
	 */
	 public BinaryNode (Pixel value, BinaryNode left, BinaryNode right, BinaryNode parent) {
		 
		 this.val = value;
		 this.left = left;
		 this.right = right;
		 this.par = parent;
	 }
	 
	 /**
	  * a constructor method for leaf nodes
	  */
	 public BinaryNode () {
		 	
		this.val = null;
		this.left = null;
		this.right = null;
		this.par = null;
		
	 }
	 
	 /**
	  * getter method for parent
	  * @return par
	  */
	 public BinaryNode getParent() {
		return this.par;
		 
	 }
	 
	 /**
	  * setter method for parent
	  * @param parent
	  */
	 public void setParent(BinaryNode parent) {
		 this.par = parent;
	 }
	 
	 /**
	  * setter method for left node
	  * @param p
	  */
	 public void setLeft (BinaryNode p) {
		 this.left = p;
	 }
	 
	 /**
	  * setter method for right node
	  * @param p
	  */
	 public void setRight (BinaryNode p) {
		 this.right = p;
	 }
	 
	 /**
	  * setter method for the data
	  * @param value
	  */
	 public void setData (Pixel value) {
		 this.val = value;
	 }
	 
	 /**
	  * checks if node is a leaf
	  * @return true if leaf false if not
	  */
	 public boolean isLeaf() {
		 if (this.getLeft() == null && this.getRight() == null){
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
	 
	 /**
	  * getter method for data
	  * @return val
	  */
	 public Pixel getData () {
		return this.val;
		 
	 }
	 
	 /**
	  * getter method for left node
	  * @return left
	  */
	 public BinaryNode getLeft() {
		return this.left; 
	 }
	 
	 /**
	  * getter method for right node
	  * @return right
	  */
	 public BinaryNode getRight() {
		return this.right;
	 }

}
