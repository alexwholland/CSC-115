/*
 * Lab10Tester.java
 *
 * A tester for the methods in Lab10.java
 *
 */

public class Lab10Tester {

    private static int testPassCount = 0;
    private static int testCount = 0;


    // for approximate comparison of floating point numbers
    private static final double THRESHOLD = 0.01;

    public static void main(String[] args) {

        testNoCollisionHandling();
        testLinearProbing();


        System.out.println("Passed " + testPassCount + "/" + testCount + " tests");
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
        }  else {
            System.out.println ("Failed test: " + testName + " at line "
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

    public static void testNoCollisionHandling() {
        Student s0  = new Student("abc", 50);   //should hash to index 6
        Student s1  = new Student("def", 57);   //should hash to index 3
        Student s2a = new Student("xyz", 56);   //should hash to index 4
        Student s2b = new Student("xyz", 99);   //should hash to index 4
        Student s3a = new Student("adfa", 45);  //should hash to index 2
        Student s3b = new Student("sdf", 55);   //should hash to index 2
        Student s4 = new Student("ops", 22);    //should hash to index 1
        Student s5 = new Student("xej", 33);    //should hash to index 5
        Student s6 = new Student("lapn", 66);   //should hash to index 0
        Student s7 = new Student("rew", 100);   //should hash to index 6

        Hashtable table = new Hashtable();
        // TODO 1: implement insertCollisions in HashTable.java
        //     uncomment the following block of tests, compile and run

        try {
            table.insertCollisions(s0);
            table.insertCollisions(s1);
            table.insertCollisions(s2a);
            table.insertCollisions(s2b);
            table.insertCollisions(s3a);
            table.insertCollisions(s4);
            table.insertCollisions(s5);
            
        } catch (TableFullException e) {
            displayResults (false, "TableFullException should not have been thrown");
        } catch (CollisionException e) {
            displayResults (false, "CollisionException should not have been thrown");
        }
        String result = table.toString();
        String expected = "ops:22\n" + "adfa:45\n" + "def:57\n"
                        + "xyz:99\n" + "xej:33\n" + "abc:50\n";
        displayResults(result.equals(expected), "insert order");
        
        try {
            table.insertCollisions(s3b);
        } catch (TableFullException e) {
            displayResults (false, "TableFullException should not have been thrown");
        } catch (CollisionException e) {
            displayResults (true, "CollisionException should have been thrown");
        }
        
        try {
            table.insertCollisions(s6);
            result = table.toString();
            expected = "lapn:66\n" + "ops:22\n" + "adfa:45\n" + "def:57\n"
            + "xyz:99\n" + "xej:33\n" + "abc:50\n";
            displayResults(result.equals(expected), "insert order");
            
            table.insertCollisions(s7);
        } catch (TableFullException e) {
            displayResults (true, "TableFullException should have been thrown");
        } catch (CollisionException e) {
            displayResults (false, "CollisionException should not have been thrown");
        }


        // TODO 2: implement getCollisions in HashTable.java
        //     uncomment the following block of tests, compile and run

        
        try {
            int grade = table.getCollisions("abc");
            displayResults(grade==50, "get successful");
        } catch (KeyNotFoundException e) {
            displayResults (false, "KeyNotFoundException should not have been thrown");
        }
        
        try {
            int grade = table.getCollisions("xyz");
            displayResults(grade==99, "get successful");
        } catch (KeyNotFoundException e) {
            displayResults (false, "KeyNotFoundException should not have been thrown");
        }
        
        try {
            int grade = table.getCollisions("sdf");
            displayResults(false, "KeyNotFoundException should have been thrown");
        } catch (KeyNotFoundException e) {
            displayResults (true, "KeyNotFoundException should have been thrown");
        }
        
        try {
            int grade = table.getCollisions("rew");
            displayResults(false, "KeyNotFoundException should have been thrown");
        } catch (KeyNotFoundException e) {
            displayResults (true, "KeyNotFoundException should have been thrown");
        }


    }

    public static void testLinearProbing() {
        Student s0  = new Student("abc", 50);   //should hash to index 6
        Student s1  = new Student("def", 57);   //should hash to index 3
        Student s2a = new Student("xyz", 56);   //should hash to index 4
        Student s2b = new Student("xyz", 99);   //should hash to index 4
        Student s3a = new Student("adfa", 45);  //should hash to index 2
        Student s3b = new Student("sdf", 55);   //should hash to index 2
        Student s4 = new Student("ops", 22);    //should hash to index 1
        Student s5 = new Student("xej", 33);    //should hash to index 5
        Student s6 = new Student("lapn", 66);   //should hash to index 0
        Student s7 = new Student("rew", 100);   //should hash to index 6

        Hashtable table = new Hashtable();


        // TODO 3: implement insertLinearProbing in HashTable.java
        //  Uncomment the following block of tests.  Before compiling and running:
        //     given the hash indices above, determine which index each Student should be inserted at
        //  Compile and run to test your function - does it match your trace?

        try {
            table.insertLinearProbing(s0);
            table.insertLinearProbing(s1);
            table.insertLinearProbing(s2a);
            table.insertLinearProbing(s2b);
            table.insertLinearProbing(s3a);
            table.insertLinearProbing(s4);
            table.insertLinearProbing(s5);
            table.insertLinearProbing(s3b);
            
        } catch (TableFullException e) {
            displayResults (false, "TableFullException should not have been thrown");
        }
        
        String result = table.toString();
        String expected = "sdf:55\n" + "ops:22\n" + "adfa:45\n" + "def:57\n"
        + "xyz:99\n" + "xej:33\n" + "abc:50\n";
        displayResults(result.equals(expected), "insert order");
        
        try {
            table.insertLinearProbing(s7);
        } catch (TableFullException e) {
            displayResults (true, "TableFullException should have been thrown");
        }
         


        // TODO 4: implement getLinearProbing in HashTable.java
        //     uncomment the following block of tests

        
        try {
            int grade = table.getLinearProbing("abc");
            displayResults(grade==50, "get successful");
        } catch (KeyNotFoundException e) {
            displayResults (false, "KeyNotFoundException should not have been thrown");
        }
        
        try {
            int grade = table.getLinearProbing("xyz");
            displayResults(grade==99, "get successful");
        } catch (KeyNotFoundException e) {
            displayResults (false, "KeyNotFoundException should not have been thrown");
        }
        
        try {
            int grade = table.getLinearProbing("sdf");
            displayResults(grade==55, "get successful");
        } catch (KeyNotFoundException e) {
            displayResults (false, "KeyNotFoundException should not have been thrown");
        }
        
        try {
            int grade = table.getLinearProbing("rew");
            displayResults(false, "KeyNotFoundException should have been thrown");
        } catch (KeyNotFoundException e) {
            displayResults (true, "KeyNotFoundException should have been thrown");
        }


        // TODO 5: Uncomment the following block of tests.  Before compiling and running:
        //     given the hash indices above, determine which index each Student should be inserted at
        //  Compile and run to test your function - does it match your trace?

        Hashtable notFull = new Hashtable();
        try {
            notFull.insertLinearProbing(s0);
            notFull.insertLinearProbing(s1);
            notFull.insertLinearProbing(s3a);
            notFull.insertLinearProbing(s3b);
            result = notFull.toString();
            expected = "adfa:45\n" + "def:57\n" + "sdf:55\n" + "abc:50\n";
            displayResults(result.equals(expected), "insert order");
            
        } catch (TableFullException e) {
            displayResults (false, "TableFullException should not have been thrown");
        }
        
        try {
            int grade = notFull.getLinearProbing("abc");
            displayResults(grade==50, "get successful");
            
            grade = notFull.getLinearProbing("def");
            displayResults(grade==57, "get successful");
            
            grade = notFull.getLinearProbing("adfa");
            displayResults(grade==45, "get successful");
            
            grade = notFull.getLinearProbing("sdf");
            displayResults(grade==55, "get successful");
            
        } catch (KeyNotFoundException e) {
            displayResults (false, "KeyNotFoundException should not have been thrown");
        }
        
        try {
            int grade = notFull.getLinearProbing("xyz");
            displayResults(false, "KeyNotFoundException should have been thrown");
            
        } catch (KeyNotFoundException e) {
            displayResults (true, "KeyNotFoundException should have been thrown");
        }

    }

}