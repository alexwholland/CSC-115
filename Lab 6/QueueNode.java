/*
 * QueueNode.java
 *
 * A  node for a ref-based Queue, assuming that the queue
 * is meant to contains nodes storing values of type int.
 */
class QueueNode <T> {
    T data;
    QueueNode<T> next;


    public QueueNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getValue() {
        return this.data;
    }

    public QueueNode<T> getNext() {
        return this.next;
    }

    public void setNext(QueueNode<T> next) {
        this.next = next;
    }

    public String toString() {
        return data + "";
    }
}