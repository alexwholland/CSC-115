public interface Shape{

    /*
     * Purpose: calculates the area of this Shape
     * Parameters: none
     * Returns: double - the area of the shape
     */
    double area();

    /*
     * Purpose: calculates the perimeter of this Shape
     * Parameters: none
     * Returns: double - the perimeter of the shape
     */
    double perimeter();

    /*
     * Purpose: determines whether p is within this Shape
     * Parameters: Point p - the point to search for
     * Precondition: p is not null
     * Returns: boolean - true if p is with this Shape,
     *          false otherwise
     */
    boolean contains(Point p);

    /*
     * Purpose: returns a String reprensentation of this Shape
     * Parameters: none
     * Returns: String - the representation
     */
    String toString();

}