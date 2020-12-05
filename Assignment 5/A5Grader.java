/*
 * A8Tester.java
 *
 * A test program for Assignment 5.
 *
 */

import java.util.Random;

public class A5Grader {
    private static int testPassCount = 0;
    private static int testCount = 0;
    public static boolean  	testHeapSolution = true;

    public static void displayResults (boolean passed, String testName) {
        /* There is some magic going on here getting the line number
         * Borrowed from:
         * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
         */
        testCount++;
        if (passed)
        {
            System.out.println ("Passed test: " + testCount);
            testPassCount++;
        }
        else
        {
            System.out.println ("Failed test: " + testName + " at line "
                    + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }


    public static void testOne () {
        PriorityQueue 	q = null;
        System.out.println("Basic testing of size, isEmpty");
        try{
            q = createNewPriorityQueue();
            displayResults (q.size() == 0, "size on empty Q");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testOne");
        }try{
            displayResults (q.isEmpty(), "isEmpty on empty Q");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testOne");
        }try{
            q.insert(10);
            displayResults (q.size() == 1, "size on 1 element Q");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testOne");
        }try{
            displayResults (!q.isEmpty(), "isEmpty on 1 element Q");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testOne");
        }try{
            q.insert(9);
            q.insert(10);
            displayResults (q.size() == 3, "size on 2 element Q");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testOne");
        }try{
            q.insert(7);
            displayResults (q.size() == 4, "size on 3 element Q");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testOne");
        }

    }


    public static void testTwo()
    {
        System.out.println("\nBasic testing of removeMin");
        PriorityQueue 	q = null;
        int result;

        try{
            q = createNewPriorityQueue();
            displayResults(true, "PQtest2 created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test2");
        }try{
        q.insert(8);
        q.insert(9);
        q.insert(100);
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 8, "remove on multiple element Q");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test2");
    }try{
        displayResults(q.size() == 2, "remove + size on multiple element Q");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test2");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        //        System.out.println("res: " + result + ":" + q);
        displayResults(result == 9, "remove on multiple element Q");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test2");
    }try{
        displayResults(q.size() == 1, "remove + size on multiple element Q");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test2");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 100, "remove + size on 1 element Q");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test2");
    }try{
        displayResults(q.isEmpty(), "remove + isEmpty on 1 element Q");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test2");
    }try{

        q = createNewPriorityQueue();
        q.insert(13);
        q.insert(12);
        q.insert(51);
        displayResults(true, "PQtest2 created");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test2");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 12, "insert + remove on multiple element Q");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test2");
    }try{
        displayResults(q.size() == 2, "insert + remove + size on multiple element Q");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test2");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 13, "insert + remove on multiple element Q");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test2");
    }try{
        displayResults(q.size() == 1, "insert + remove + size on multiple element Q");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test2");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 51, "insert + remove on 1 element Q");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test2");
    }try{
        displayResults(q.isEmpty(), "insert + remove + size on 1 element Q");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test2");
    }


    }
    public static void testExceptions()
    {

        PriorityQueue 	q = null;
        System.out.println("\nTesting of exceptions");
        try{
            q = createNewPriorityQueue(2);
            displayResults(true, "PQtestExceptions created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testExceptions");
        }


        try {
            q.removeMin();
            displayResults(false, "exception should have been thrown");
        } catch (HeapEmptyException e) {
            displayResults(true, "HeapEmptyException should be thrown");
        } catch (Exception e){
            displayResults(false, "Wrong error thrown");
        }
        try{
            q.insert(10);
            q.insert(9);
        }catch(Exception e){
            System.out.println(e);
        }try {
        q.insert(8);
        //if(testHeapSolution)
        displayResults(false, "exception should have been thrown in heap solution");
        //else
        //displayResults(true, "exception should not have been thrown in linked version");
    } catch (HeapFullException e) {
        displayResults(true, "HeapFullException should be thrown");
    } catch (Exception e){
        displayResults(false, "Wrong error thrown");
    }


    }
    public static void testThree() {
        System.out.println("\nTesting of removeMin with Strings");
        PriorityQueue 	q = null;

        try{
            q = createNewPriorityQueue();
            displayResults(true, "PQtest3 created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test3");
        }
        String result;


        try{
            q.insert("ab");
            q.insert("def");
            q.insert("ghi");

            result = ((String)q.removeMin());
            displayResults(result.equals("ab"), "insert/remove Strings");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test3");
        }try{
            displayResults(q.size() == 2, "insert/remove Strings");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test3");
        }try{
            result = ((String)q.removeMin());
            displayResults(result.equals("def"), "insert/remove Strings");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test3");
        }try{
            displayResults(q.size() == 1, "insert/remove Strings");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test3");
        }try{
            result = ((String)q.removeMin());
            displayResults(result.equals("ghi"), "insert/remove Strings");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test3");
        }try{
            displayResults(q.isEmpty(), "insert/remove Strings");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test3");
        }try{
            q = createNewPriorityQueue();
            q.insert("ghi");
            q.insert("def");
            q.insert("abc");
            result = ((String)q.removeMin());
            displayResults(result.equals("abc"), "insert/remove Strings");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test3");
        }try{
            displayResults(q.size() == 2, "insert/remove + size Strings");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test3");
        }try{

            result = ((String)q.removeMin());
            displayResults(result.equals("def"), "insert/remove Strings");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test3");
        }try{
            displayResults(q.size() == 1, "insert/remove + size Strings");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test3");
        }try{

            result = ((String)q.removeMin());
            displayResults(result.equals("ghi"), "insert/remove Strings");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test3");
        }try{
            displayResults(q.isEmpty(), "insert/remove + isEmpty Strings");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test3");
        }



    }

    public static void testFour()
    {
        System.out.println("\nTesting duplicates");
        PriorityQueue 	q = null;

        try{
            q = createNewPriorityQueue();
            displayResults(true, "PQtest4 created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test4");
        }
        int result;


        try{
            q.insert(4);
            q.insert(1);
            q.insert(1);
            q.insert(5);
            q.insert(0);
            //        System.out.println("q after insert 4 1 1 5 0:" + q);

            result = ((Integer)q.removeMin()).intValue();
            displayResults(result == 0, "add duplicates + remove single");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test4");
        }try{
        q.insert(4);
        q.insert(1);
        q.insert(4);
        q.insert(4);

        q.insert(0);
        q.insert(5);
        q.insert(0);
        q.insert(5);

        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 0, "add duplicates + remove duplicates");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 0, "add duplicates + remove duplicates");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }

        try{
            result = ((Integer)q.removeMin()).intValue();
            displayResults(result == 1, "add duplicates + remove duplicates");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test4");
        }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 1, "add duplicates + remove duplicates");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 1, "add duplicates + remove duplicates");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 4, "add duplicates + remove duplicates");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 4, "add duplicates + remove duplicates");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 4, "add duplicates + remove duplicates");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 4, "add duplicates + remove duplicates");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 5, "add duplicates + remove duplicates");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 5, "add duplicates + remove duplicates");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 5, "add duplicates + remove duplicates");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{

        displayResults(q.isEmpty(), "insert/remove + isEmpty");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }

    }


    public static void testFive()
    {
        System.out.println("\nTesting insert mixed with removeMin");
        PriorityQueue 	q = null;

        try{
            q = createNewPriorityQueue();
            displayResults(true, "PQtest4 created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test4");
        }
        int result;

        try{
            q.insert(2);
            q.insert(0);
            q.insert(5);
            q.insert(7);

            result = ((Integer)q.removeMin()).intValue();
            displayResults( result == 0, "inserts + remove");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "test4");
        }try{
        q.insert(4);

        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 2, "inserts + remove + insert + remove");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        q.insert(11);
        q.insert(2);
        q.insert(3);
        q.insert(1);
    }catch(Exception e){
        System.out.println(e + "Problem with insert");
    }try{

        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 1, "inserts + remove");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 2, "inserts + remove");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 3, "inserts + remove");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 4, "inserts + remove");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        q.insert(1);
        result = ((Integer)q.removeMin()).intValue();
        displayResults(result == 1, "inserts + remove");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }try{
        displayResults(q.size() == 3, "inserts + remove + size");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "test4");
    }

    }

    public static boolean testRandomArray (int count)
    {
        // These tests are effectively sorting the random values
        //
        // For the heap, this is O (n log n)
        // For the linked list, this is O (n^2)

        PriorityQueue 	q = null;

        try{
            q = createNewPriorityQueue(count);
            //displayResults(true, "PQtest created");
        }catch(Exception e){
            System.out.println(e);
            //displayResults(false, "RandTest");
            return false;
        }
        System.out.println("Testing size: " + count);
        Random r = new Random();

        for ( int i = 0; i < count; i++ ) {
            int val = r.nextInt(1000000);
            try{
                q.insert (val);
            }catch(Exception e){
                System.out.println(e);
                //displayResults(false, "RandTest");
                return false;
            }
            //System.out.println("queue after insert val: " + q);
        }

        int oldVal = 0; //biggest possible value val could be
        int i = 0;
        while (!q.isEmpty()) {
            try{
                int val = (int)((Integer)q.removeMin()).intValue(); // or a bug
                //System.out.println("lowest removed was: " + val + " queue after remove: " + q);
                if ( val < oldVal )
                    return false;

                oldVal = val;
                i++;
            }catch(Exception e){
                System.out.println(e);
                //displayResults(false, "RandTest");
                return false;
            }
        }
        return true;

    }

    public static void stressTest() {

        System.out.println("\ntress Test.");
        try{
            System.out.print("Stress test 1 ");
            displayResults(testRandomArray(100), "inserts + removes");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Stress Test 1");
        }catch(StackOverflowError e){
            System.out.println("Stack Overflowed");
            displayResults(false, "Stress Test 1");
        }
        try{
            System.out.print("Stress test 2 ");
            displayResults(testRandomArray(10000), "inserts + removes");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Stress Test 2");
        }catch(StackOverflowError e){
            System.out.println("Stack Overflowed");
            displayResults(false, "Stress Test 2");

        }try{
            System.out.print("Stress test 3 ");
            displayResults(testRandomArray(100000), "inserts + removes");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Stress Test 3");
        }
        catch(StackOverflowError e){
            System.out.println("Stack Overflowed");
            displayResults(false, "Stress Test 3");
        }try{
            System.out.print("Stress test 4 ");
            //This takes too long using the linked list.
            //if (testHeapSolution)
            displayResults(testRandomArray(1000000), "inserts + removes");
        }catch(StackOverflowError e){
            System.out.println("Stack Overflowed");
            displayResults(false, "Stress Test 4");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Stress Test 4");
        }

    }

    public static PriorityQueue createNewPriorityQueue()  {
        if (testHeapSolution) {
            return new HeapPriorityQueue();
        }
        else {
            return new LinkedPriorityQueue();
        }
    }

    public static PriorityQueue createNewPriorityQueue(int size)  {
        if (testHeapSolution) {
            return new HeapPriorityQueue(size);
        }
        else {
            return new LinkedPriorityQueue();
        }
    }

   /* public static void testPassenger ()
    {

        System.out.println("\nTesting Passenger creation, compareTo and equals.");
        Passenger p1 = null;
        try{
            p1 = new Passenger(3, "LeBron James", "GHN123", new Time(12,24));
            displayResults(true, "Passenger 1 created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Passenger 1");
        }

        Passenger p2 = null;
        try{
            p2 = new Passenger(0, "Lizzo", "HA192B", new Time(12,24));
            displayResults(true, "Passenger 2 created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Passenger 2");
        }
        Passenger p3 = null;
        try{
            p3 = new Passenger(3, "Serena Williams", "ABN456", new Time(12,24) );
            displayResults(true, "Passenger 3 created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Passenger 3");
        }
        Passenger p4 = null;
        try{
            p4 = new Passenger(0, "S. Williams", "ABN456", new Time(9,14) );
            displayResults(true, "Passenger 4 created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Passenger 3");
        }
        try{
            displayResults(p1.compareTo(p2) > 0, "testing Passenger compareTo");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Passenger test");
        } try{
        displayResults(p2.compareTo(p1) < 0, "testing Passenger compareTo");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "Passenger test");
    } try{
        displayResults(p1.compareTo(p1) == 0, "testing Passenger compareTo");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "Passenger test");
    } try{
        displayResults(p1.compareTo(p3) == 0, "testing Passenger compareTo");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "Passenger test");
    } try{
        displayResults(p1.compareTo(p4) > 0, "testing Passenger compareTo");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "Passenger test");
    } try{
        displayResults(p4.compareTo(p1) < 0, "testing Passenger compareTo");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "Passenger test");
    } try{
        displayResults(p3.equals(p4), "testing Passenger equals");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "Passenger test");
    }


    }

    public static void testBoardingGate()
    {

        System.out.println("\nTesting adding/removing passengers from BoardingGate.");
        Passenger p1 = null;
        try{
            p1 = new Passenger(3, "LeBron James", "GHN123", new Time(12,23));
            displayResults(true, "Passenger 1 created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Passenger 1");
        }
        Passenger p2 = null;
        try{
            p2 = new Passenger(4, "Lizzo", "HA192B", new Time(12,24));
            displayResults(true, "Passenger 2 created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Passenger 2");
        }
        Passenger p3 = null;
        try{
            p3 = new Passenger(3, "Serena Williams", "ABN456", new Time(12,24));
            displayResults(true, "Passenger 3 created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Passenger 3");
        }

        Passenger p4 =null;
        try{
            p4 = new Passenger(1, "Kyle Lowry", "GHN123", new Time(12,24));
            displayResults(true, "Passenger 4 created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Passenger 4");
        }
        Passenger p5 = null;
        try{
            p5 = new Passenger(4, "Justin Trudeau", "XCV92B", new Time(10,24));
            displayResults(true, "Passenger 5 created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Passenger 5");
        }
        Passenger p6 = null;
        try{
            p6 = new Passenger(0, "Bianca Andrescu", "TENNI5", new Time(12,24));
            displayResults(true, "Passenger 6 created");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "Passenger 6");
        }

        BoardingGate gate = null;

        try{
            gate = new BoardingGate();
            displayResults(gate.numPassengersWaiting() == 0, "testing BoardingGate constructor + numPassengersWaiting");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testing BoardingGate constructor + numPassengersWaiting");
        }
        try{
            gate.addPassenger(p1);
            gate.addPassenger(p2);
            gate.addPassenger(p3);
            gate.addPassenger(p4);
            gate.addPassenger(p5);
            displayResults(gate.numPassengersWaiting() == 5, "testing BoardingGate addPassenger + numPassengersWaiting");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testing BoardingGate constructor + numPassengersWaiting");
        }

        Passenger nextP = gate.nextPassenger();
        try{

            //System.out.println(nextP);
            displayResults(p4.equals(nextP), "testing BoardingGate addPassenger + numPassengersWaiting");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testing BoardingGate addPassenger + numPassengersWaiting");
        }
        try{
            gate.addPassenger(p6);
            displayResults(gate.numPassengersWaiting() == 5, "testing BoardingGate addPassenger + numPassengersWaiting");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testing BoardingGate addPassenger + numPassengersWaiting");
        }try{
        nextP = gate.nextPassenger();
        displayResults(p6.equals(nextP), "testing BoardingGate addPassenger + nextPassenger");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "testing BoardingGate addPassenger + numPassengersWaiting");
    }try{
        nextP = gate.nextPassenger();
        displayResults(p1.equals(nextP), "testing BoardingGate addPassenger + nextPassenger");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "testing BoardingGate addPassenger + numPassengersWaiting");
    }
        try{
            displayResults(gate.numPassengersWaiting() == 3, "testing BoardingGate addPassenger + numPassengersWaiting");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testing BoardingGate addPassenger + numPassengersWaiting");
        }
        try{
            nextP = gate.nextPassenger();
            displayResults(p3.equals(nextP), "testing BoardingGate addPassenger + nextPassenger");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testing BoardingGate addPassenger + numPassengersWaiting");
        }try{
        nextP = gate.nextPassenger();
        displayResults(p5.equals(nextP), "testing BoardingGate addPassenger + nextPassenger");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "testing BoardingGate addPassenger + numPassengersWaiting");
    }try{
        nextP = gate.nextPassenger();
        displayResults(p2.equals(nextP), "testing BoardingGate addPassenger + nextPassenger");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "testing BoardingGate addPassenger + numPassengersWaiting");
    }try{
        displayResults(gate.numPassengersWaiting() == 0, "testing BoardingGate addPassenger + numPassengersWaiting");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "testing BoardingGate addPassenger + numPassengersWaiting");
    }try{
        nextP = gate.nextPassenger();
        displayResults(nextP == null, "testing BoardingGate nextPassenger - no more ppassengers");
    }catch(Exception e){
        System.out.println(e);
        displayResults(false, "testing BoardingGate addPassenger + numPassengersWaiting");
    }
        BoardingGate smallPlane = null;
        try{
            smallPlane = new BoardingGate(2);
            displayResults(gate.numPassengersWaiting() == 0, "testing BoardingGate constructor small plane");
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testing BoardingGate constructor small plane");
        }
        try{
            smallPlane.addPassenger(p1);
            smallPlane.addPassenger(p2);
        }catch(Exception e){
            System.out.println(e);
            displayResults(false, "testing BoardingGate addPassenger + numPassengersWaiting");
        }

        try {
            smallPlane.addPassenger(p3);
            displayResults(true, "testing BoardingGate addPassenger to full BoardingGate - should get here without exception");
        } catch (HeapFullException e) {
            displayResults(false, "testing BoardingGate addPassenger to full BoardingGate - should not get here");
        }



    }*/

    public static void main (String[] args) {
        if (args.length != 0 && args[0].equals("linked")) {
            testHeapSolution=false;
        }

        System.out.println("Testing " + (testHeapSolution ? "Heap" : "Linked" ) + " implementation.");
        testOne();
        testTwo();
        testExceptions();
        testThree();
        testFour();
        testFive();


        System.out.println("Testing Application using Priority Queue.");
//        testPassenger();
//        testBoardingGate();

        System.out.println("\n");
        stressTest();

        System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
    }
}