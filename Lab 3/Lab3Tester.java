/*
 * Lab3Tester.java
 *
 * A tester for the methods in Rectangle and ShapeList
 *
 */

public class Lab3Tester {
    private static int testPassCount = 0;
    private static int testCount     = 0;


    // for approximate comparison of floating point numbers
    private static final double THRESHOLD = 0.01;

    public static void main(String[] args) {
        testRectangleToString();
        testRectangleArea();
        testRectanglePerimeter();
        testRectangleContains();
        testShapeList();

        System.out.println("Passed " + testPassCount + "/" + testCount + " tests");
    }

    public static void testRectangleToString() {
        Shape r00 = new Rectangle();
        Point p00 = new Point();
        Point p23 = new Point(2, 3);
        Shape r45 = new Rectangle(4, 5, p23);

        String result   = r00.toString();
        String expected = "Rectangle of dimensions: 0 by 0 at Point: " + p00.toString();

        displayResults(result.equals(expected), "testRectangleToString");

        result   = r45.toString();
        expected = "Rectangle of dimensions: 4 by 5 at Point: " + p23.toString();
        displayResults(result.equals(expected), "testRectangleToString");
    }

    public static void testRectangleArea() {
        Shape r00 = new Rectangle();
        Point p00 = new Point();
        Point p23 = new Point(2, 3);
        Shape r45 = new Rectangle(4, 5, p00);

        double result;
        double expected;

        expected = 0;
        result   = r00.area();
        displayResults(Math.abs(result - expected) < THRESHOLD, "testRectangleArea - 0 by 0");

        expected = 4 * 5;
        result   = r45.area();
        displayResults(Math.abs(result - expected) < THRESHOLD, "testRectangleArea - 4 by 5");
    }

    public static void testRectanglePerimeter() {
        Shape r00 = new Rectangle();
        Point p00 = new Point();
        Point p23 = new Point(2, 3);
        Shape r45 = new Rectangle(4, 5, p00);

        double result;
        double expected;

        expected = 0;
        result   = r00.perimeter();
        displayResults(Math.abs(result - expected) < THRESHOLD, "testRectanglePerimeter - 0 by 0");

        expected = (4 + 5) * 2;
        result   = r45.perimeter();
        displayResults(Math.abs(result - expected) < THRESHOLD, "testRectanglePerimeter - 4 by 5");
    }

    public static void testRectangleContains() {
        Shape r00 = new Rectangle();
        Point p00 = new Point();
        Point p23 = new Point(2, 3);
        Shape r45 = new Rectangle(4, 5, p23);

        boolean result;

        result = r00.contains(p00);
        displayResults(result, "testRectangleContains - true");

        result = r00.contains(p23);
        displayResults(!result, "testRectangleContains - false");

        // outside r45
        Point p15 = new Point(1, 5);
        Point p49 = new Point(4, 9);
        Point p42 = new Point(4, 2);
        Point p75 = new Point(7, 5);


        result = r45.contains(p15);
        displayResults(!result, "testRectangleContains - false");
        result = r45.contains(p49);
        displayResults(!result, "testRectangleContains - false");
        result = r45.contains(p42);
        displayResults(!result, "testRectangleContains - false");
        result = r45.contains(p75);
        displayResults(!result, "testRectangleContains - false");

        // inside/on r45
        Point p25 = new Point(2, 5);
        Point p48 = new Point(4, 8);
        Point p43 = new Point(4, 3);
        Point p65 = new Point(6, 5);
        Point p45 = new Point(4, 5);

        result = r45.contains(p23);
        displayResults(result, "testRectangleContains - true");
        result = r45.contains(p25);
        displayResults(result, "testRectangleContains - true");
        result = r45.contains(p48);
        displayResults(result, "testRectangleContains - true");
        result = r45.contains(p43);
        displayResults(result, "testRectangleContains - true");
        result = r45.contains(p65);
        displayResults(result, "testRectangleContains - true");
        result = r45.contains(p45);
        displayResults(result, "testRectangleContains - true");
    }

