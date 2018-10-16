/* Binary search tree class */
public class BinarySearchTree<Key extends Comparable<Key>>{
	BSTNode root;

	/* Binary search tree helper class */
	private class BSTNode{
		public Key key;
		public BSTNode left, right;

		public BSTNode(Key key){
			this.key = key;
			this.left = null;
			this.right = null;
		}

		public String toString(){
			return "Node: " + key.toString();
		}

	}


	public BinarySearchTree(){
		root = null;
	}

	public BinarySearchTree(Key key){
		root = new BSTNode(key);
	}

	/* Calls recursive insert function */
	void insert(Key key){
		root = insert(root,key);
	}

	/* Recursive insertions function */
	public BSTNode insert(BSTNode focus, Key key){
		/* If empty tree */
		if(focus == null){
			focus = new BSTNode(key);
			return focus;
		}

		if(key.compareTo(focus.key) < 0){
			focus.left = insert(focus.left, key);
		}
		else if(key.compareTo(focus.key) > 0){
			focus.right = insert(focus.right, key);
		}

		return focus;
	}

	/* Calls Recursive search function from root*/
	public BSTNode search(Key key){
		return search(root, key);
	}

	/* Recursive search function */
	public BSTNode search(BSTNode focus, Key key){
		if(focus == null){
			return null;
		}
		else if(key.compareTo(focus.key) < 0){
			return search(focus.left, key);
		}
		else if(key.compareTo(focus.key) > 0){
			return search(focus.right, key);
		}
		else{
			return focus;
		}
	}

	/* Calls Recursive in-order traversal with printing from root*/
	public void inOrderTraversal(){
		inOrderTraversal(root);
	}

	/* Recursive in-order traversal with printing */
	public void inOrderTraversal(BSTNode focus){
		if(focus != null){
			inOrderTraversal(focus.left);
			System.out.println(focus);
			inOrderTraversal(focus.right);
		}
	}

	/* Calls Recursive pre-order traversal with printing from root*/
	public void preOrderTraversal(){
		preOrderTraversal(root);
	}

	/* Recursive pre-order traversal with printing */
	public void preOrderTraversal(BSTNode focus){
		if(focus != null){
			System.out.println(focus);
			inOrderTraversal(focus.left);
			inOrderTraversal(focus.right);
		}
	}

	/* Calls Recursive post-order traversal with printing from root*/
	public void postOrderTraversal(){
		postOrderTraversal(root);
	}

	/* Recursive post-order traversal with printing */
	public void postOrderTraversal(BSTNode focus){
		if(focus != null){
			inOrderTraversal(focus.left);
			inOrderTraversal(focus.right);
			System.out.println(focus);
		}
	}

	/* Recursive delete function from root*/
	public BSTNode delete(Key key){
		return delete(root, key);
	}

	/* Recursive delete function */
	public BSTNode delete(BSTNode focus, Key key){
		/* If empty tree */
		if(focus == null){
			return null;
		}

		/* Traverse */
		if(key.compareTo(focus.key) < 0){
			focus.left = delete(focus.left, key);
		}
		else if(key.compareTo(focus.key) > 0){
			focus.right = delete(focus.right, key);
		}

		else{
			/* If one child.. */
			if(focus.left == null){
				return focus.right;
			}
			/* ..or no children */
			else if(focus.right == null){
				return focus.left;
			}

			/* If two children */
			focus.key = min(root.right).key;
			focus.right = delete(focus.right, focus.key);

		}

		return focus;
	}

	/* Returns node with smallest key value */
	public BSTNode min(BSTNode focus){
		BSTNode ret = focus;
		while(focus.left != null){
			ret = focus.left;
			focus = focus.left;
		}

		return ret;
	}

	/* Main function for testing */
	public static void main(String[] args){

		BinarySearchTree bst = new BinarySearchTree(8);
        bst.insert(6); 
        bst.insert(2); 
        bst.insert(5); 
        bst.insert(1); 
        bst.insert(3); 
        bst.insert(4); 
  
        System.out.println("Inorder traversal"); 
        bst.inOrderTraversal(); 
  
        System.out.println("Find 7 --> " + bst.search(7)); 

        System.out.println("Insert 7"); 
        bst.insert(7); 

        System.out.println("Find 7 --> " + bst.search(7)); 

        System.out.println("Inorder traversal"); 
        bst.inOrderTraversal(); 

        System.out.println("Delete 4"); 
        bst.delete(4); 

        System.out.println("In-order traversal"); 
        bst.inOrderTraversal(); 

        System.out.println("Pre-order traversal"); 
        bst.preOrderTraversal(); 

        System.out.println("Post-order traversal"); 
        bst.postOrderTraversal(); 

    } 
}
