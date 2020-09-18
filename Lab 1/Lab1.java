/*
CSC 115 Lab 1
Alex Holland - V00928553
2020-09-16
 */

/*
 * Lab1.java
 *
 * A class of static methods with errors
 *
 */
public class Lab1 {

    /*
     * Purpose: returns a String representation of array
     * Parameters: int[] - array containing integers
     * Returns: String - the textual representation of the array
     */

    /*
    Changes: Added '=' inside the for loop. created an if statement to only add a ','
             if the last element of the array has not been reached
    */

    public static String getString(int[] array) {
        String result = "{";

        for(int i = 0; i <= array.length-1; i++) {
            result += array[i];
            if (i != array.length-1){
                result += ",";
            }
        }
        result += "}";

        return result;
    }

    /*
     * Purpose: calculates the average of a, b and c
     * Parameters: int a, int b, int c
     * Returns: double - the average of the three integers
     */

    //Changes: Added brackets around a,b,c

    public static double getAverage(int a, int b, int c) {
        double result = 0;

        result = (a + b + c) / 3.0;

        return result;
    }

    /*
     * Purpose: returns a count of the number of elements
     *  in array bigger than the given threshold
     * Parameters: int[] array, int threshold
     * Returns: int - the number of elements in the array above threshold
     */

    /*
     Changes: Removed an else statement that was terminating the loop whenever an
              array value was not greater than the threshold
     */

    public static int countAbove(int[] array, int threshold) {
        int count = 0;

        for(int i=0; i<array.length; i++) {
            if (array[i]>threshold) {
                count++;
            }
        }

        return count;
    }

    /*
     * Purpose: finds the biggest number in the array of integers
     * Parameters: int[] - the array of integers
     * Returns: int - the maximum value found in the array
     */

    /*
    Changes: Set max to be the first element in the array. Then made the if statement only set the
             current value to be max if it was greater than the currently held max value.
     */

    public static int getMax(int[] array) {
        int max = array[0];

        for(int i=1; i<array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }


    /*
     * Purpose: determines whether the numbers in array
     *  are in sorted increasing order
     * Parameters: int[] array
     * Returns: boolean - true if sorted, false otherwise
     */

    /*
    Changes: Made i less than the array length - 1. removed '=' from if statement.
             Removed else statement that would prematurely terminate the loop.
     */

    public static boolean isSorted(int[] array) {

        for(int i = 0; i < array.length - 1; i++) {
            if (array[i+1] < array[i]) {
                return false;
            }
        }
        return true;
    }


}