    public static void testShapeList() {
        // TODO: uncomment the following tests
        Point p25 = new Point(2, 5);
        Point p48 = new Point(4, 8);
        Shape r00 = new Rectangle();
        Shape c25 = new Circle(9, p25);

        ShapeList l = new ShapeList();

        displayResults(l.size() == 0, "test contructor with size");


        l.add(r00);
        displayResults(l.size() == 1, "test add with size");


        String resultString   = l.toString();
        String expectedString = r00.toString() + "\n";
        System.out.println("result:   " + resultString);
        System.out.println("expected: " + expectedString);
        displayResults(resultString.equals(expectedString), "test add with toString");


        l.add(c25);
        displayResults(l.size() == 2, "test add with size");

        resultString   = l.toString();
        expectedString = r00.toString() + "\n" + c25.toString() + "\n";
        System.out.println("result:   " + resultString);
        System.out.println("expected: " + expectedString);
        displayResults(resultString.equals(expectedString), "test add with toString");

        l.add(r00);
        displayResults(l.size() == 3, "test add with size");

        resultString   = l.toString();
        expectedString = r00.toString() + "\n"
                + c25.toString() + "\n"
                + r00.toString() + "\n";
        System.out.println("result:   " + resultString);
        System.out.println("expected: " + expectedString);
        displayResults(resultString.equals(expectedString), "test add with toString");

        l.add(r00);
        displayResults(l.size() == 4, "test add with size");

        resultString   = l.toString();
        expectedString = r00.toString() + "\n"
                + c25.toString() + "\n"
                + r00.toString() + "\n"
                + r00.toString() + "\n";
        System.out.println("result:   " + resultString);
        System.out.println("expected: " + expectedString);
        displayResults(resultString.equals(expectedString), "test add with toString");

        l.add(c25);
        displayResults(l.size() == 5, "test add with size");

        resultString   = l.toString();
        expectedString = r00.toString() + "\n"
                + c25.toString() + "\n"
                + r00.toString() + "\n"
                + r00.toString() + "\n"
                + c25.toString() + "\n";
        System.out.println("result:   " + resultString);
        System.out.println("expected: " + expectedString);
        displayResults(resultString.equals(expectedString), "test add with toString");

        l.removeFront();
        displayResults(l.size() == 4, "test removeFront with size");

        resultString   = l.toString();
        expectedString = c25.toString() + "\n"
                + r00.toString() + "\n"
                + r00.toString() + "\n"
                + c25.toString() + "\n";
        System.out.println("result:   " + resultString);
        System.out.println("expected: " + expectedString);
        displayResults(resultString.equals(expectedString), "test removeFront with toString");

        l.removeFront();
        displayResults(l.size() == 3, "test removeFront with size");

        resultString   = l.toString();
        expectedString = r00.toString() + "\n"
                + r00.toString() + "\n"
                + c25.toString() + "\n";
        System.out.println("result:   " + resultString);
        System.out.println("expected: " + expectedString);
        displayResults(resultString.equals(expectedString), "test removeFront with toString");

        l.removeFront();
        displayResults(l.size() == 2, "test removeFront with size");

        resultString   = l.toString();
        expectedString = r00.toString() + "\n"
                + c25.toString() + "\n";
        System.out.println("result:   " + resultString);
        System.out.println("expected: " + expectedString);
        displayResults(resultString.equals(expectedString), "test removeFront with toString");

        l.removeFront();
        displayResults(l.size() == 1, "test removeFront with size");

        resultString   = l.toString();
        expectedString = c25.toString() + "\n";
        System.out.println("result:   " + resultString);
        System.out.println("expected: " + expectedString);
        displayResults(resultString.equals(expectedString), "test removeFront with toString");

        l.removeFront();
        displayResults(l.size() == 0, "test removeFront with size");

        resultString   = l.toString();
        expectedString = "";
        System.out.println("result:   " + resultString);
        System.out.println("expected: " + expectedString);
        displayResults(resultString.equals(expectedString), "test removeFront with toString");

        l.removeFront();
        displayResults(l.size() == 0, "test removeFront with size for 0-length list");

        resultString   = l.toString();
        expectedString = "";
        System.out.println("result:   " + resultString);
        System.out.println("expected: " + expectedString);
        displayResults(resultString.equals(expectedString), "test removeFront with toString");

        l.add(c25);
        displayResults(l.size() == 1, "test add with size");

        resultString   = l.toString();
        expectedString = c25.toString() + "\n";
        System.out.println("result:   " + resultString);
        System.out.println("expected: " + expectedString);
        displayResults(resultString.equals(expectedString), "test removeFront with toString");
    }

    public static void displayResults(boolean passed, String testName) {
        /* There is some magic going on here getting the line number
         * Borrowed from:
         * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
         */

        testCount++;
        if (passed) {
            System.out.println("Passed test: " + testName);
            testPassCount++;
        }
        else{
            System.out.println("Failed test: " + testName + " at line "
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
}
