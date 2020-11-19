import java.lang.Math;
import java.util.LinkedList;
/*
 * RefBasedBinaryTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinaryTree implements BinaryTree {
    protected TreeNode root;

    public RefBasedBinaryTree() {
        this.root = null;
    }

    public void insert(Integer value){
        if (root == null)
            root = new TreeNode(value);
        else
            insert(null, root, value);

    }
    // not a balanced insert
    private void insert(TreeNode parent, TreeNode t, Integer value) {
        if (t==null) {
            if(parent.getLeft() == null) {
                parent.setLeft(new TreeNode(value));
            } else {
                parent.setRight(new TreeNode(value));
            }
        }  else {
            int htLeft = height(t.getLeft());
            int htRight = height(t.getRight());
            if (htLeft>htRight) {
                insert(t, t.getRight(), value);
            } else {
                insert(t, t.getLeft(), value);
            }
        }
    }

    private int height(TreeNode t) {
        if (t == null) {
            return -1;
        } else {
            int highest = Math.max(height(t.getLeft()), height(t.getRight()));
            return 1 + highest;
        }
    }

    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following an in-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }

    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following an in-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void inOrder(TreeNode t){
        if (t == null)
            return;
        else {
            inOrder(t.getLeft());
            System.out.print(t.getValue() + " ");
            inOrder(t.getRight());
        }
    }

    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following a pre-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }

    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following a pre-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void preOrder(TreeNode t){
        if (t == null)
            return;
        else {
            System.out.print(t.getValue() + " ");
            preOrder(t.getLeft());
            preOrder(t.getRight());
        }
    }

    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following a post-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }

    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following a post-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void postOrder(TreeNode t){
        if (t == null)
            return;
        else {
            postOrder(t.getLeft());
            postOrder(t.getRight());
            System.out.print(t.getValue() + " ");
        }
    }

    public void levelOrder() {
        if (root == null) {
            return;
        }
        int height = height(root);
        for (int i = 1; i <= height + 1; i++) {
            printLevel(root, i);
        }
        System.out.println();
    }

    private void printLevel(TreeNode t, int level) {
        if (t == null) {
            return;
        }
        if (level == 1) {
            System.out.print(t.getValue() + " ");
        }
        else {
            printLevel(t.getLeft(), level - 1);
            printLevel(t.getRight(), level - 1);
        }
    }

    public int sum() {
        return sum(root);
    }

    private int sum(TreeNode t) {
        if (t == null) {
            return 0;
        }
        else {
            int s = 0;

            s += sum(t.getLeft());
            s += t.getValue();
            s += sum(t.getRight());

            return s;
        }
    }

    public boolean find(int value) {
        return find(value, root);
    }

    private boolean find(int value, TreeNode t) {
        if (t == null) {
            return false;
        }
        if (t.getValue() == value) {
            return true;
        }
        if (find(value, t.getLeft())) {
            return true;
        }
        return find(value, t.getRight());
    }

    public int getMax() throws TreeEmptyException {
        if (root == null) {
            throw new TreeEmptyException();
        }
        else {
            int max = root.getValue();
            max = getMax(max, root);
            return max;
        }
    }

    private int getMax(int current, TreeNode t) {
        if (t == null) {
            return current;
        }
        System.out.println("value " + t.getValue());
        if (current < t.getValue()) {
            current = t.getValue();
        }
        current = getMax(current, t.getLeft());
        current = getMax(current, t.getRight());
        return current;
    }

    /*
     * Purpose: returns a String reprensentation of this BinaryTree
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        return toString(root);
    }

    private String toString(TreeNode t) {
        if(t==null)
            return "";
        else {
            String s = "";

            s += toString(t.getLeft());
            s += t.getValue() + " ";
            s += toString(t.getRight());

            return s;
        }
    }


    public static void main(String[] args) {
        // use these trees to test the methods you will implement in Part II
        RefBasedBinaryTree emptyTree = new RefBasedBinaryTree();
        RefBasedBinaryTree myTree = new RefBasedBinaryTree();
        for(int i=2; i<8; i++) {
            myTree.insert(i);
        }
    }

}