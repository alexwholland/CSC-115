class StackEmptyException extends Exception
{
    String msg;
    public StackEmptyException (String m)
    {
        msg = m;
    }

    public String toString()
    {
        return "StackEmptyException: " + msg;
    }
}