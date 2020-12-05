/*
 * Time class
 *  represents time on a 24 hour clock in hours and minutes
 *  from 0:0 to 23:59
 */
public class Time implements Comparable<Time>{

    private static final int MINUTES_PER_HOUR = 60;
    private int hour;   // can be 0 to 23 inclusive
    private int minute; // can be 0 to 59 inclusive


    /*
     * Purpose: Initialize this instance of Time with values for a time of 0:0
     *
     * Parameters: nothing
     */
    public Time () {
        this.hour   = 0;
        this.minute = 0;
    }

    /*
     * Purpose: Initialize this instance of Time with parameter values
     *
     * Parameters: int hour, int minute
     *
     * Precondition: hour and minute specify a valid time on a 24 hour clock
     */
    public Time (int hour, int minute) {
        this.hour   = hour;
        this.minute = minute;
    }


    /*
     * Purpose: Returns the hour associated with this Time
     *
     * Parameters: nothing
     *
     * Returns: (int) - hour associated with this Time
     */
    public int getHour () {
        return this.hour;
    }

    /*
     * Purpose: sets the hour associated with this Time to parameter value
     *
     * Parameters: int hour
     * Returns: nothing
     */
    public void setHour (int hour) {
        this.hour = hour;
    }

    /*
     * Purpose: Returns the minute associated with this Time
     *
     * Parameters: nothing
     *
     * Returns: (int) - minute associated with this Time
     */
    public int getMinute () {
        return minute;
    }

    /*
     * Purpose: sets the minute associated with this Time to parameter value
     *
     * Parameters: int minute
     *
     * Precondition: 0 <= minute <= 59
     *
     * Returns: nothing
     */
    public void setMinute (int minute) {
        this.minute = minute;
    }

    /*
     * Purpose: determines whether the hour and minute of
     *  this instance of Time is equal to other's hour and minute
     *
     * Parameters: Time other
     *
     * Precondition: other is not null and is a valid 24 hour clock time
     *
     * Returns: true if this Time equals other Time, false otherwise
     */
    public boolean equals (Time other) {
        return  other.getHour()   == hour &&
                other.getMinute() == minute;
    }

    /*
     * Purpose: compares this and other times by the total minutes in
     *  hours and minutes combined
     *
     * Parameters: Time other
     *
     * Precondition: other is not null and is a valid 24 hour clock Time
     *
     * Returns: int -
     *  negative number if this time is earlier than other time,
     *  positive number if other time is earlier than this time
     *  0 if times are equal
     */
    public int compareTo (Time other) {
        int thisMinutes = this.hour * MINUTES_PER_HOUR + this.minute;
        int otherMinutes = other.hour * MINUTES_PER_HOUR + other.minute;

        return thisMinutes - otherMinutes;
    }


    /*
     * Purpose: creates a new Time object with the value of
     *  this Time's hour and minute with given minutes added
     *  The new time is a valid 24 hour clock Time
     *
     * Parameters: int minutes
     *
     * Precondition: minutes >= 0
     *
     * Example:
     *  Time t = new Time(23, 30);
     *  t.addTime(70) will change t's hour to 0 and minute to 40
     *  This is because 23:30 == 11:30pm,
     *  we add 70 minutes (1 hr, 10 minutes) => 12:40am = 0:40 on 24 hour clock
     *  RECALL 00:00 is 12:00am which is midnight
     */
    public void addTime(int minutes) {
        int newMinute = minute + minutes;
        int newHour = hour + newMinute/60;

        newMinute %= 60;
        hour = newHour % 24;
        minute = newMinute;

    }


    /*
     * Purpose: returns a String representing this Time formated as:
     *  hour:minute am/pm
     *
     * Parameters: nothing
     *
     * Returns: String - a representation of this Time
     *
     * Example:
     *  Time t = new Time(22, 2)
     *  t.toString() returns "10:2pm"
     *  NOTICE: ignore that the leading 0 is not printed in the minutes
     *  Time t = new Time(0, 22)
     *  t.toString() returns "0:22am"
     *  NOTICE: we are representing 0:00am as 0:0am, not 12:00am to simplify
     */
    public String toString() {
        int newHour = hour % 12;

        String result = newHour + ":" + minute;

        if (hour/12==0)
            result += "am";
        else
            result += "pm";

        return result;
    }
}