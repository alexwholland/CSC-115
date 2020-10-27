public interface Queue <T> {
    /*
     * Purpose:
     *   return the number of items currently pushed onto the queue.
     *
     * Returns:
     *   the number of items in the queue
     *
     * Examples:
     *
     * If q is {x, y, z}:
     *    q.size() returns 3.
     * If q is {}:
     *    q.size() returns 0.
     */
    int size();


    /*
     * Purpose:
     *   returns the boolean state of the queue (empty or not empty)
     *
     * Returns:
     *   true if queue is empty, false otherwise
     *
     * Examples:
     *
     * If q is {x, y, z}:
     *    q.isEmpty() returns false.
     * If q is {}:
     *    q.isEmpty() returns true.
     */
    boolean isEmpty();


    /*
     * Purpose:
     *   places the values passed as a parameter onto the back of
     *   the queue.
     *
     * Returns:
     *   nothing.
     *
     * Examples:
     *
     * If q is {x, y, z}:
     *   then after q.enqueue(a), q is {x, y, z, a} (i.e., front of the queue
     *   is the left-most value in the sequence, back of the queue is
     *   the right-most value in the sequence}.
     * If q is {}:
     *   then after enqueue(a), q is {a}.
     */
    void enqueue (T element);


    /*
     * Purpose:
     *   removes the value at the front of the queue (if it exists),
     *   and returns it to the caller. If the queue was empty before
     *   the call, then an exception is thrown by the method.
     *
     * Returns:
     *   The value of type int at the front of the queue (if queue is
     *   non-empty)
     *
     * Precondition:
     *    q is not empty
     *
     * Examples:
     *
     * If q is {x, y, z}:
     *    then after q.dequeue(), q is {y, z} and x is returned to the
     *    caller.
     */
    T dequeue();



    /*
     * Purpose:
     *   returns the value at the front of the queue (if it exists)
     *   but does not modify the contents of the queue. If the queue
     *   was empty before the call, then an exception is thrown
     *   by the method.
     *
     * Returns:
     *   The value of type int at the front of the queue (if queue is
     *   non-empty)
     *
     * Precondition:
     *    q is not empty
     *
     * Examples:
     *
     * If q is {x, y, z}:
     *    then after q.peek(), q is {x, y, z} and x is returned to the
     *    caller.
     */
    T peek();


    /*
     * Purpose:
     *   clear the queue of all its content.
     *
     * Returns:
     *   nothing.
     *
     * Examples:
     *
     * If q is {x, y, z}
     *   then after q.makeEmpty(), q is {}.
     * If q is {}:
     *   then after q.makeEmpty(), q is {}.
     */
    void makeEmpty();
}