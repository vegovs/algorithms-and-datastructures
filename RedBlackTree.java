import java.util.Comparator;

public class RedBlackTree<Key extends Comparable<Key>>{

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	/* Red black tree helper class */
	private class RBTNode{
		public Key key;
		public RBTNode left, right;

		public RBTNode(Key key){
			this.key = key;
			this.left = null;
			this.right = null;
		}

		public String toString(){
			return "Node: " + key.toString();
		}

	}
    public RedBlackTree() {
        this(null);
    }

    public RedBlackTree(Comparator c) {
        super(c);
    }
}
