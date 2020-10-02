/*
CSC 115
Alex Holland - V00928553
 */
public class A2Exercises {

    /*
     * Purpose: Add e to the given array of events
     * Parameters: Event[] array - the array to add the event to
     * 			   Event e - the event to add to the array
     * Returns: Event[] - a new array containing all of the events
     *                    found in arr plus event e
     */
    public static Event[] addEvent(Event[] arr, Event e) {
        // Fix me!
       Event[] result = new Event[arr.length+1];
       /* for (int i = 0; i < arr.length; i++){
            result[i] = arr[i];
        }*/
        System.arraycopy(arr, 0, result, 0, arr.length);
       result[arr.length] = e;
        return result; // so it compiles
    }

    /*
     * Purpose: get the sum of all invites to all events in the array
     * Parameters: Event[] array
     * Returns: int - the total number of invites to all events in the array
     */
    public static int totalInvites(Event[] array) {
        // Fix me!
        int result = 0;
        //for (int i = 0; i < array.length; i++)
        for (Event event : array) {
            result += event.getNumInvites();
        }
        return result; // so it compiles
    }

    /*
     * Purpose: get the number of occasions that occur in
     *          the given month number found in the array
     * Parameters: Event[] arr - the array of events
     *             int - the month number (1:January, 2:February, etc)
     * Returns: int - the number of events that occur in the given month
     */
    public static int eventsInMonth(Event[] arr, int monthNumber) {
        // Fix me!
        int result = 0;
       // for (int i = 0; i < arr.length; i++)
        for (Event event : arr) {
            if (event.getDate().getMonth() == monthNumber) {
                result++;
            }
        }
        return result; // so it compiles
    }

    /*
     * Purpose: Return the event with the date found in the array
     *          that occurs closest to the given date d
     * Parameters Event[] arr - the array to search through
     *            Date d - the date to compare the event dates with
     * Returns: Event - the Event object found in the array that occurs
     *          closest to the date of d
     * Pre-conditions: arr is not empty
     */
    public static Event closestToDate(Event[] arr, Date d) {
        // Fix me!

        int daysInYear = 365;
        Event closest = arr[0];
        int targetDays = d.getDateHelper(d.getMonth()) + d.getDay();
       // System.out.println(targetDays);
        int days;
        Date month = arr[0].getDate();
        int hold;
        int held1 = targetDays - month.getDateHelper(month.getMonth()) + month.getDay();
        int held2 = month.getDateHelper(month.getMonth()) + month.getDay() - targetDays;
        int held3 = (daysInYear - (month.getDateHelper(month.getMonth()) + month.getDay())) + targetDays;
        int held4 = (daysInYear - targetDays) + month.getDateHelper(month.getMonth()) + month.getDay();
       // System.out.println(month.getDateHelper(month.getMonth())+ month.getDay());
        //System.out.println(targetDays);

        if (held1 <= held2){
            hold = held1;
        }else{
            hold = held2;
        }

       if (held1 < 0){
           hold = held2;
       }else if(held2 < 0){
           hold = held1;
       }
        //System.out.println(hold);

       if (hold > held3 && held3 >= 0){
           hold = held3;
          // System.out.println(hold);
       }
       if (held3 > held4 && held4 >= 0){
           hold = held4;
       }
      // System.out.println(held3);
      // System.out.println(hold);

        for (int i = 1; i < arr.length; i++) {
            month = arr[i].getDate();
            days = month.getDateHelper(month.getMonth()) + month.getDay();
           /* System.out.println(month.getDateHelper(month.getMonth()));
            System.out.println(month.getDay());
            System.out.println(targetDays);
            System.out.println(hold);*/

            if ((targetDays - days) < hold && (targetDays - days) >= 0) {
                hold = targetDays - days;
                closest = arr[i];
               // System.out.println(hold);
            }
            if ((days - targetDays) < hold && (days - targetDays) >= 0) {
                hold = days - targetDays;
                closest = arr[i];
               // System.out.println("1 " + hold);
            }
            if ((daysInYear - targetDays + days < hold)){
                hold = (daysInYear - targetDays + days);
                closest = arr[i];
            }
            if ((daysInYear - days + targetDays) < hold){
                hold = (daysInYear - days + targetDays);
                closest = arr[i];
            }
        }
       // System.out.println(hold);
        return closest;
    }
}