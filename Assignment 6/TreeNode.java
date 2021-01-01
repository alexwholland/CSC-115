@SuppressWarnings("unchecked")
public class TreeNode<K extends Comparable<K>, V> {
	K key;
	V value;
	static final Integer initialValue = 1;

	TreeNode<K,V>	left;
	TreeNode<K,V>	right;

	public TreeNode() {
		this (null,null);
	}
	
	public TreeNode(K key) {
		this.key = key;
		this.value = (V) initialValue;
	}
	
	public TreeNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public int compareTo(K other) {
		return this.key.compareTo(other);
	}
	
	public void incrementValue() {
		Integer tempValue = ((Integer) value)+1;
		this.value = (V) tempValue;
	}

	public String toString() {
		return "{\""+key+ "\", "+value+"}";
	}
	
	
}