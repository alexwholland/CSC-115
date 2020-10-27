public class QueueRefBased <T> implements Queue <T> {
    private QueueNode <T> front;
    private QueueNode <T> back;

    public QueueRefBased() {
        front = null;
        back = null;
    }

    public int size() {
        int count = 0;
        QueueNode temp = front;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(T element) {
        QueueNode <T> node = new QueueNode <T>(element);
        if (front == null) {
            front = node;
        }
        else {
            back.next = node;
        }
        back = node;
    }

    public T dequeue() {
        if (front == null) {
            assert false;
            return front.getValue();
        }
        else {
            T val = front.getValue();
            front = front.next;
            return val;
        }
    }

    public T peek() {
        return front.getValue();
    }

    public void makeEmpty() {
        front = null;
        back = null;
    }
}