package model;

public class JunitMessage {

	private String message;

	public JunitMessage(String message) {
		this.message = message;
	}

	public void printfMessage() {
		System.out.println(message);
		@SuppressWarnings("unused")
		int divide = 1 / 0;
	}

	public String printfHiMessage() {
		message = "Hi!" + message;
		System.out.println(message);
		return message;
	}

}
