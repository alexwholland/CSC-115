import java.util.*;

public class MaxFrequencyHeap<K extends Comparable<K>, V> implements PriorityQueue<K,V>{
	
	private LinkedList<Entry<K,V>> data;

	
	public MaxFrequencyHeap() {
		data = new LinkedList<Entry<K,V>>();
	}

	public void insert(Entry<K,V> element) {
		data.add(element);
		bubbleUp(data.size()-1);
	}
	
	private void bubbleUp(int index) {
		if (index > 0) {
			int parentIndex = (index-1)/2;
			if (data.get(index).compareTo(data.get(parentIndex)) > 0) {
				swap(index, parentIndex);
				bubbleUp(parentIndex);
			}
		}
	}

	public Entry<K, V> removeMax() { 
		Entry<K,V> maxElement = data.removeFirst();
		if (data.size() > 1) {
			data.addFirst(data.removeLast());
			bubbleDown(0);
		}
		return maxElement;
	}
	
	private void bubbleDown(int index) {
		if (!isLeaf(index)) {
			int maxChildIndex = maxChild(index);
			if (data.get(index).compareTo(data.get(maxChildIndex)) < 0) {
				swap(index, maxChildIndex);
				bubbleDown(maxChildIndex);
			}
		}
	}

	public boolean isEmpty() {
		return data.size()==0;
	}
	
	public int size() {
		return data.size();
	}

	/*
	 * Purpose: Determines if the node at given index is a leaf node
	 * Parameters: int index - index of current node 
	 * Returns: boolean - true if leaf, false otherwise
	 */
	private boolean isLeaf(int index) {
		return (2*(index+1)) > data.size();
	}
	
	/*
	 * Purpose: Gets the index of the child with the highest priority
	 * Parameters: int index - index of current node (parent of children)
	 * Returns: int - index of child with the highest priority
	 */
	public int maxChild(int index) {
		int leftIndex = 2*index+1;
		int rightIndex = (2*index)+2;
		if ((rightIndex+1<=data.size()) && (data.get(rightIndex).compareTo(data.get(leftIndex)) > 0)) {
			return rightIndex;
		} else {
			return leftIndex;
		}
	}
	
	public void swap(int pos1, int pos2) {
		Entry<K,V> temp1 = data.get(pos1);
		Entry<K,V> temp2 = data.get(pos2);
		data.set(pos1, temp2);
		data.set(pos2, temp1);
	}
}
 
