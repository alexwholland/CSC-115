import java.util.*;
import java.lang.*;

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
class BinarySearchTree <K extends Comparable<K>, V>  {

    public static final int BST_PREORDER  = 1;
    public static final int BST_POSTORDER = 2;
    public static final int BST_INORDER   = 3;

    // These are package friendly for the TreeView class
    TreeNode<K,V> root;
    int	count;

    long findLoops;
    long insertLoops;


    public BinarySearchTree () {
        root = null;
        count = 0;
        findLoops = 0;
        insertLoops = 0;
    }

    public long getFindLoopCount() {
        return findLoops;
    }

    public long getInsertLoopCount() {
        return insertLoops;
    }

    public void resetFindLoops() {
        findLoops = 0;
    }
    public void resetInsertLoops() {
        insertLoops = 0;
    }


    /*
     * Purpose: Inserts or updates a key-value entry in the tree
     * Parameters:  K key - the key for the element
     *				V value - the value associated with the key
     * Returns: void - nothing
     * Pre-conditions: the tree is a valid binary search tree
     */
    public void insert (K key, V value) {
        if (root == null) {
            root = new TreeNode<K,V>(key,value);
            count++;
        } else {
            root = insert(root, key, value);
        }
    }

    private TreeNode<K,V> insert(TreeNode<K,V> cur, K key, V val) {
        if (cur == null) {
            count++;
            return new TreeNode<K,V>(key,val);
        }
        insertLoops++;
        if(key.compareTo(cur.key) == 0) {
            cur.value = val;
        } else if(key.compareTo(cur.key) < 0) {
            cur.left = insert(cur.left, key, val);
        } else {
            cur.right = insert(cur.right, key, val);
        }
        return cur;
    }


    /*
     * Purpose: Gets the value associated with the given key
     * Parameters: K key - the key to search for
     * Returns: V - the value associated with the given key
     * Throws: KeyNotFoundException if the key is not in the tree
     */
    public V find (K key) throws KeyNotFoundException {
        if (root == null) {
            throw new KeyNotFoundException();
        }
        return find(root, key);
    }

    private V find(TreeNode<K,V> cur, K key) throws KeyNotFoundException {
        if (cur == null) {
            throw new KeyNotFoundException();
        }
        findLoops++;
        if (key.compareTo(cur.key) == 0) {
            return cur.value;
        } else if (key.compareTo(cur.key) < 0) {
            return find(cur.left, key);
        } else {
            return find(cur.right, key);
        }
    }

    /*
     * Purpose: Gets the number of elements in the tree
     * Parameters: None
     * Returns: int: the number of elements contained in the tree
     */
    public int size() {
        return count;
    }

    /*
     * Purpose: Removes all elements from the tree
     * Parameters: none
     * Returns: void - nothing
     */
    public void clear() {
        root = null;
        count = 0;
    }

    /*
     * Purpose: Gets the height of the tree
     * Parameters: none
     * Returns: int - the height of the tree
     */
    public int height() {
        return height(root);
    }

    public int height(TreeNode<K,V> cur) {
        if (cur == null) {
            return -1;
        } else {
            return 1 + Math.max(height(cur.left), height(cur.right));
        }
    }

    /*
     * Purpose: Return a list of all the key-value entries stored in the tree
     * Parameters: none
     * Returns: A list of all key-value entries stored in the tree, constructed
     *          by performining a level-order traversal of the tree.
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

        if (root != null) {
            queue.add(root); // at the root to the queue
            while (!queue.isEmpty()) {
                TreeNode<K,V> n = queue.removeFirst();
                resultList.add(new Entry<K,V>(n.key, n.value));
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
        }
        return resultList;
    }

    /*
     * Purpose: Get a list of all the key-value entries from the tree
     * Parameters: int which - specifies which traversal to do from the following:
     *		- BST_PREORDER: a pre-order traversal
     *		- BST_INORDER: an in-order traversal
     *		- BST_POSTORDER: a post-order traversal
     * Returns: List<Entry<K,V>> - the list of entries
     */
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
}