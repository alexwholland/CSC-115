	/*
     * A5Tester.java
     *
     * A test program for Assignment 5.
     *
     */

    import java.util.Random;

    public class A5Tester {
        private static int testPassCount = 0;
        private static int testCount = 0;
        public static boolean  	testHeapSolution = true;

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

        public static void main (String[] args) {
            if (args.length != 0 && args[0].equals("linked")) {
                testHeapSolution=false;
            }

            System.out.println("Testing " + (testHeapSolution ? "Heap" : "Linked" ) + " implementation.");

            testSize();
            testInsertionAndRemoval();
            testExceptions();
            testGeneric();
            testDuplicates();
            testMixed();
            stressTest();

            /* Uncomment the following lines once you begin Part 2 */

             System.out.println("Testing Application using Priority Queue.");
             testPatient();
             testEmergencyRoom();

            System.out.println("PASSED " + testPassCount + "/" + testCount + " tests");
        }


        public static void testSize() {
            PriorityQueue pq = createNewPriorityQueue();

            System.out.println("Basic testing of size, isEmpty");
            displayResults (pq.size() == 0, "size on empty PQ");
            displayResults (pq.isEmpty(), "isEmpty on empty PQ");

            pq.insert(10);
            displayResults (pq.size() == 1, "size on 1 element PQ");
            displayResults (!pq.isEmpty(), "isEmpty on 1 element PQ");

            pq.insert(9);
            displayResults (pq.size() == 2, "size on 2 element PQ");

            pq.insert(7);
            displayResults (pq.size() == 3, "size on 3 element PQ");
        }


        public static void testInsertionAndRemoval() {
            PriorityQueue pq = createNewPriorityQueue();
            System.out.println("Basic testing of removeMin");
            pq.insert(8);
            pq.insert(9);
            pq.insert(10);

            int result;
            result = ((Integer)pq.removeMin()).intValue();
            // System.out.println("res: " + result + ":" + pq);
            displayResults(result == 8, "remove on multiple element PQ");
            displayResults(pq.size() == 2, "remove + size on multiple element PQ");

            result = ((Integer)pq.removeMin()).intValue();
            // System.out.println("res: " + result + ":" + pq);
            displayResults(result == 9, "remove on multiple element PQ");
            displayResults(pq.size() == 1, "remove + size on multiple element PQ");

            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 10, "remove + size on 1 element PQ");
            displayResults(pq.isEmpty(), "remove + isEmpty on 1 element PQ");

            pq = createNewPriorityQueue();
            pq.insert(3);
            pq.insert(2);
            pq.insert(1);

            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 1, "insert + remove on multiple element PQ");
            displayResults(pq.size() == 2, "insert + remove + size on multiple element PQ");

            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 2, "insert + remove on multiple element PQ");
            displayResults(pq.size() == 1, "insert + remove + size on multiple element PQ");

            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 3, "insert + remove on 1 element PQ");
            displayResults(pq.isEmpty(), "insert + remove + size on 1 element PQ");

        }


        public static void testExceptions() {

            PriorityQueue pq = createNewPriorityQueue(2);
            System.out.println("Testing of exceptions");

            try {
                pq.removeMin();
                displayResults(false, "exception should have been thrown");
            } catch (HeapFullException e) {
                displayResults(false, "different exception should have been thrown");
            } catch (HeapEmptyException e) {
                displayResults(true, "HeapEmptyException should be thrown");
            }

            pq.insert(10);
            pq.insert(9);
            try {
                pq.insert(8);
                if(testHeapSolution) {
                    displayResults(false, "exception should have been thrown in heap solution");
                } else {
                    displayResults(true, "exception should not have been thrown in linked version");
                }
            } catch (HeapEmptyException e) {
                displayResults(false, "different exception should have been thrown");
            } catch (HeapFullException e) {
                displayResults(true, "HeapFullException should be thrown");
            }
        }

        public static void testGeneric() {

            PriorityQueue pq = createNewPriorityQueue();
            System.out.println("Testing of removeMin with Strings");
            String result;

            pq.insert("abc");
            pq.insert("def");
            pq.insert("ghi");

            result = ((String)pq.removeMin());
            displayResults(result.equals("abc"), "insert/remove Strings");
            displayResults(pq.size() == 2, "insert/remove Strings");

            result = ((String)pq.removeMin());
            displayResults(result.equals("def"), "insert/remove Strings");
            displayResults(pq.size() == 1, "insert/remove Strings");

            result = ((String)pq.removeMin());
            displayResults(result.equals("ghi"), "insert/remove Strings");
            displayResults(pq.isEmpty(), "insert/remove Strings");

            pq = createNewPriorityQueue();
            pq.insert("ghi");
            pq.insert("def");
            pq.insert("abc");

            result = ((String)pq.removeMin());
            displayResults(result.equals("abc"), "insert/remove Strings");
            displayResults(pq.size() == 2, "insert/remove + size Strings");

            result = ((String)pq.removeMin());
            displayResults(result.equals("def"), "insert/remove Strings");
            displayResults(pq.size() == 1, "insert/remove + size Strings");

            result = ((String)pq.removeMin());
            displayResults(result.equals("ghi"), "insert/remove Strings");
            displayResults(pq.isEmpty(), "insert/remove + isEmpty Strings");
        }

        public static void testDuplicates() {

            PriorityQueue pq = createNewPriorityQueue();
            System.out.println("Testing duplicates.");
            int result;

            pq.insert(4);
            pq.insert(1);
            pq.insert(1);
            pq.insert(5);
            pq.insert(0);
            // System.out.println("q after insert 4 1 1 5 0:" + q);

            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 0, "add duplicates + remove single");

            pq.insert(4);
            pq.insert(1);
            pq.insert(4);
            pq.insert(4);

            pq.insert(0);
            pq.insert(5);
            pq.insert(0);
            pq.insert(5);


            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 0, "add duplicates + remove duplicates");
            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 0, "add duplicates + remove duplicates");


            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 1, "add duplicates + remove duplicates");
            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 1, "add duplicates + remove duplicates");
            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 1, "add duplicates + remove duplicates");

            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 4, "add duplicates + remove duplicates");
            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 4, "add duplicates + remove duplicates");
            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 4, "add duplicates + remove duplicates");
            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 4, "add duplicates + remove duplicates");


            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 5, "add duplicates + remove duplicates");
            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 5, "add duplicates + remove duplicates");
            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 5, "add duplicates + remove duplicates");

            displayResults(pq.isEmpty(), "insert/remove + isEmpty");

        }

        public static void testMixed() {

            PriorityQueue pq = createNewPriorityQueue();
            System.out.println("Testing insert mixed with removeMin.");
            int result;


            pq.insert(2);
            pq.insert(0);
            pq.insert(5);
            pq.insert(7);

            result = ((Integer)pq.removeMin()).intValue();
            displayResults( result == 0, "inserts + remove");

            pq.insert(4);

            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 2, "inserts + remove + insert + remove");

            pq.insert(11);
            pq.insert(2);
            pq.insert(3);
            pq.insert(1);


            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 1, "inserts + remove");

            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 2, "inserts + remove");

            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 3, "inserts + remove");

            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 4, "inserts + remove");

            pq.insert(1);

            result = ((Integer)pq.removeMin()).intValue();
            displayResults(result == 1, "inserts + remove");
            displayResults(pq.size() == 3, "inserts + remove + size");

        }

        public static boolean testRandomArray (int count)
        {
            // These tests are effectively sorting the random values
            //
            // For the heap, this is O (n log n)
            // For the linked list, this is O (n^2)
            PriorityQueue q = createNewPriorityQueue(count);

            System.out.println("Testing size: " + count);
            Random r = new Random();

            for ( int i = 0; i < count; i++ ) {
                int val = r.nextInt(1000000);
                q.insert (val);
            }

            int oldVal = 0; //smallest possible value val could be
            int i = 0;
            while (!q.isEmpty()) {
                int val = (int)((Integer)q.removeMin()).intValue(); // or a bug
                if ( val < oldVal ) {
                    return false;
                }
                oldVal = val;
                i++;
            }
            return true;

        }

        public static void stressTest() {

            System.out.println("Stress Tests.");
            displayResults(testRandomArray(100), "inserts + removes");
            displayResults(testRandomArray(10000), "inserts + removes");
            displayResults(testRandomArray(100000), "inserts + removes");

            //This takes too long using the linked list.
            if (testHeapSolution) {
                displayResults(testRandomArray(1000000), "inserts + removes");
            }

        }

        public static void testPatient() {

            System.out.println("Testing Patient creation, compareTo and equals.");
            Patient p1 = new Patient(2, "Jack Sparrow", "D23", new Time(12,24));
            Patient p2 = new Patient(4, "Hermione Granger", "E12", new Time(12,24));
            Patient p3 = new Patient(2, "Bruce Wayne", "C2", new Time(12,24) );
            Patient p4 = new Patient(4, "Batman", "C2", new Time(9,14) );

            displayResults(p1.compareTo(p2) < 0, "testing Patient compareTo");
            displayResults(p2.compareTo(p1) > 0, "testing Patient compareTo");
            displayResults(p1.compareTo(p1) == 0, "testing Patient compareTo");
            displayResults(p1.compareTo(p3) == 0, "testing Patient compareTo");
            displayResults(p1.compareTo(p4) < 0, "testing Patient compareTo");
            displayResults(p4.compareTo(p1) > 0, "testing Patient compareTo");
            displayResults(p3.equals(p4), "testing Patient equals");

        }

        public static void testEmergencyRoom() {
            System.out.println("Testing adding/removing patients from an emergency room.");
            Patient p1 = new Patient(3, "Jack Sparrow", "D23", new Time(12,24));
            Patient p2 = new Patient(4, "Hermione Granger", "E12", new Time(12,24));
            Patient p3 = new Patient(3, "Bruce Wayne", "C2", new Time(12,24) );
            Patient p4 = new Patient(2, "Han Solo", "R2", new Time(9,14) );
            Patient p5 = new Patient(4, "Diana Prince", "W1", new Time(10,24));
            Patient p6 = new Patient(1, "Ned Stark", "G44", new Time(12,24));

            EmergencyRoom e1 = new EmergencyRoom();
            displayResults(e1.numPatientsWaiting() == 0, "testing EmergencyRoom constructor + numPatientsWaiting");

            e1.addPatient(p1);
            e1.addPatient(p2);
            e1.addPatient(p3);
            e1.addPatient(p4);
            e1.addPatient(p5);

            displayResults(e1.numPatientsWaiting() == 5, "testing EmergencyRoom addPatient + numPatientsWaiting");
            Patient nextP = e1.nextPatient();
            // System.out.println(nextP);
            displayResults(p4.equals(nextP), "testing EmergencyRoom addPatient + numPatientsWaiting");
            displayResults(e1.numPatientsWaiting() == 4, "testing EmergencyRoom addPatient + numPatientsWaiting");

            e1.addPatient(p6);
            displayResults(e1.numPatientsWaiting() == 5, "testing EmergencyRoom addPatient + numPatientsWaiting");

            nextP = e1.nextPatient();
            displayResults(p6.equals(nextP), "testing EmergencyRoom addPatient + nextPatient");
            nextP = e1.nextPatient();
            displayResults(p1.equals(nextP), "testing EmergencyRoom addPatient + nextPatient");
            displayResults(e1.numPatientsWaiting() == 3, "testing EmergencyRoom addPatient + numPatientsWaiting");

            nextP = e1.nextPatient();
            displayResults(p3.equals(nextP), "testing EmergencyRoom addPatient + nextPatient");
            nextP = e1.nextPatient();
            displayResults(p5.equals(nextP), "testing EmergencyRoom addPatient + nextPatient");
            nextP = e1.nextPatient();
            displayResults(p2.equals(nextP), "testing EmergencyRoom addPatient + nextPatient");
            displayResults(e1.numPatientsWaiting() == 0, "testing EmergencyRoom addPatient + numPatientsWaiting");

            nextP = e1.nextPatient();
            displayResults(nextP == null, "testing EmergencyRoom nextPatient - no more ppassengers");

            EmergencyRoom smallRoom = new EmergencyRoom(2);
            smallRoom.addPatient(p1);
            smallRoom.addPatient(p2);

            try {
                smallRoom.addPatient(p3);
                displayResults(true, "testing EmergencyRoom addPatient to full EmergencyRoom - should get here without exception");
            } catch (HeapFullException e) {
                displayResults(false, "testing EmergencyRoom addPatient to full EmergencyRoom - should not get here");
            }

        }


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
    }