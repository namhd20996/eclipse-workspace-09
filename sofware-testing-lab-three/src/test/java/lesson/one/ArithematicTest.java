package lesson.one;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.JunitMessage;

public class ArithematicTest {

	private String message = "Fpoly exception";

	JunitMessage junitMessage = new JunitMessage(message);

	@Test(expected = ArithmeticException.class)
	public void testJunitMessage() throws Exception {
		System.out.println("Fpoly Junit message exception is printing");
		junitMessage.printfMessage();
	}

	@Test
	public void testJunitHiMessage() {
		message = "Hi!" + message;	
		System.out.println("Fpoly Junit message is printing");
		assertEquals(message, junitMessage.printfHiMessage());
	}
}
