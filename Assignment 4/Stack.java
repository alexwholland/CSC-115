interface Stack<T> {
	
	/*
	 * Purpose: Insert an item onto the top of the stack
	 * Parameters: (int) - the item to insert 
	 * Returns: Nothing
	 * Throws: FullStackException if array is full
	 */
	public void push(T v); 
	
	/*
	 * Purpose: Removes and returns the top item from the stack
	 * Parameters: None
	 * Returns: (int) - the data value of the element removed
	 * Throws: EmptyStackException if array is empty
	 */
	public T pop();
	
	/*
	 * Purpose: Determines whether the stack is empty
	 * Parameters: None
	 * Returns: (boolean) - true if the stack is empty, false otherwise
	 */
	public boolean isEmpty();
	
	
	/*
	 * Purpose: Accesses the top item on the stack
	 * Parameters: None
	 * Returns: (int) - the data value of the top element
	 * Throws: EmptyStackException if array is empty
	 */
	public T top();
	
	/*
	 * Purpose: Removes all elements from the stack 
	 * Parameters: None
	 * Returns: Nothing
	 */
	public void popAll();

}