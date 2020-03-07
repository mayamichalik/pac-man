/**
 * @author Maya Michalik
 * November 15 2019
 * this class creates an ordered tree
 */
public class BinarySearchTree implements BinarySearchTreeADT{
	 private BinaryNode r;
	
	 /**
	  * constructor method
	  */
	public BinarySearchTree(){
		r = new BinaryNode();
	}
	
	/**
	 * returns pixel storing the given key
	 * @param r
	 * @param key
	 */
	public Pixel get(BinaryNode r, Location key){
		return search(r,key).getData();
	}
	
	/**
	 * inserts given data to the tree
	 * @param r
	 * @param data
	 * @throws DuplicatedKeyException
	 */
	public void put(BinaryNode r, Pixel data) throws DuplicatedKeyException{
		 
		 BinaryNode p = search(r,data.getLocation());
		 //gets the node position
		 
		 if (! p.isLeaf()){
			 throw new DuplicatedKeyException();
		 }
		 
		 else{
			p.setData(data);
			BinaryNode c1 = new BinaryNode();
			BinaryNode c2 = new BinaryNode();
			p.setLeft(c1);
			p.setRight(c2);
			c1.setParent(p);
			c2.setParent(p);	
			//creates 2 nodes and sets them as children of p
		 }
	}
	
	/**
	 * removes the data with the given key
	 * @param r
	 * @param key
	 * @throws InexistentKeyException
	 */
	public void remove(BinaryNode r, Location key) throws InexistentKeyException {
		
		BinaryNode p = search(r,key);
		if (p.isLeaf()){
			throw new InexistentKeyException();
		}
		
		else{
			if (p.getLeft().isLeaf() || p.getRight().isLeaf()){
			//at least one child is a leaf
				
				if(p.getLeft().isLeaf()){
				//if left is leaf
					
					BinaryNode c1 = p.getRight();
					BinaryNode par = p.getParent();
			
					if (par == null){
						this.r = c1;
						c1.setParent(null);
						//new node is a root
					}
					
					else{
						if(par.getRight().equals(p)){
							par.setRight(c1);
							c1.setParent(par);
						}
						else{
							par.setLeft(c1);
							c1.setParent(par);
						//child is not a leaf
						}
					}
				}
			
				else{
					//same as above but for right
					BinaryNode c2 = p.getLeft();
					BinaryNode par = p.getParent();

					if (par == null){
						this.r = c2;
						c2.setParent(null);
					}
					else{
				
						if(par.getRight().equals(p)){
							par.setRight(c2);
							c2.setParent(par);
						}
						else{
							par.setLeft(c2);
							c2.setParent(par);
						}
					}
				}
			}
			
			else{
				//node is internal
				BinaryNode small = searchSmall(p.getRight());
				p.setData(small.getData());
				//find smallest of right subtree
				
				if(small.getParent().getLeft().equals(small)){
					small.getParent().setLeft(small.getRight());
				}
				
				else{
					small.getParent().setRight(small.getRight());
				}
				
				small.getRight().setParent(small.getParent());
			}
			
		}
		
	}
	
	/**
	 * finds pixel with the smallest key larger than the given
	 * @param r
	 * @param key
	 * @return pixel with the smallest key > than given
	 */
	public Pixel successor(BinaryNode r, Location key) {

		if (r.isLeaf()){
			return null;
		}
		
		else{
			BinaryNode p = search(r,key);
			
			if (!p.isLeaf() && !p.getRight().isLeaf()){
				return searchSmall(p.getRight()).getData();
				//if right is not leaf find the smallest
			}
			else{
				BinaryNode par = p.getParent();
				
				while(par != null && par.getRight() == p){
					p = par;
					par = par.getParent();
					//check parents
				}
				if(par!= null){
					return par.getData();
				}
				else{
					return null;
				}
			}
		}
			
	}


	/**
	 * finds pixel with the largest key smaller than the given
	 * @param r
	 * @param key
	 * @return pixel with largest key < given
	 */
	public Pixel predecessor(BinaryNode r, Location key) {
	//same as above but for larger
		if(r.isLeaf()){
			return null;
		}
		else{
			BinaryNode p = search(r,key);
			
			if (!p.isLeaf() && !p.getLeft().isLeaf()){
				return searchLarge(p.getLeft()).getData();
		}
		  else{
			  BinaryNode par = p.getParent();
			 
			  while ( par!= null && par.getLeft()==(p)){
				  p = par;  
				  par = par.getParent();
			  }
			  if(par != null){
				  return par.getData();
			  }
			  else return null;
		  }
		}
		
	}
	
	/**
	 * finds pixel with smallest key
	 * @param r
	 * @return pixel with smallest key
	 */
	public Pixel smallest(BinaryNode r) throws EmptyTreeException {
		
		if (r.isLeaf())
			throw new EmptyTreeException();
		
		else{
			return searchSmall(r).getData();
		}
	}

	public BinaryNode getRoot(){
		return r;
	}
	
	/**
	 * finds pixel with largest key
	 * @param r
	 * @return pixel with largest key
	 */
	public Pixel largest(BinaryNode r) throws EmptyTreeException {
	
		if (this.getRoot().isLeaf())
			throw new EmptyTreeException();
		
		else{
			return searchLarge(r).getData();
		}
	}


	/**
	 * helper method that searches for node with the given key
	 * @param n
	 * @param key
	 * @return node with given key
	 */
	private BinaryNode search(BinaryNode n, Location key){
		if (n.isLeaf()){
			return n;
		}
		else{
			if (n.getData().getLocation().compareTo(key) == 0){
				return n;
			}
			
			else if (n.getData().getLocation().compareTo(key) == 1){
				return search(n.getLeft(),key);
			}
			
			else {
				return search(n.getRight(),key);
			}
		}
	}
	
	/**
	 * helper method for getting smallest node
	 * @param r
	 * @return p.getParent()
	 */
	private BinaryNode searchSmall(BinaryNode r){
		if (r.isLeaf()){
			return null;
		}
		else{
			BinaryNode p = r;
			
			while (!p.isLeaf()){
				p = p.getLeft();
			}
			
			return p.getParent();
		}
	}
	
	/**
	 * helper method for getting the largest node
	 * @param r
	 * @return p.getParent()
	 */
	private BinaryNode searchLarge(BinaryNode r){

		if(r.isLeaf()){
			return null;
		}
		else{
			BinaryNode p = r;
			
			while(!p.isLeaf()){
				p = p.getRight();
			}
			
			return p.getParent();
		}
	}

}
