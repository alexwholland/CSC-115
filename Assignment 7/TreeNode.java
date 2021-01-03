public class TreeNode<K extends Comparable<K>, V>
{
    public K key;
    public V value;
    public TreeNode<K,V>	left;
    public TreeNode<K,V>	right;

    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }

}