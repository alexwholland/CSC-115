public class A2Tester {

    private static int testPassCount = 0;
    private static int testCount = 0;

    public static void main(String[] args) {

        // Uncomment and test one method at a time.
        // Write additional tests as you see fit.

        /* Part 1: The Date class */
        testDateConstructor();
        testEquals();
        testNextDay();
        testDaysUntil();

        /* Part 2: The A2Exercises class */
         testAddEvent();
         testTotalInvites();
         testEventsInMonth();
         testClosestToDate();

        System.out.println("Passed " + testPassCount + "/" + testCount + " tests");
    }

    public static void testDateConstructor() {
        Date d1 = new Date(4, 16);
        Date d2 = new Date(12, 22);
        int result = 0;
        int expected = 0;

        result = d1.getMonth();
        expected = 4;
        displayResults("Date constructor month set", expected==result);

        result = d1.getDay();
        expected = 16;
        displayResults("Date constructor day set", expected==result);

        result = d2.getMonth();
        expected = 12;
        displayResults("Date constructor month set", expected==result);

        result = d2.getDay();
        expected = 22;
        displayResults("Date constructor day set", expected==result);
    }

    public static void testEquals() {
        Date d1 = new Date(4, 16);
        Date d2 = new Date(12, 22);
        Date d3 = new Date(4, 22);
        Date d4 = new Date(4, 16);
        Date d5 = new Date(12, 22);

        boolean result = false;

        result = d1.equals(d2);
        displayResults("d1 equals d2", result==false);
        result = d1.equals(d3);
        displayResults("d1 equals d3", result==false);
        result = d2.equals(d3);
        displayResults("d2 equals d3", result==false);
        result = d1.equals(d4);
        displayResults("d1 equals d4", result==true);
        result = d2.equals(d5);
        displayResults("d2 equals d5", result==true);
        result = d4.equals(d5);
        displayResults("d4 equals d5", result==false);

    }

    public static void testNextDay() {
        Date d1 = new Date(6, 22);
        Date d2 = new Date(8, 31);
        Date d3 = new Date(12, 31);
        Date d4 = new Date(1, 1);

        Date afterD1 = new Date(6, 23);
        Date afterD2 = new Date(9, 1);
        Date afterD3 = new Date(1,1);
        Date afterD4 = new Date(1, 2);

        displayResults("d1 before next day", !d1.equals(afterD1));
        displayResults("d2 before next day", !d2.equals(afterD2));
        displayResults("d3 before next day", !d3.equals(afterD3));
        displayResults("d4 before next day", !d4.equals(afterD4));

        d1.nextDay();
        displayResults("d1 after next day", d1.equals(afterD1));

        d2.nextDay();
        displayResults("d2 after next day", d2.equals(afterD2));

        d3.nextDay();
        displayResults("d3 after next day", d3.equals(afterD3));

        d4.nextDay();
        displayResults("d4 after next day", d4.equals(afterD4));

        // TODO: Add more tests!
    }

    public static void testDaysUntil() {
        Date d1 = new Date(1, 20);
        Date d2 = new Date(1, 23);
        Date d3 = new Date(1, 18);
        Date d4 = new Date(2,17);
        Date d5 = new Date(2,17);
        Date d6 = new Date(2,17);
        Date d7 = new Date(12,31);



        int result = 0;
        int expected = 0;

        result = d1.daysUntil(d2);
        expected = 3;
        displayResults("d1 daysUntil d2", result==expected);

        result = d1.daysUntil(d3);
        expected = 363;
        displayResults("d1 daysUntil d3", result==expected);

        result = d4.daysUntil(d3);
        expected = 335;
        System.out.println(result);
        displayResults("d4 daysUntil d3", result==expected);

        result = d6.daysUntil(d5);
        expected = 0;
        System.out.println(result);
        displayResults("d6 daysUntil d5", result==expected);

        //Multiple tests of the same inputs is to ensure variables are not being unknowingly updated

        result = d6.daysUntil(d5);
        expected = 0;
        System.out.println(result);
        displayResults("d6 daysUntil d5", result==expected);

        result = d6.daysUntil(d5);
        expected = 0;
        System.out.println(result);
        displayResults("d6 daysUntil d5", result==expected);

        result = d6.daysUntil(d5);
        expected = 0;
        System.out.println(result);
        displayResults("d6 daysUntil d5", result==expected);

        result = d2.daysUntil(d4);
        expected = 25;
        System.out.println(result);
        displayResults("d2 daysUntil d4", result==expected);

        result = d4.daysUntil(d1);
        expected = 337;
        System.out.println(result);
        displayResults("d4 daysUntil d1", result==expected);

        result = d1.daysUntil(d7);
        expected = 345;
        System.out.println(result);
        displayResults("d1 daysUntil d7", result==expected);

        result = d7.daysUntil(d1);
        expected = 20;
        System.out.println(result);
        displayResults("d7 daysUntil d1", result==expected);



        // TODO: Add more tests until you are confident your
        //       daysUntil method works correctly.
    }

    public static void testAddEvent() {
        Date d1 = new Date(7, 21);
        Date d2 = new Date(4, 16);
        Date d3 = new Date(10, 12);
        Date d4 = new Date(12, 31);

        Event e1 = new Event("Ali's Birthday", d1, 20);
        Event e2 = new Event("End of exam party", d2, 125);
        Event e3 = new Event("Thanksgiving dinner", d3, 12);
        Event e4 = new Event("New Years Eve", d4, 45);

        Event[] arr0 = {};
        Event[] arr1 = {e3};
        Event[] arr2 = {e3, e1};
        Event[] arr3 = {e3, e1, e2, e4};

        boolean arraysEqual = false;
        Event[] result = null;

        arraysEqual = arrayEquals(arr0, arr1);
        displayResults("arr0 equals arr1 before add", arraysEqual==false);

        result = A2Exercises.addEvent(arr0, e3);
        arraysEqual = arrayEquals(result, arr1);
        displayResults("arr0 equals arr1 after 1 add", arraysEqual==true);

        result = A2Exercises.addEvent(result, e1);
        arraysEqual = arrayEquals(result, arr2);
        displayResults("arr0 equals arr2 after 2 adds", arraysEqual==true);
        arraysEqual = arrayEquals(arr1, arr2);
        displayResults("arr2 equals arr2 after 1 add", arraysEqual==false);

        result = A2Exercises.addEvent(result, e2);
        result = A2Exercises.addEvent(result, e4);
        arraysEqual = arrayEquals(result, arr3);
        displayResults("arr0 equals arr3 after 3 add", arraysEqual==true);
    }

    public static boolean arrayEquals(Event[] arr1, Event[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void testTotalInvites() {
        Event e1 = new Event("Ali's Birthday", new Date(7, 21), 20);
        Event e2 = new Event("End of exam party", new Date(4, 16), 125);
        Event e3 = new Event("Thanksgiving dinner", new Date(10, 12), 12);
        Event e4 = new Event("New Years Eve", new Date(12, 31), 45);

        Event[] arr1 = {};
        Event[] arr2 = {e3, e1};
        Event[] arr3 = {e3, e1, e2, e4};

        int result = 0;
        int expected = 0;

        result = A2Exercises.totalInvites(arr1);
        displayResults("total invites in arr1", result==expected);

        result = A2Exercises.totalInvites(arr2);
        expected = 12+20;
        displayResults("total invites in arr2", result==expected);

        result = A2Exercises.totalInvites(arr3);
        expected = 12+20+125+45;
        displayResults("total invites in arr3", result==expected);
    }

    public static void testEventsInMonth() {
        Event e1 = new Event("Sam's Birthday", new Date(10, 24), 20);
        Event e2 = new Event("End of exam party", new Date(4, 16), 125);
        Event e3 = new Event("Thanksgiving dinner", new Date(10, 12), 12);
        Event e4 = new Event("New Years Eve", new Date(12, 31), 45);
        Event e5 = new Event("Halloween", new Date(10, 31), 80);

        Event[] arr1 = {};
        Event[] arr2 = {e1};
        Event[] arr3 = {e1, e2, e3, e4, e5};

        int result = 0;
        int expected = 0;

        result = A2Exercises.eventsInMonth(arr1, 10);
        displayResults("eventsInMonth(arr1, 10)", result==expected);

        result = A2Exercises.eventsInMonth(arr2, 10);
        expected = 1;
        displayResults("eventsInMonth(arr2, 10)", result==expected);

        result = A2Exercises.eventsInMonth(arr2, 4);
        expected = 0;
        displayResults("eventsInMonth(arr2, 4)", result==expected);

        result = A2Exercises.eventsInMonth(arr3, 4);
        expected = 1;
        displayResults("eventsInMonth(arr3, 4)", result==expected);

        result = A2Exercises.eventsInMonth(arr3, 10);
        expected = 3;
        displayResults("eventsInMonth(arr3, 10)", result==expected);

        result = A2Exercises.eventsInMonth(arr3, 11);
        expected = 0;
        displayResults("eventsInMonth(arr3, 11)", result==expected);
    }

    public static void testClosestToDate() {
        Event e1 = new Event("Sam's Birthday", new Date(10, 24), 20);
        Event e2 = new Event("End of exam party", new Date(4, 16), 125);
        Event e3 = new Event("Thanksgiving dinner", new Date(10, 12), 12);
        Event e4 = new Event("New Years Eve", new Date(12, 31), 45);
        Event e5 = new Event("Halloween", new Date(10, 31), 80);
        Event e6 = new Event("Birthday", new Date(1, 9), 10);
        Event e7 = new Event("Random", new Date(7,12), 40);
        Event e8 = new Event("Random1", new Date(7,12), 40);
        Event e9 = new Event("Singlespace1", new Date(12,11), 40);
        Event e10 = new Event("Singlspace2", new Date(12,9), 40);
        Event e11 = new Event("Gap", new Date(7,1), 40);
        Event e12 = new Event("Birthdayduplicate", new Date(1, 9), 10);
        Event e13 = new Event("No spacing", new Date(1,1), 12);


        Event[] arr1 = {e1};
        Event[] arr2 = {e1, e2, e3, e4, e5};
        Event[] arr3 = {e1, e2, e3, e4, e5};
        Event[] arr4 = {e4, e2};
        Event[] arr5 = {e2, e6};
        Event[] arr6 = {e4, e7};
        Event[] arr7 = {e7, e8};
        Event[] arr8 = {e9, e10};
        Event[] arr9 = {e1, e2, e3, e4, e5, e6, e7, e8, e9, e10};
        Event[] arr10 = {e4, e11};
        Event[] arr11 = {e10, e9, e8, e7, e6, e5, e4, e3, e2, e1};
        Event[] arr12 = {e4, e6};
        Event[] arr13 = {e2, e1, e4};
        Event[] arr14 = {e6, e12, e4, e12};
        Event[] arr15 = {e12, e7};
        Event[] arr16 = {e4, e13};

        Event result = null;
        Event expected = null;

        Date target = new Date(10, 4);
        Date targeta = new Date(12, 10);
        Date targetb = new Date(2, 4);
        Date targetc = new Date(1,1);
        Date targetd = new Date(1, 9);

        result = A2Exercises.closestToDate(arr1, target);
        expected = e1;
        displayResults("closest date in arr1 to Oct 4", result.equals(expected));

        result = A2Exercises.closestToDate(arr2, target);
        expected = e3;
        displayResults("closest date in arr2", result.equals(expected));

        result = A2Exercises.closestToDate(arr3, target);
        expected = e3;
        displayResults("closest date in arr3", result.equals(expected));

        result = A2Exercises.closestToDate(arr4, target);
        expected = e4;
        displayResults("closest date in arr4", result.equals(expected));

        result = A2Exercises.closestToDate(arr5, targeta);
        expected = e6;
        displayResults("closest date in arr5", result.equals(expected));

        result = A2Exercises.closestToDate(arr6, targetb);
        expected = e4;
        displayResults("closest date in arr6", result.equals(expected));

        result = A2Exercises.closestToDate(arr7, targetb);
        expected = e7;
        displayResults("closest date in arr7", result.equals(expected));

        result = A2Exercises.closestToDate(arr8, targeta);
        expected = e9;
        displayResults("closest date in arr8", result.equals(expected));

        result = A2Exercises.closestToDate(arr9, targetb);
        expected = e6;
        displayResults("closest date in arr9", result.equals(expected));

        result = A2Exercises.closestToDate(arr10, targetc);
        expected = e4;
        displayResults("closest date in arr10", result.equals(expected));

        result = A2Exercises.closestToDate(arr11, targetb);
        expected = e6;
        displayResults("closest date in arr11", result.equals(expected));

        result = A2Exercises.closestToDate(arr12, targetc);
        expected = e4;
        displayResults("closest date in arr12", result.equals(expected));

        result = A2Exercises.closestToDate(arr13, targetc);
        expected = e4;
        displayResults("closest date in arr13", result.equals(expected));

        result = A2Exercises.closestToDate(arr14, targetd);
        expected = e6;
        displayResults("closest date in arr14", result.equals(expected));

        result = A2Exercises.closestToDate(arr15, targeta);
        expected = e12;
        displayResults("closest date in arr15", result.equals(expected));

        result = A2Exercises.closestToDate(arr16, targetc);
        expected = e13;
        displayResults("closest date in arr16", result.equals(expected));

        // TODO: Add more tests until you are sure your method works correctly.

    }


    public static void displayResults (String testName, boolean passed) {
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