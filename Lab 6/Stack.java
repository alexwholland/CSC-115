interface Stack {

    /*
     * Purpose: insert an item onto the top of the stack
     * Parameters: (char) - the item to insert
     * Returns: Nothing
     */
    public void push(char v);

    /*
     * Purpose: removes and returns the top item from the stack
     * Parameters: None
     * Returns: (char) - the data value of the element removed
     */
    public char pop();

    /*
     * Purpose: determines whether the stack is empty
     * Parameters: None
     * Returns: (boolean) - true if the stack is empty, false otherwise
     */
    public boolean isEmpty();

    /*
     * Purpose: Accesses the top item on the stack
     * Parameters: None
     * Returns: (char) - the data value of the top element
     */
    public char top();

}