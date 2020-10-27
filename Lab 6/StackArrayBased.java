public class StackArrayBased implements Stack {

    private static final int INIT_SZ = 4;
    private char[] data;
    private int top;
    // NOTICE:  there is no count
    //  think about why you do not need a count given
    //  you are keeping track of the index of top

    public StackArrayBased() {
        data = new char[INIT_SZ];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void push(char val) {
        if(top==data.length-1)
            expandAndCopy();
        data[++top] = val;
    }

    private void expandAndCopy() {
        char[] newData = new char[data.length*2];
        for(int i=0; i<data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    public char pop() {
        char result = data[top--];
        return result;
    }


    public char top()  {
        return data[top];
    }


    public void makeEmpty() {
        top = -1;
    }

    public String toString() {
        String result = "{";
        String separator = "";

        for (int i=top; i>=0; i--) {
            result += separator + data[i];
            separator = ", ";
        }

        result += "}";
        return result;
    }
}
