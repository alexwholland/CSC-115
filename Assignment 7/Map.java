import java.util.*;

public interface Map<K extends Comparable<K>, V> {

    /*
     * Purpose:
     * 	Check to see if key is stored in the map.
     *
     * Pre-conditions:
     *	None.
     *
     * Returns:
     * 	true if key is in the map, false otherwise.
     *
     */
    boolean containsKey(K key);

    /*
     * Purpose:
     * 	Return the value stored at key in the map
     *
     * Pre-conditions:
     * 	None.
     *
     * Returns:
     *	the value stored at key.
     *
     * Throws:
     *	KeyNotFoundException if key is not in the map.
     *
     */
    V get (K key) throws KeyNotFoundException;

    /*
     * Purpose:
     * 	Return a List of Entry types which contain the
     *	key/value pairs of every entry in the map.
     *
     * Pre-conditions:
     * 	None.
     *
     * Returns:
     *	An instance of List with all the key/value pairs in
     *	the map.
     */
    List<Entry<K,V> >	entryList();

    /*
     * Purpose:
     *	Insert the key/value pair into the map.
     *	If the key already exists in the map, instead
     *	update the entry to include the new value.
     *
     * Pre-conditions:
     *	None.
     *
     * Examples:
     *	if m is {("hello", 5)} and m.put("joe",8") is called
     *	then m is: {("hello", 5), ("joe",8)}
     *
     *	if m is {("hello", 5)} and m.put("hello", 99) is called
     *	then m is {("hello", 99)}
     *
     *	NOTE: 	Maps do not provide ordering, so these examples
     * 		have chosen an arbitrary ordering.  Your implementation
     *		may store items in a different order than the examples.
     */
    void put (K key, V value);

    /*
     * Purpose:
     *	Return the number of elements in the Map.
     *
     * Pre-conditions:
     *	None.
     *
     * Returns:
     * 	the number of elements in the map, 0 if empty.
     */
    int size();

    /*
     * Purpose:
     * 	Remove all elements from the map.
     *
     * Pre-conditions:
     *	None.
     */
    void clear();

    /*
     * These methods will be used for Part 3 of the assignment.
     *
     * We will be keeping track of how many loops iterations are made
     * in the Get and Put methods.
     *
     * Note: In your Binary Search Tree, Get corresponds to Find
     *	     and Put corresponds to Insert.
     */
    public long getGetLoopCount();
    public long getPutLoopCount();

    public void resetGetLoops();
    public void resetPutLoops();
}