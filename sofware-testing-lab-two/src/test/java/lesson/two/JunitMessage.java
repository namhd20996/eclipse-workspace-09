package lesson.two;

public class JunitMessage {

	private String message;

	public JunitMessage(String message) {
		this.message = message;
	}

	public String printMessage() {
		throw new ArithmeticException();
	}

	public String printHiMessage() {
		System.out.println(message);
		return "Hi! " + message;
	}
}
