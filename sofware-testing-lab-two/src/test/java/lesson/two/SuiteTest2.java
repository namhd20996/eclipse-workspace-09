package lesson.two;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SuiteTest2 {

	@Test
	public void createAndSetName() {
		String expected = "Y";
		String actual = "Y";
		assertEquals(expected, actual);
		System.out.println("Suite Test 1 is successfull " + actual);
	}
}
