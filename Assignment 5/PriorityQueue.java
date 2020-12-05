/*
 * PriorityQueue.java
 *
 * A priority queue interface for objects that implement the
 * Comparable interface.
 *
 * This interface considers the minimum value to be the highest
 * priority.
 *
 * This interface isn't using generic Comparable objects because
 * one cannot (easily) create an array of a generic type in Java.
 * Generics only have compile time type checking whereas
 * arrays support runtime type checking.
 *
 * This results in compiler warnings for the heap implementation.
 *
 * It also allows people to insert objects of different types into
 * the same PriorityQueue.  This will result in exceptions
 * being thrown at run-time.
 *
 * It is up to the programmer to only insert objects of one
 * type into an instance of the PriorityQueue.
 */

public interface PriorityQueue {
    /*
     * PURPOSE:
     *	Adds element into the PriorityQueue at the position
     *	according to the element's priority 	.
     *
     * PRECONDITIONS:
     *	None.
     *
     * RETURNS:
     *	None.
     *
     * Examples:
     * 	If q contains elements that would be accessed in the
     * 	following order:  {5,13,21} after q.insert(20) returns,
     * 	then q will contain elements that will be accessed
     * 	in the following order: {5,13,20,21}.
     *
     */
    public void insert(Comparable element);

    /*
     * PURPOSE:
     *	Remove highest priority element from the PriorityQueue,
     *	where the smallest value will be of highest priority.
     *
     * PRECONDITIONS:
     *	None.
     *
     * RETURNS:
     *	Comparable - the highest priority object in the Queue
     *
     * Examples:
     * 	If q contains elements that would be accessed in the
     * 	following order:  {5,13,21},  q.removeLow() returns 5,
     * 	and then q will contain elements that will be accessed
     * 	in the following order: {13,21}.
     *
     */
    public Comparable removeMin();

    /*
     * PURPOSE:
     *	Determines if the PriorityQueue is empty or not.
     *
     * PRECONDITIONS:
     *	none
     *
     * RETURNS:
     *	true if PriorityQueue is empty, false otherwise.
     *
     */
    public boolean isEmpty();

    /*
     * PURPOSE:
     *	Determines number of elements in the PriorityQueue.
     *
     * PRECONDITIONS:
     *	None.
     *
     * RETURNS:
     *	the size of the PriorityQueue.
     *
     */
    public int	size ();

}
 