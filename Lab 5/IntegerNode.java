/*
 * IntegerNode.java
 *
 * An implementation of a node class for a singly-linked list of integers.
 *
 */

public class IntegerNode {
    IntegerNode	next;
    int		    e;

    public IntegerNode() {
        next = null;
        e = 0;
    }

    public IntegerNode (Integer e) {
        this.e = e;
        next = null;;
    }

    public IntegerNode (Integer e, IntegerNode next) {
        this.e = e;
        this.next = next;
    }

    public IntegerNode getNext()	{
        return next;
    }

    public void setNext (IntegerNode next) {
        this.next = next;
    }

    public int getElement() {
        return e;
    }

    public void setElement (Integer e) {
        this.e = e;
    }
}
