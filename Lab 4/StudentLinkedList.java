/*
Alex Holland
CSC 115 - Lab 4
 */

public class StudentLinkedList implements StudentList {
    private StudentNode head;
    private int count;

    public StudentLinkedList() {
        head  = null;
        count = 0;
    }


    public void add(Student student) {
        StudentNode node = new StudentNode(student);

        if (head == null) {
            head = node;
        }
        else {
            StudentNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
        count++;
    }


    public int size() {
        return count;
    }


    public String toString() {
        String s = "";

        if (head != null) {
            StudentNode cur = head;
            while (cur != null) {
                s  += cur.getData().toString() + "\n";
                cur = cur.next;
            }
        }
        return s;
    }


    public void removeFront() {
        if (head != null) {
            if (head.next != null) {
                head = head.next;
            }
            else {
                head = null;
            }
            count--;
        }
    }


    public boolean contains(Student student) {
        if (head != null) {
            StudentNode cur = head;
            while (cur != null) {
                if (cur.getData().equals(student)) {
                    return true;
                }
                cur = head.next;
            }
        }
        return false;
    }
}
