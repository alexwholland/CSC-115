/*
 * Entry.java
 *
 * This code modified from code found here:
 * http://stackoverflow.com/questions/156275/what-is-the-equivalent-of-the-c-Entryl-r-in-java
 *
 * I have made the instance variables package friendly, and forced key to be Comparable
 *
 * I've also made key final, so that it cannot be changed once a Entry has been
 * inserted into a container.
 *
 */
public class Entry<K extends Comparable<K>, V> {
	final K key;
	V value;

	public Entry(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public int hashCode() {
		int hashkey = key != null ? key.hashCode() : 0;
		int hashvalue = value != null ? value.hashCode() : 0;

		return (hashkey + hashvalue) * hashvalue + hashkey;
	}

	public boolean equals(Object other) {
		if (other instanceof Entry) {
			Entry otherEntry = (Entry) other;
			return ((this.key == otherEntry.key ||
						(this.key != null && otherEntry.key != null &&
							this.key.equals(otherEntry.key))) &&
					(this.value == otherEntry.value ||
						(this.value != null && otherEntry.value != null &&
							this.value.equals(otherEntry.value))));
		}
		return false;
	}

	public String toString()
	{
		return "(" + key + ", " + value + ")";
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public int compareTo (Entry<K,V> other) {
		Integer thisValue = (Integer)this.value;
		Integer otherValue = (Integer)other.value;
		return thisValue.compareTo(otherValue);
	}
}