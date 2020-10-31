public class Node<T>{
	    
	private T data;
	protected Node<T> next;

	public Node (T value) {
		this.data = value;
		this.next = null;
	}

	/* Parameters: nothing
	 * Purpose:  get the data value of this Node
	 * Returns:  int - the value
	 */
	public T getData() {
		return data;
	}

	/* Parameters: nothing
	* Purpose:  get the next of this Node
	* Returns:  (Node) the next
	*/
	public Node<T> getNext() {
		return next;
	}

	/* Parameters: Node next
	 * Purpose:  set the next of this Node to next
	 * Returns:  nothing
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

}