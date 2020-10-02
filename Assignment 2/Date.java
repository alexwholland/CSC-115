/*
CSC 115
Alex Holland - V00928553
 */
public class Date {
    private int month;
    private int day;

    public Date() {
        month = 1;
        day = 1;
    }

    public Date(int month, int day) {
        // Fix me!
        this.month = month;
        this.day = day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    /*
     * Purpose: get the number of days in this date's month
     * Parameters: none
     * Returns: int - the number of days in the current month
     */
    public int daysInMonth() {
        // You should not modify this method in any way
        if (this.month == 2) {
            return 28;
        } else if (this.month == 4 || this.month == 6 ||
                this.month == 9 || this.month == 11) {
            return 30;
        }
        return 31;
    }

    /*
     * Purpose: return the string representation for this date
     * Parameters: none
     * Returns: String - the string representation
     */
    public String toString() {
        return this.month + "/" + this.day;
    }


    /*
     * Purpose: determine if the current date is equal to other
     * Parameters: Date other - the other date to compare to
     * Returns: boolean - true if they are the same date, false otherwise
     */
    public boolean equals (Date other) {
        // Fix me!
        return this.day == other.getDay() && this.month == other.getMonth();
    }


    /*
     * Purpose: changes this date to the next day
     * Parameters: none
     * Returns: void - nothing
     */
    public void nextDay() {
        // Fix me!
       int days = daysInMonth();
       if (this.day == days){
           if (this.month == 12){
             // this.month = 1;
               setMonth(1);
           }else{
              // this.month += 1;
               setMonth(this.month += 1);
           }
           //this.day = 1;
           setDay(1);
       }else{
          // this.day += 1;
           setDay(this.day += 1);
       }
    }


    /*
     * Purpose: get the number of days it will take to reach the given date
     * Parameters: Date other - the target date
     * Returns: int - the number of days from this date to other
     */
    public int daysUntil(Date other) {
        // Fix me!

        int otherDays = getDateHelper(other.getMonth()) + other.getDay();
        int thisDays = getDateHelper(this.getMonth()) + this.getDay();

        if (thisDays > otherDays){
            return 365 - thisDays + otherDays;
        }
        return otherDays - thisDays;
    }

    public int getDateHelper(int month){
        //31,28,31,30,31,30,31,31,30,31,30,31
        int days = 0;
        if (month == 1){
            days = 0;
        }else if (month == 2){
            days = 31;
        }else if (month == 3){
            days = 59;
        }else if (month == 4){
            days = 90;
        }else if (month == 5){
            days = 120;
        }else if (month == 6){
            days = 151;
        }else if (month == 7){
            days = 181;
        }else if (month == 8){
            days = 212;
        }else if (month == 9){
            days = 243;
        }else if (month == 10){
            days = 273;
        }else if (month == 11){
            days = 304;
        }else if (month == 12){
            days = 334;
        }
        return days;
    }

}