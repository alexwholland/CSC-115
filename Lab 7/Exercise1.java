public class Exercise1 {

    public static void main(String[] args)  {

        System.out.println("start of main");

		/*	TODO 0: uncomment the following 2 lines of code
			Trace on paper to determine the output before you run it
			Your TA will want to see your trace. */
        // foo();
        // System.out.println("in main after foo");

		/* 	TODO 1: recomment out the 2 lines of code above and
			uncomment the following 2 lines of code
			Trace on paper to determine the output before you run it
			Your TA will want to see your trace. */
        // bar();
        // System.out.println("in main after bar");

		/* 	TODO 2: on your paper, answer the following 2 questions.
			Is ArrayIndexOutOfBoundsException a checked or unchecked exception?
			When is this exception thrown? */


		/* 	NOTE: Your TA will want to see your 2 traces and
			the answers to the questions in TODO 3. */

        System.out.println("end of main");
    }

    public static void foo()  {
        System.out.println("start of foo");

        int[] array = {1, 2, 3};

        System.out.println(array[3]);

        System.out.println("end of foo");
    }

    public static void bar()  {
        System.out.println("start of bar");

        int[] array = {1, 2, 3};

        try {
            System.out.println(array[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("catching in bar: " + e);
        }

        System.out.println("end of bar");
    }

}