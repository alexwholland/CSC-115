/*
 * Lab5Tester.java
 */
public class Lab5Tester {
    private static int testPassCount = 0;
    private static int testCount     = 0;

    public static void main(String[] args) {
        try {
            testAddOne();
            testAddOneRecursive();
            testDoubleRecursive();
            testDoubleOddsRecursive();
            testSumValues();
            testMultiplyValues();
            testDoubleAtOddPositions();
            testIsAscending();
            testIsNegative();
        } catch (Exception e) {
            System.out.println("Your code threw an Exception.");
            System.out.println("Perhaps a stack trace will help:");
            e.printStackTrace(System.out);
        }
        System.out.println("Passed " + testPassCount + "/" + testCount + " tests");
    }

    public static void testAddOne() {
        IntegerLinkedList emptyList = new IntegerLinkedList();
        IntegerLinkedList list3     = new IntegerLinkedList();

        list3.addFront(-2);
        list3.addFront(0);
        list3.addFront(7);

        emptyList.addOne();
        System.out.println(emptyList);
        displayResults(emptyList.toString().equals(""), "testAddOne - empty");


        list3.addOne();
        System.out.println(list3);
        displayResults(list3.toString().equals("8 1 -1"), "testAddOne - length3");
    }

    public static void testAddOneRecursive() {
        IntegerLinkedList emptyList = new IntegerLinkedList();
        IntegerLinkedList list3     = new IntegerLinkedList();

        list3.addFront(-2);
        list3.addFront(0);
        list3.addFront(7);

        emptyList.addOneRecursive();
        System.out.println(emptyList);
        displayResults(emptyList.toString().equals(""), "testAddOne - empty");


        list3.addOneRecursive();
        System.out.println(list3);
        displayResults(list3.toString().equals("8 1 -1"), "testAddOne - length3");
    }

    public static void testDoubleRecursive() {
        IntegerLinkedList emptyList = new IntegerLinkedList();
        IntegerLinkedList list3     = new IntegerLinkedList();

        list3.addFront(-2);
        list3.addFront(0);
        list3.addFront(7);

        emptyList.doubleRecursive();
        System.out.println(emptyList);
        displayResults(emptyList.toString().equals(""), "testDouble - empty");

        list3.doubleRecursive();
        System.out.println(list3);
        displayResults(list3.toString().equals("14 0 -4"), "testDouble - length3");
    }

    public static void testDoubleOddsRecursive() {
        IntegerLinkedList emptyList = new IntegerLinkedList();
        IntegerLinkedList list3 = new IntegerLinkedList();
        IntegerLinkedList list4 = new IntegerLinkedList();

        list3.addFront(-2);
        list3.addFront(0);
        list3.addFront(7);

        list4.addFront(1);
        list4.addFront(2);
        list4.addFront(3);
        list4.addFront(4);

        emptyList.doubleOddsRecursive();
        System.out.println(emptyList);
        displayResults(emptyList.toString().equals(""), "testDouble - empty");

        list3.doubleOddsRecursive();
        System.out.println(list3);
        displayResults(list3.toString().equals("14 0 -2"), "testDouble - length3");

        list4.doubleOddsRecursive();
        System.out.println(list4);
        displayResults(list4.toString().equals("4 6 2 2"), "testDouble - length4");
    }

    public static void testSumValues() {
        IntegerLinkedList emptyList = new IntegerLinkedList();
        IntegerLinkedList list3     = new IntegerLinkedList();

        list3.addFront(-2);
        list3.addFront(0);
        list3.addFront(7);

        int result = emptyList.sum();
        displayResults(result == 0, "testSumValues - empty");

        result = list3.sum();
        displayResults(result == 5, "testSumValues - length3");
    }

    public static void testMultiplyValues() {
        IntegerLinkedList emptyList = new IntegerLinkedList();
        IntegerLinkedList list3a    = new IntegerLinkedList();
        IntegerLinkedList list3b    = new IntegerLinkedList();

        list3a.addFront(-7);
        list3a.addFront(0);
        list3a.addFront(7);

        list3b.addFront(-2);
        list3b.addFront(3);
        list3b.addFront(12);

        int result = emptyList.productRecursive();
        displayResults(result == 1, "testMultiplyValues - empty");

        result = list3a.productRecursive();
        displayResults(result == 0, "testMultiplyValues - length3");

        result = list3b.productRecursive();
        displayResults(result == -72, "testMultiplyValues - length3");
    }

