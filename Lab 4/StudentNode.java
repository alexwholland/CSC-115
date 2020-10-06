/*
Alex Holland
CSC 115 - Lab 4
 */

public class StudentNode {
    public StudentNode next;
    private Student data;

    public StudentNode(Student data) {
        this.data = data;
        this.next = null;
    }

    public StudentNode(Student data, StudentNode next) {
        this.data = data;
        this.next = next;
    }

    /*
     * Purpose: Get the next node
     * Parameters: none
     * Returns: StudentNode - the next node
     */
    public StudentNode getNext() {
        return next;
    }

    /*
     * Purpose: Set the next node
     * Parameters: StudentNode - the new next node
     * Returns: void
     */
    public void setNext(StudentNode next) {
        this.next = next;
    }

    /*
     * Purpose: Gets the data in this node
     * Parameters: none
     * Returns: Student - the data in the node
     */
    public Student getData() {
        return data;
    }

    /*
     * Purpose: Sets the data in this node
     * Parameters: Student - the new data to be set
     * Returns: void
     */
    public void setData(Student data) {
        this.data = data;
    }
}