public class ComparableNode {
    private Comparable element;
    public  ComparableNode next;
    public  ComparableNode prev;

    public ComparableNode() {
        this(null,null,null);
    }

    public ComparableNode(Comparable element) {
        this(element, null,null);
    }

    public ComparableNode(Comparable element, ComparableNode next, ComparableNode prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    public Comparable getElement() {
        return this.element;
    }

    public void setElement(Comparable element) {
        this.element = element;
    }
}
