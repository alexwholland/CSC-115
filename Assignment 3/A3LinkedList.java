// Name: Alex Holland
// Student number: v00928553

public class A3LinkedList implements A3List {
    private A3Node head;
    private A3Node tail;
    private int length;

    public A3LinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public void addFront(String s) {
        A3Node node = new A3Node(s);

        if (head == null){
            head = node;
            tail = node;
        }else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        length++;
    }

    public void addBack(String s) {
        A3Node node = new A3Node(s);

        if (tail == null) {
        head = node;
        }else{
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        length++;
    }

    public int size() {
        int count = 0;
        A3Node cur = head;

        while (cur != null) {
            cur = cur.next;
            count++;
        }
        length = count;
        return length;
    }

    public boolean isEmpty() {
        return length == 0 && head == null;
    }

    public void removeFront() {
        if (length <= 1){
            head = null;
            tail = null;
            length = 0;
        }
        else{
            head = head.next;
            head.prev = null;
            length--;
        }
    }

    public void removeBack() {
        if (length <= 1){
            head = null;
            tail = null;
            length = 0;
        }else{
            tail = tail.prev;
            tail.next = null;
            length--;
        }
    }


    public void rotate(int n) {
        head.prev = tail;
        tail.next = head;
        for (int i = 0; i < n; i++){
            head = head.next;
            tail = tail.next;
        }
        head.prev = null;
        tail.next = null;
    }

    public void interleave(A3LinkedList other) {

        A3Node cur = head;
        A3Node curOther = other.head;
        A3Node temp;

        if(curOther != null && cur != null){
            while (curOther.next != null && cur.next != null) {
                temp = cur.next;
                cur.next = curOther.next;
                curOther.next = temp;

                temp.prev = curOther;
                cur.next.prev = cur;

                cur = cur.next;
                curOther = curOther.next;
            }
    // If the length of the list is even then switch where the tails point to
            if (this.length % 2 == 0){
                A3Node hold = this.tail;
                this.tail = other.tail;
                other.tail = hold;
            }
        }
    }


    /* Purpose: return a string representation of the list
     *          when traversed from front to back
     * Parameters: none
     * Returns: nothing
     */
    public String frontToBack() {
        String result = "{";
        A3Node cur = head;
        while (cur != null) {
            result += cur.getData();
            cur = cur.next;
        }
        result += "}";
        return result;
    }

    /* Purpose: return a string representation of the list
     *          when traversed from back to front
     * Parameters: none
     * Returns: nothing
     */
    public String backToFront() {
        String result = "{";
        A3Node cur = tail;
        while (cur != null) {
            result += cur.getData();
            cur = cur.prev;
        }
        result += "}";
        return result;
    }
}
	