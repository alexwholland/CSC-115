import java.lang.Math;
/*
 * RefBasedBinarySearchTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinarySearchTree extends RefBasedBinaryTree {

    public RefBasedBinarySearchTree() {
        super();
    }

    public void insert(Integer value) {
        if (this.root == null) {
            this.root = new TreeNode(value);
        }
        else {
            insertIterative(value);
        }
    }

    private void insert(Integer value, TreeNode current) {
        if (value <= current.getValue()) {
            if (current.getLeft() != null) {
                insert(value, current.getLeft());
            }
            else {
                current.setLeft(new TreeNode(value));
            }
        }
        else if (value > current.getValue()) {
            if (current.getRight() != null) {
                insert(value, current.getRight());
            }
            else {
                current.setRight(new TreeNode(value));
            }
        }
    }

    private void insertIterative(Integer value) {
        TreeNode current = this.root;

        while (current != null) {
            if (value <= current.getValue()) {
                if (current.getLeft() == null) {
                    current.setLeft(new TreeNode(value));
                    current = null;
                }
                else {
                    current = current.getLeft();
                }
            }
            else if (value > current.getValue()) {
                if (current.getRight() == null) {
                    current.setRight(new TreeNode(value));
                    current = null;
                }
                else {
                    current = current.getRight();
                }
            }
        }
    }

    public int getMax() throws TreeEmptyException {
        if (this.root == null) {
            throw new TreeEmptyException();
        }
        else {
            return getMaxIterative();
            // return getMax(root.getValue(), root);
        }
    }

    private int getMax(int current, TreeNode n) {
        if (n == null) {
            return current;
        }
        else {
            return getMax(n.getValue(), n.getRight());
        }
    }

    private int getMaxIterative() {
        TreeNode current = root;
        int max = root.getValue();

        while (current != null) {
            max = current.getValue();
            current = current.getRight();
        }
        return max;
    }


    public static void main(String[] args) {
        // use these trees to test the methods you will implement
        RefBasedBinarySearchTree emptyTree = new RefBasedBinarySearchTree();
        RefBasedBinarySearchTree myTree = new RefBasedBinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(0);
        myTree.insert(4);
        myTree.insert(6);

        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();

        System.out.println("toString\n" + myTree);
    }
}