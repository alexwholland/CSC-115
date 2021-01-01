/*
Alex Holland
 */

import java.util.*;

/*
 * An implementation of a binary search tree.
 *
 * This tree stores both keys and values associated with those keys.
 *
 * More information about binary search trees can be found here:
 *
 * http://en.wikipedia.org/wiki/Binary_search_tree
 *
 */ 
class WordFrequencyBST <K extends Comparable<K>, V>  {

	private static int testPassCount = 0;
	private static int testCount = 0;

	public static final int BST_PREORDER  = 1;
	public static final int BST_POSTORDER = 2;
	public static final int BST_INORDER   = 3;

	private TreeNode<K,V> root;
	private int numElements;

	public WordFrequencyBST(){
		root = null;
		numElements = 0;
	}


	/*
	 * Purpose: Update the BST by handling input word 
	 * Parameters: K key - The key to handle
	 * Returns: Nothing
	 * Explanation: If there is no element in the tree 
	 *   with the given key, then the a new element 
	 *   should be created and placed into the correct 
	 *   location of the BST (determined by the Binary
	 *   Search Tree property. Otherwise, the existing
	 *   element with the given key should have its 
	 *   value incremented by one.
	 */	
	public void handleWord(K key) {
		//Create a new node n
		TreeNode<K,V> n = new TreeNode<>(key);
		//If root equals null set the root to be the
		//new node and increase the number of elements by 1
		if (root == null){
			root = n;
			numElements++;
		}else{
			handleWord(root, n);
		}
	}

	private void handleWord(TreeNode<K,V> cur, TreeNode<K,V> n){
		if (cur == null){
			return;
		}
		//If the nodes key equals the currents key increment the value by 1
		if (n.key.compareTo(cur.key) == 0){
			cur.incrementValue();
		}
		//If nodes key is less than the currents key
		if (n.key.compareTo(cur.key) < 0){
			//If the node to the left equals null, replace with node n
			if (cur.left == null){
				cur.left = n;
				numElements++;
				return;
			}
			handleWord(cur.left, n);
		}
		//If the nodes key is greater than the currents key
		else if (n.key.compareTo(cur.key) > 0){
			//If the node to the right equals null, replace with node n
			if (cur.right == null){
				cur.right = n;
				numElements++;
				return;
			}
			handleWord(cur.right, n);
		}
	}
	
	/*
	 * Purpose: Get the  value of the given key
	 * Parameters: K key - the key to search for
	 * Returns: V - the key's associated value
	 */	
	public int getFrequency(K key) {
		if (root != null) {
			TreeNode<K, V> cur = root;
			while (cur != null) {
				//If the key that cur points to is the same as key
				if (key.compareTo(cur.key) == 0) {
					//return the value associated to the given key
					return (int) cur.value;
				}
				//If key is less than cur's key
				if (key.compareTo(cur.key) <= 0) {
					//Move cur to the left node
					cur = cur.left;
				} else {
					//Move cur the right node
					cur = cur.right;
				}
			}
		}
		return 0;
	}


	/*
	 * Purpose: Get the total number of nodes in the tree
	 * Parameters: None
	 * Returns: int - the total number of nodes in the tree
	 */	
	public int size() {
		return numElements;
	}

	/*
	 * Purpose: Return a list of all the key-value entries stored in the tree
	 * Parameters: none
	 * Returns: A list of all key-value entries stored in the tree, constructed 
	 *          by performing a level-order traversal of the tree.
	 *
	 * Level-order is most commonly implemented using a queue of nodes.
	 * From Wikipedia, the algorithm is:
	 *
	 * levelorder()
	 *		q = empty queue
	 *		q.enqueue(root)
	 *		while not q.empty do
	 *			node := q.dequeue()
	 *			visit(node)
	 *			if node.left != null then
	 *			      q.enqueue(node.left)
	 *			if node.right != null then
	 *			      q.enqueue(node.right)
	 */	
	public List<Entry<K,V>> entryList() {
		List<Entry<K, V>> resultList = new LinkedList<Entry<K,V>>();
		LinkedList<TreeNode<K,V>> queue = new LinkedList<TreeNode<K,V>>();

		queue.addLast(root);
		while (!queue.isEmpty()){
			TreeNode<K,V> node = queue.removeFirst();
			resultList.add(new Entry<>(node.key, node.value));
			if (node.left != null){
				queue.addLast(node.left);
			}
			if (node.right != null){
				queue.addLast(node.right);
			}
		}
		return resultList;
	}


	/****************************************************
	* Helper functions for Insertion and Search testing *
	****************************************************/
	
	public List<Entry<K,V>> entryList (int which) {
		List<Entry<K,V>> resultList = new LinkedList<Entry<K,V> >();

		if (which == BST_PREORDER) {
			preOrderRecursive(root, resultList);
		}
		else if (which == BST_INORDER) {
			inOrderRecursive(root, resultList);
		}
		else if (which == BST_POSTORDER) {
			postOrderRecursive(root, resultList);
		}

		return resultList;
	}

	// completed for you
	private void inOrderRecursive (TreeNode<K,V> n, List <Entry<K,V>> resultList) {
		if (n == null) {
			return;
		}
		inOrderRecursive(n.left, resultList);
		resultList.add(new Entry<K,V>(n.key, n.value));
		inOrderRecursive(n.right,resultList);
	}

	// completed for you
	private void preOrderRecursive (TreeNode<K,V> n, List <Entry<K,V>> resultList) {
		if (n == null) {
			return;
		}
		resultList.add(new Entry<K,V>(n.key, n.value));
		preOrderRecursive(n.left, resultList);
		preOrderRecursive(n.right,resultList);
	}

	// completed for you
	private void postOrderRecursive (TreeNode<K,V> n, List <Entry<K,V>> resultList) {
		if (n == null) {
			return;
		}
		postOrderRecursive(n.left, resultList);
		postOrderRecursive(n.right,resultList);
		resultList.add(new Entry<K,V>(n.key, n.value));
	}
	
	/****************************************************
	* Helper functions to populate a Heap from this BST *
	****************************************************/
	
	public MaxFrequencyHeap<K,V> createHeapFromTree() {
		MaxFrequencyHeap<K,V> maxHeap = new MaxFrequencyHeap<K,V>();
		addToHeap(maxHeap, root);
		return maxHeap;
	}
	
	public void addToHeap(MaxFrequencyHeap<K,V> h, TreeNode<K,V> n) {
		if (n != null) {
			addToHeap(h, n.left);
			h.insert(new Entry<K,V>(n.key, n.value));
			addToHeap(h, n.right);
		}
	}
	
}
