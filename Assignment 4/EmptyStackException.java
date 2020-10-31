public class EmptyStackException extends RuntimeException {

	public EmptyStackException(String msg) {
		super(msg);
	}

	public EmptyStackException() {
		super();
	}
}