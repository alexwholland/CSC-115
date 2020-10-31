/*
Alex Holland - V00928553
CSC 115 - Assignment 4
 */

public class A4Stack<T> implements Stack<T> {

    private Node<T> head;

    public A4Stack() {
        head = null;
    }

    public void push(T v) {
        Node<T> n = new Node<>(v);
        if (head != null) {
            n.next = head;
        }
        head = n;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Can't pop - stack is empty");
        }
        T value = head.getData();
        head = head.next;
        return value;
    }

    public void popAll() {
        while (head != null){
            pop();
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException("Can't pop - stack is empty");
        }
        return head.getData();
    }
}