    public static void testDoubleAtOddPositions() {
        IntegerLinkedList emptyList = new IntegerLinkedList();
        IntegerLinkedList list3a    = new IntegerLinkedList();

        list3a.addFront(-2);
        list3a.addFront(5);
        list3a.addFront(7);
        list3a.addFront(8);

        emptyList.doubleOddPositionValues();
        displayResults(emptyList.toString().equals(""), "testDoubleAtOddPositions - empty");

        list3a.doubleOddPositionValues();
        displayResults(list3a.toString().equals("8 14 5 -4"), "testDoubleAtOddPositions - length3");
    }

    public static void testIsAscending() {
        IntegerLinkedList emptyList = new IntegerLinkedList();
        IntegerLinkedList list3a    = new IntegerLinkedList();
        IntegerLinkedList list3b    = new IntegerLinkedList();
        IntegerLinkedList list5a    = new IntegerLinkedList();
        IntegerLinkedList list5b    = new IntegerLinkedList();

        list3a.addFront(7);
        list3a.addFront(0);
        list3a.addFront(-2);
        // System.out.println(list3a.toString());
        list3b.addFront(7);
        list3b.addFront(8);
        list3b.addFront(-2);
        // System.out.println(list3b.toString());

        list5a.addFront(5);
        list5a.addFront(4);
        list5a.addFront(3);
        list5a.addFront(2);
        list5a.addFront(1);
        // System.out.println(list5a.toString());

        list5b.addFront(0);
        list5b.addFront(4);
        list5b.addFront(3);
        list5b.addFront(2);
        list5b.addFront(1);
        // System.out.println(list5b.toString());

        boolean result = emptyList.ascendingRecursive();
        displayResults(result == true, "testIsAscending - empty");

        result = list3a.ascendingRecursive();
        displayResults(result == true, "testIsAscending - length3");

        result = list3b.ascendingRecursive();
        displayResults(result == false, "testIsAscending - length3");

        result = list5a.ascendingRecursive();
        displayResults(result == true, "testIsAscending - length5");

        result = list5b.ascendingRecursive();
        displayResults(result == false, "testIsAscending - length5");
    }

    public static void testIsNegative() {
        IntegerLinkedList emptyList = new IntegerLinkedList();
        IntegerLinkedList list3a = new IntegerLinkedList();
        IntegerLinkedList list3b = new IntegerLinkedList();
        IntegerLinkedList list3c = new IntegerLinkedList();
        IntegerLinkedList list3d = new IntegerLinkedList();
       // IntegerLinkedList list3e = new IntegerLinkedList();


        list3a.addFront(-4);
        list3a.addFront(-1);
        list3a.addFront(0);

        list3b.addFront(-3);
        list3b.addFront(-2);
        list3b.addFront(-1);

        list3c.addFront(-2);
        list3c.addFront(4);
        list3c.addFront(-5);

        list3d.addFront(2);
        list3d.addFront(4);
        list3d.addFront(5);

      //  list3e.addFront(0);

        boolean result = emptyList.isNegativeRecursive();
        displayResults(result == true, "testIsNegative - empty");

        result = list3a.isNegativeRecursive();
        displayResults(result == false, "testIsNegative - length3");

        result = list3b.isNegativeRecursive();
        displayResults(result == true, "testIsNegative - length3");

        result = list3c.isNegativeRecursive();
        displayResults(result == false, "testIsNegative - length3");

        result = list3d.isNegativeRecursive();
        displayResults(result == false, "testIsNegative - length3");

    }

    public static void displayResults(boolean passed, String testName) {
        /* There is some magic going on here getting the line number
         * Borrowed from:
         * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
         */
        testCount++;
        if (passed) {
            System.out.println("Passed test: " + testCount);
            testPassCount++;
        }
        else{
            System.out.println("Failed test: " + testName + " at line "
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
}