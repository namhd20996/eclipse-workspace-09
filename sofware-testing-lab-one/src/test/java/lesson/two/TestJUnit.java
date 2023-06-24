package lesson.two;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJUnit {
	
	@Test
	public void test() {
		String str = "I am done with Junit setup";
		assertEquals("I am done with Junit setup", str);
	}

}
