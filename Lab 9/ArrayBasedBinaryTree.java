public class ArrayBasedBinaryTree implements BinaryTree {
    private static final int CAPACITY = 100;
    protected Integer[] data;
    protected int root;
    protected int size;

    public ArrayBasedBinaryTree() {
        this.data = new Integer[CAPACITY];
        root = 0;
        size = 0;
    }

    public void insert(Integer value) {
        data[size++] = value;
    }

    protected int getLeft(int t) {
        return 2*t+1;
    }

    protected int getRight(int t) {
        return 2*t+2;
    }

    /*
     * Purpose: prints each value in this BinaryTree
     *          following an in-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }

    /*
     * Purpose: prints each value in the BinaryTree at index t
     *          following an in-order traversal
     * Parameters: int t - index of t's root
     * Returns: Nothing
     */
    private void inOrder(int t){
        if (data[t]==null)
            return;
        else {
            inOrder(getLeft(t));
            System.out.print(data[t] + " ");
            inOrder(getRight(t));
        }
    }

    /*
     * Purpose: prints each value in this BinaryTree
     *          following a pre-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }

    /*
     * Purpose: prints each value in the BinaryTree at index t
     *          following a pre-order traversal
     * Parameters: int t - index of t's root
     * Returns: Nothing
     */
    private void preOrder(int t){
        if (data[t]==null)
            return;
        else {
            System.out.print(data[t] + " ");
            preOrder(getLeft(t));
            preOrder(getRight(t));
        }
    }


    /*
     * Purpose: prints each value in this BinaryTree
     *          following a post-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }

    /*
     * Purpose: prints each value in the BinaryTree at index t
     *          following a post-order traversal
     * Parameters: int t - index of t's root
     * Returns: Nothing
     */
    private void postOrder(int t){
        if (data[t]==null)
            return;
        else {
            postOrder(getLeft(t));
            postOrder(getRight(t));
            System.out.print(data[t] + " ");
        }
    }


    /*
     * Purpose: returns a String reprensentation of this BinaryTree
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        return toString(root);
    }

    private String toString(int t) {
        if (data[t] == null)
            return "";

        String s = "";
        s += toString(getLeft(t));
        s += data[t] + " ";
        s += toString(getRight(t));


        return s;
    }


    public static void main(String[] args) {

        ArrayBasedBinaryTree myTree = new ArrayBasedBinaryTree();
        for(int i=2; i<8; i++) {
            myTree.insert(i);
        }
        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();

        System.out.println("toString\n" + myTree);
    }

}