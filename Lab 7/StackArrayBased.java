public class StackArrayBased implements Stack {
    private static final int INIT_SZ = 4;
    private char[] data;
    private int top;
    // notice there is no count

    public StackArrayBased() {
        data = new char[INIT_SZ];
        top = -1;
    }

    public int size() {
        return top+1;
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


    public char pop() throws StackEmptyException {
        if (top == -1) {
            throw new StackEmptyException("thrown within pop()");
        }

        char result = data[top--];

        return result;
    }


    public char peek() throws StackEmptyException {
        if (top == -1) {
            throw new StackEmptyException("thrown within peek()");
        }

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
