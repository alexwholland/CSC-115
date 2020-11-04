public interface Stack
{
    /*
     * Purpose:
     *   return the number of items currently pushed onto the stack.
     *
     * Returns:
     *   the number of items in the stack
     *
     * Examples:
     *
     * If s is: 'x'
     *          'y'
     *          'z'
     *    where 'x' is the top of the stack and 'z' is the bottom of the stack
     *    s.size() returns 3.
     * If s is empty:
     *    s.size() returns 0.
     */
    int size();


    /*
     * Purpose:
     *   returns the boolean state of the stack (empty or not empty)
     *
     * Returns:
     *   true if stack is empty, false otherwise
     *
     * Examples:
     *
     * If s is: 'x'
     *          'y'
     *          'z'
     *    where 'x' is the top of the stack and 'z' is the bottom of the stack
     *    s.size() returns false.
     * If s is empty:
     *    s.size() returns true.
     */
    boolean isEmpty();


    /*
     * Purpose:
     *   places the values passed as a parameter onto the top of
     *   the stack.
     *
     * Returns:
     *   nothing.
     *
     * Examples:
     *
     * If s is: 'x'
     *          'y'
     *          'z'
     *   where 'x' is the top of the stack and 'z' is the bottom of the stack
     *   then after s.push('a'),
     *    s is: 'a'
     *          'x'
     *          'y'
     *          'z'
     *    where 'a' is the top of the stack and 'z' is the bottom of the stack
     * If s is empty:
     *   then after s.push('a'), s is: 'a'.
     *    where 'a' is the top and the bottom of the stack
     */
    void push (char element);


    /*
     * Purpose:
     *   removes the value at the top of the stack (if it exists),
     *   and returns it to the caller. If the stack was empty before
     *   the call, then an exception is thrown by the method.
     *
     * Returns:
     *   The value of type char at the top of the stack (if stack is
     *   non-empty)
     *
     * Examples:
     *
     * If s is: 'x'
     *          'y'
     *          'z'
     *   where 'x' is the top of the stack and 'z' is the bottom of the stack
     *   then after s.pop(),
     *    s is: 'y'
     *          'z'
     *    where 'y' is the top of the stack and 'z' is the bottom of the stack
     *   and x is returned to the caller.
     *
     * If s is empty:
     *    then a StackEmptyException() is thrown.
     */
    char pop() throws StackEmptyException;



    /*
     * Purpose:
     *   returns the value at the top of the stack (if it exists)
     *   but does not modify the contents of the stack. If the stack
     *   was empty before the call, then an exception is thrown
     *   by the method.
     *
     * Returns:
     *   The value of type char at the top of the stack (if stack is
     *   non-empty)
     *
     * Examples:
     *
     * If s is: 'x'
     *          'y'
     *          'z'
     *   where 'x' is the top of the stack and 'z' is the bottom of the stack
     *   then after s.pop(),
     *    s is: 'x'
     *          'y'
     *          'z'
     *    where 'x' is the top of the stack and 'z' is the bottom of the stack
     *   and x is returned to the caller.
     *
     * If s is empty:
     *    then a StackEmptyException() is thrown.
     */
    char peek() throws StackEmptyException;


    /*
     * Purpose:
     *   clear the stack of all its content.
     *
     * Returns:
     *   nothing.
     *
     * Examples:
     *
     * If s is: 'x'
     *          'y'
     *          'z'
     *   where 'x' is the top of the stack and 'z' is the bottom of the stack
     *   then after s.makeEmpty(),
     *    s is empty
     *
     * If s is empty:
     *   then after s.makeEmpty(), s is empty
     */
    void makeEmpty();
}
