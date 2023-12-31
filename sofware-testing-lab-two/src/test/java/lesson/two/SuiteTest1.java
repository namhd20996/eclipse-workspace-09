package lesson.two;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SuiteTest1 {

	public String message = "Fpoly";

	JunitMessage junitMessage = new JunitMessage(message);

	@Test(expected = ArithmeticException.class)
	public void testJunitMessage() {
		System.out.println("Junit Message is printing");
		junitMessage.printMessage();
	}

	@Test
	public void testJunitHiMessage() {
		message = "Hi! " + message;
		System.out.println("Junit Hi Message is printing");
		assertEquals(message, junitMessage.printHiMessage());
		System.out.println("Suite test 2 is successfull " + message);
	}
}
