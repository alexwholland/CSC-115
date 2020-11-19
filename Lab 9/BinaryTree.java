public interface BinaryTree {

    /*
     * Purpose: inserts value into this BinaryTree
     * Parameters: Integer value - to be in inserted
     * Returns: Nothing
     */
    public void insert(Integer value);


    /*
     * Purpose: prints each value in this BinaryTree
     *          following an in-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void inOrder();


    /*
     * Purpose: prints each value in this BinaryTree
     *          following a pre-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void preOrder();



    /*
     * Purpose: prints each value in this BinaryTree
     *          following a post-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void postOrder();



    /*
     * Purpose: returns a String reprensentation of this BinaryTree
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString();


}