/*
 * PriorityQueue.java
 *
 * A priority queue interface that considers the element with
 * the maximum key value (frequency) to be the highest priority.
 */
 
public interface PriorityQueue<K extends Comparable<K>, V> {
	
	/*
	 * Purpose: Add element to priority queue according to priority
	 * Parameters: Entry element - element to be added
	 * Returns: Nothing
	 * Example:
	 * 	If the priority queue contains keys that would be accessed 
	 *  in the following order: {21,13, 5} after q.insert(20) returns,
	 * 	then the priority queue  will contain elements that will be 
	 *  accessed in the following order: {21,20,13,5}.
	 */
	public void insert(Entry<K,V> element);

	/*
	 * Purpose: Removes and returns the highest priority element
	 * Parameters: None
	 * Returns: Entry - the element with the highest priority 
	 * Examples
	 * 	If the priority queue contains elements that would be accessed 
	 *  in the following order: {21,13,5}, q.removeMax() returns 21,
	 * 	and then the priority queue will contain elements that will be 
	 *  accessed in the following order: {13,5}.
	 *
	 */
	public Entry<K, V> removeMax();

	/*
	 * Purpose: Determines whether the priority queue is empty
	 * Parameters: None
	 * Returns: boolean - true if the priority queue is empty, false otherwise
	 */
	public boolean isEmpty();	

	/*
	 * Purpose: Determines the number of elements in the priority queue
	 * Parameters: None
	 * Returns: int - the current number of elements in the priority queue
	 */		
	public int size();

}
 
