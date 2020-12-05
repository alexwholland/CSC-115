public class HeapEmptyException extends RuntimeException {

    public HeapEmptyException(String msg) {
        super(msg);
    }

    public HeapEmptyException() {
        super();
    }

}