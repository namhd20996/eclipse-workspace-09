package lesson.one;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MathFuncTest {

	private MathFunc func;

	@Before
	public void init() {
		func = new MathFunc();
	}

	@After
	public void tearDown() {
		func = null;
	}

	@Ignore
	@Test
	public void todo() {
		assertTrue(func.plus(1, 1) == 3);
	}

	@Test
	public void calls() {
		assertEquals(0, func.getCalls());

		func.factorial(1);
		assertEquals(1, func.getCalls());

		func.factorial(1);
		assertEquals(2, func.getCalls());
	}

	@Test
	public void factorial() {
		assertTrue(func.factorial(0) == 1);
		assertTrue(func.factorial(1) == 1);
		assertTrue(func.factorial(5) == 120);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void factorialNegative() {
		func.factorial(-1);
	}
	
	

}
