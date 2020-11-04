class QueueEmptyException extends Exception
{
    String msg;
    public QueueEmptyException (String m)
    {
        msg = m;
    }

    public String toString()
    {
        return "QueueEmptyException: " + msg;
    }
}