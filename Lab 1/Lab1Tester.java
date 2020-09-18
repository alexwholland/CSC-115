/*
 * Lab1Tester.java
 *
 * A tester for the methods in Lab1.java
 *
 */
public class Lab1Tester {

    private static int testPassCount = 0;
    private static int testCount = 0;

    private static int a0[] = {};
    private static int a1[] = {2};
    private static int a4[] = {2, 1, 3, 0};
    private static int a4a[] = {2, 1, 3, 0, 0};
    private static int a5[] = {-1, 2, 4, 1, 2, 3};
    private static int a6[] = {-1, 2, 4, 5, 9};
    private static int a7[] = {-1, 2, 4, 4, 9};
    private static int a8[] = {-4, -2, -1, -5};

    // for approximate comparison of floating point numbers
    private static final double THRESHOLD = 0.01;

    public static void main(String[] args) {
        testGetString();

        // Uncomment the tests below once all the tests
        // for testGetString are passing

         testGetAverage();
         testCountAbove();
         testGetMax();
         testIsSorted();
        System.out.println("Passed " + testPassCount + "/" + testCount + " tests");
    }

    public static void testGetString() {
        String result = "";

        result = Lab1.getString(a0);
        //System.out.println("should be {}: " + result);
        displayResults(result.equals("{}"), "testGetString");

        result = Lab1.getString(a1);
        //System.out.println("should be {2}: " + result);
        displayResults(result.equals("{2}"), "testGetString");

        result = Lab1.getString(a4);
        //System.out.println("should be {2,1,3,0}: " + result);
        displayResults(result.equals("{2,1,3,0}"), "testGetString");

        result = Lab1.getString(a4a);
        //System.out.println("should be {2,1,3,0,0}: " + result);
        displayResults(result.equals("{2,1,3,0,0}"), "testGetString");

    }

    public static void testCountAbove() {
        int result = 0;

        result = Lab1.countAbove(a0,2);
        //System.out.println("a0: " + Lab1.getString(a0));
        //System.out.println("should be 0: " + result);
        displayResults( result == 0, "testCountAbove");

        result = Lab1.countAbove(a1,0);
        //System.out.println("a1: " + Lab1.getString(a1));
        //System.out.println("should be 1: " + result);
        displayResults( result == 1, "testCountAbove" );

        result = Lab1.countAbove(a4,-1);
        //System.out.println("a4: " + Lab1.getString(a4));
        //System.out.println("should be 4: " + result);
        displayResults( result == 4, "testCountAbove" );

        result = Lab1.countAbove(a5,2);
        //System.out.println("a5: " + Lab1.getString(a5));
        //System.out.println("should be 2: " + result);
        displayResults( result == 2, "testCountAbove" );
    }

    public static void testGetAverage() {
        double result = 0;

        result = Lab1.getAverage(0,0,9);
        //System.out.println("should be approx 3.0: " + result);
        displayResults( (Math.abs(result-3.0) < THRESHOLD ), "testGetAverage");

        result = Lab1.getAverage(6,6,6);
        //System.out.println("should be approx 6.0: " + result);
        displayResults( (Math.abs(result-6.0) < THRESHOLD) , "testGetAverage");

        result = Lab1.getAverage(3,9,5);
        //System.out.println("should be approx 5.67: " + result);
        displayResults( (Math.abs(result-5.67) < THRESHOLD), "testGetAverage");

    }

    public static void testGetMax() {
        int result = 0;

        // Write tests for the getMax method found in Lab1.java here.

        result = Lab1.getMax(a1);
        //System.out.println("a1: " + Lab1.getString(a1));
        //System.out.println("should be 2: " + result);
        displayResults( result == 2, "testGetMax" );

        result = Lab1.getMax(a4);
        //System.out.println("a4: " + Lab1.getString(a4));
        //System.out.println("should be 3: " + result);
        displayResults( result == 3, "testGetMax" );

        result = Lab1.getMax(a5);
        //System.out.println("a5: " + Lab1.getString(a4));
        //System.out.println("should be 4: " + result);
        displayResults( result == 4, "testGetMax" );

        result = Lab1.getMax(a8);
        //System.out.println("a8: " + Lab1.getString(a4));
        //System.out.println("should be -1: " + result);
        displayResults( result == -1, "testGetMax" );
    }

    public static void testIsSorted() {
        boolean result = true;

        result = Lab1.isSorted(a0);
        //System.out.println("a0: " + Lab1.getString(a0));
        //System.out.println("should be true: " + result);
        displayResults(result, "testIsSorted");

        result = Lab1.isSorted(a1);
        //System.out.println("a1: " + Lab1.getString(a1));
        //System.out.println("should be true: " + result);
        displayResults(result, "testIsSorted");

        result = Lab1.isSorted(a6);
        //System.out.println("a6: " + Lab1.getString(a6));
        //System.out.println("should be true: " + result);
        displayResults(result, "testIsSorted");

        result = Lab1.isSorted(a7);
        //System.out.println("a7: " + Lab1.getString(a7));
        //System.out.println("should be true: " + result);
        displayResults(result, "testIsSorted");

        result = Lab1.isSorted(a4);
        //System.out.println("a4: " + Lab1.getString(a5));
        //System.out.println("should be false: " + result);
        displayResults(!result, "testIsSorted");

        result = Lab1.isSorted(a5);
        //System.out.println("a5: " + Lab1.getString(a5));
        //System.out.println("should be false: " + result);
        displayResults(!result, "testIsSorted");
    }

    public static void displayResults (boolean passed, String testName)
    {
        /* There is some magic going on here getting the line number
         * Borrowed from:
         * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
         */

        testCount++;

        if (passed) {
            System.out.println ("Passed test: " + testName);
            testPassCount++;
        } else {
            System.out.println ("Failed test: " + testName + " at line "
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }
}