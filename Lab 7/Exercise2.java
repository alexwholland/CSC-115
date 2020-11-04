public class Exercise2 {
	/* 	NOTE: we have provided you with the AException and BException classes
		ensure you have downloaded them to the same folder this file is in. */

	/*	TODO 0:
		- Trace the program below on paper
		- compile and run the program - does it match your expected output? */


	/* TODO 1:
		- remove the throws AException from main's signature and recompile
		- Fix compilation errors by wrapping calls to the
			offending method calls in a try/catch block.
			Use Exercise1.java for reference on try/catch usage.
		- Trace the updated program on paper
		- compile and run the program - does it match your expected output? */

	/* 	TODO 2: write a method called bar that takes an int y and prints:
		"start bar" and "end bar" at the beginning and end of the method
		In between print statements, if y is divisible by 3
		bar should print a message that it is throwing an exception
		and then throw a BException */

    public static void main(String[] args) throws AException, BException {
        System.out.println("main start");

        foo(100);
        System.out.println("foo with 100 done");

        foo(23);
        System.out.println("foo with 23 done");

        foo(15);
        System.out.println("foo with 15 done");

        System.out.println("main end");
    }

    public static void foo(int x) throws AException, BException {
        System.out.println("start foo");

        if (x%2 == 0) {
            System.out.println("foo throws");
            throw new AException();
        }

	/* TODO 3:
		- add a call here to bar, passing it the value of x
		- try to compile
		- fix compile error by wrapping the call to bar in try/catch block
			~ in try block, before call to bar print: "calling bar"
			~ in try block, after call to bar print: "done calling bar"
			~ in catch block print: "caught in foo: " + the exception
		- Trace the updated program on paper
		- compile and run the program - does it match your expected output? */
        bar(x);

	/* TODO 4:
		- remove the try/catch block wrapped around the call to bar
		- add BException to the throws list in the signature of foo
			ie. public static void foo(int x) throws AException, BException {...
		- try to compile, fix compile error by:
		- going back to main and add a cascading catch block to catch the BException
			(this is similar syntax to adding an additional else if block)
			~ within the catch block print: "caught in main: " + the exception
		- Trace the updated program on paper
		- compile and run the program - does it match your expected output? */

        System.out.println("end foo");
    }
    public static void bar(int y) throws BException{
        System.out.println("Start bar");
        if (y % 3 == 0){
            System.out.println("bar throws Exception");
            throw new BException();
        }
        System.out.println("End bar");
    }
}