public class RedBlackTree extends BinarySearchTree {

    /**
     * Constructs an empty RedBlackTree that can only accept Comparables as
     * items.
     */
    public RedBlackTree() {
        this(null);
    }

    /**
     * Constructs an empty RedBlackTree that orders its items according to the
     * given comparator.
     */
    public RedBlackTree(Comparator c) {
        super(c);
    }
}
