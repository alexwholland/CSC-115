/*
 * Assignment 5
 * Alex Holland - V00928553
 */

/*
 * HeapPriorityQueue.java
 *
 * An implementation of a minimum PriorityQueue using a heap.
 * based on the implementation in "Data Structures and Algorithms
 * in Java", by Goodrich and Tamassia
 *
 * This implementation will throw a Runtime, HeapEmptyException
 *	if the heap is empty and removeLow is called.
 *
 * This implementation will throw a Runtime, HeapFullException
 *	if the heap is full and insert is called.
 *
 */

public class HeapPriorityQueue implements PriorityQueue {

    protected final static int DEFAULT_SIZE = 10000;

    protected Comparable[] storage;
    protected int currentSize;

    /* constructor
     *
     * PURPOSE:
     *  initializes storage to new Comparable[] of DEFAULT_SIZE
     *      and initializes currentSize to 0
     *
     * PARAMETERS:
     *  none
     */
    public HeapPriorityQueue() {
        storage = new Comparable[DEFAULT_SIZE];
        currentSize = 0;
    }

    
    /* constructor
     *
     * PURPOSE:
     *  initializes storage to new Comparable[] of given size
     *      and initializes currentSize to 0
     *
     * PARAMETERS:
     *  int size
     */
    public HeapPriorityQueue(int size) {
        storage = new Comparable[size];
        currentSize = 0;
    }

    public void insert (Comparable element) throws HeapFullException {

        int position = currentSize;
        if (storage.length <= currentSize){
            throw new HeapFullException();
        }
        storage[currentSize] = element;
        //While the element is less than the parent
        while (storage[position].compareTo(storage[parent(position)]) < 0){
            //Hold the parent value
            Comparable parentVal = storage[parent(position)];
            //Set the parent value to the element value
            storage[parent(position)] = storage[position];
            //Set the child to the parent value
            storage[position] = parentVal;
            //Set the parent position to the current position
            position = parent(position);
            //Terminate the loop if the element if less greater than or equal to it's parent
            if (storage[position].compareTo(storage[parent(position)]) >= 0){
                break;
            }
        }
        currentSize += 1;
    }
    

    public Comparable removeMin() throws HeapEmptyException{
        int count = 0;

        if(isEmpty()) {
            throw new HeapEmptyException();
        }

        Comparable highest = storage[0];
        //Set the head to the last element in the heap
        storage[0] = storage[currentSize-1];
        //Remove the last element in the heap
        storage[currentSize-1] = null;

        try {
            //While there is at least a left child
            while((storage[leftChild(count)] != null)) {
                //Right child is null *OR* the left child is smaller than the right child
                if(storage[rightChild(count)]==null
                        || storage[leftChild(count)].compareTo(storage[rightChild(count)]) <= 0) {
                    //If parent is greater than the left child
                    if(storage[count].compareTo(storage[leftChild(count)]) >= 0) {
                        //Swap parent with the left child
                        count = swapLeftChild(count);
                    //terminate the loop if the parent is less than the left child
                    }else /*if (storage[count].compareTo(storage[leftChild(count)]) < 0)*/ {
                        break;
                    }
                }
                //If the right child is less than the left child
                else if (storage[rightChild(count)].compareTo(storage[leftChild(count)]) < 0) {
                    //If the parent is greater than or equal to the right child
                    if (storage[count].compareTo(storage[rightChild(count)]) >= 0) {
                        //Swap the the parent with the right child
                        count = swapRightChild(count);
                        //Terminate the loop if the parent is less than the right child
                    } else/* if (storage[count].compareTo(storage[rightChild(count)]) < 0)*/ {
                        break;
                    }
                }
            }
        }catch(Exception exception){
            //System.out.println("Exception occurred");
            //exception
        }
        //decrease size of heap
        currentSize -= 1;
        return highest;
    }

    public boolean isEmpty(){
        return storage[0] == null;
    }

    public int size () {
        return currentSize;
    }

	/*
	Purpose: Helper Methods to move parent down to the left/right and the child
	         to the place of that parent.
    Parameters: int - count.
    Returns: int - count.
	 */

    public int swapLeftChild(int count){
        Comparable parent = storage[(count)];
        storage[count] = storage[leftChild(count)];
        storage[leftChild(count)] = parent;
        count = leftChild(count);
        return count;
    }
    public int swapRightChild(int count){
        Comparable parent = storage[(count)];
        storage[count] = storage[rightChild(count)];
        storage[rightChild(count)] = parent;
        count = rightChild(count);
        return count;
    }

	/*
	Helper methods to iterate through the heap of a 0 based array.
	 */

    private int parent(int size){
        return (size - 1) / 2;
    }
    private int leftChild(int size){
        return (size * 2) + 1;
    }
    private int rightChild(int size){
        return (size * 2) + 2;
    }

	/*
	Helper methods to iterate through the heap of a 1 based array.
	 */

    private int parent1(int size){
        return 2*size;
    }
    private int leftChild1(int size){
        return 2*size + 1;
    }
    private int rightChild1(int size) {
        return size / 2;
    }

    public String toString() {
        String s = "";
        String sep = "";
        for(int i=0;i<currentSize;i++) {
            s += sep + storage[i];
            sep = " ";
        }
        return s;
    }

}