package lesson.three;

import org.junit.Test;

import junit.framework.TestCase;

public class AppTest extends TestCase{
	
	@Test
	public void testIsEventNumber2() {
		App app = new App();
		boolean result = app.isEventNumber(2);
		assertTrue(result);
	}
	
	@Test
	public void testIsEventNumber4() {
		App app = new App();
		boolean result = app.isEventNumber(3);
		assertTrue(result);
	}
}
