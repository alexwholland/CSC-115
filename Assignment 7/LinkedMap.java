/*
 * LinkedMap.java
 *
 * An implemenation of the Map interface using linked lists
 *
 */

import java.util.*;

public class LinkedMap<K extends Comparable<K>, V> implements Map<K,V> {

    private long getLoops;
    private long putLoops;

    private Node<K,V> 	head;
    private int count;

    public LinkedMap() {
        head = null;
        count = 0;

        resetGetLoops();
        resetPutLoops();
    }

    public long getGetLoopCount() {
        return getLoops;
    }

    public long getPutLoopCount() {
        return putLoops;
    }

    public void resetGetLoops() {
        getLoops = 0;
    }
    public void resetPutLoops() {
        putLoops = 0;
    }

    public boolean containsKey(K key) {
        Node<K,V>	p = head;
        while (p != null) {
            if (p.key.equals(key))
                return true;

            p = p.next;
        }
        return false;
    }

    public V get (K key) throws KeyNotFoundException {
        Node<K,V>	p = head;
        while (p != null) {
            getLoops++;
            if (p.key.equals(key))
                return p.value;

            p = p.next;
        }
        throw new KeyNotFoundException();
    }

    public List<Entry<K,V>>	entryList() {
        List <Entry<K,V> > l = new LinkedList<Entry<K,V> >();
        Node<K,V> p = head;
        while (p!= null) {
            l.add(new Entry<K,V>(p.key, p.value));
            p = p.next;
        }
        return l;
    }

    public void put (K key, V value) {
        Node<K,V>   p = head;
        Node<K,V>	n = new Node<K,V>(key,value,head);

        while (p != null) {
            putLoops++;
            if (p.key.equals(key)) {
                p.value = value;
                return;
            }
            p = p.next;
        }
        count++;
        head = n;
    }

    public int size() {
        return count;
    }

    public void clear() {
        head = null;
        count = 0;
    }

}