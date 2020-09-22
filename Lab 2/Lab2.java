/*
CSC 115 - Lab 2
Alex Holland - V00928553
 */
/*
 * Lab2.java
 *
 * A class of static methods that operate on Students
 *
 */
public class Lab2 {

    /*
     *
     * Purpose: determines which of Students s1 and s2
     *  have the higher grade
     *
     * Parameters: Student - s1, Student - s2
     *
     * Precondition: s1 and s2 are not null
     *
     * Returns: Student - the Student with the higher grade,
     *  s1 if they have the same grade
     *
     */
    public static Student getHigherGradeStudent(Student s1, Student s2) {
        // ToDo: implement getHigherGradeStudent
        if (s1.getGrade() >= s2.getGrade()){
            return s1;
        }
        return s2;
    }



    /*
     *
     * Purpose: determines whether the grade of Student s
     *  is above the threshold
     *
     * Parameters: Student - s, int - threshold
     *
     * Returns: boolean - true if grade is above threshold,
     *          false otherwise
     *
     */
    // ToDo: implement isGradeAbove
    public static boolean isGradeAbove(Student s, int threshold){
        return s.getGrade() > threshold;
    }


    /*
     *
     * Purpose: creates an array sIDs of all Students in students
     *
     * Parameters: Student[] - students
     *
     * Returns: String[] - array of sIDs
     *
     */
    // ToDo: implement getClasslist
    public static String[] getClasslist (Student[] students){
        String[] sIDs = new String[students.length];

        for (int i = 0; i < students.length; i++){
            sIDs[i] = students[i].getSID();
        }
        return sIDs;
    }

    /*
     *
     * Purpose: counts the number of Students in students
     *  with grade above threshold
     *
     * Parameters: Student[] - students, int threshold
     *
     * Returns: int - the count
     *
     */
    // ToDo: implement countAbove
    // HINT: you should be using the isGradeAbove method!
    public static int countAbove(Student[] students, int threshold){
       int count = 0;
        for (Student student : students) {
            if (isGradeAbove(student, threshold)) {
                count++;
            }
        }
        return count;
    }


    /*
     *
     * Purpose: calculates the average grade of Students in students,
     *  does NOT include students with 0 grade in calculation
     *  average is 0.0 if students is empty or all students have 0 grade
     *
     * Parameters: Student[] - students
     *
     * Returns: double - the average grade
     *
     */
    // ToDo: implement getClassAverage
    // HINT: you can use the isGradeAbove method again
    public static double getClassAverage(Student[] students){
        double average = 0.0;
        int count = 0;

        //Checks if the students is empty, if it is then set the
        //average to 0.0
        if (students.length == 0){
            return 0.0;
        }
        for (Student student : students) {
            if (isGradeAbove(student, 0)) {
                average += student.getGrade();
            } else {
                count++;
            }
        }
       return average / (students.length - count);
    }


    /*
     *
     * Purpose: creates a new array 1 longer than students
     *  and adds all students and s to the new array
     *
     * Parameters: Student[] - students, Student s
     *
     * Returns: Student[] - the new array
     *
     */

    /*
    java.lang.System.arraycopy() method copies an array from the specified source array,
    beginning at the specified position, to the specified position of the destination array
     */
    // ToDo: implement registerStudent
    public static Student[] registerStudent(Student[] students, Student s){

        Student[] newStudents = new Student[students.length + 1];

        /*
        for (int i = 0; i < students.length; i++){
            newStudents[i] = students[i];
        }
        */
        //This ^^^ can be simplified into this vvv
        System.arraycopy(students, 0, newStudents, 0, students.length);

        newStudents[newStudents.length-1] = s;
        return newStudents;
    }

}