package learning;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Calculator;

public class CalculatorTests {

	private Calculator calculator;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
		calculator = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
		calculator = null;
	}

	@Test
	public void testPhepTru() {
		System.out.println("testPhepTru");
		assertEquals(0.0, calculator.phepTru(5.0, 5.0), 0.01);
	}

	@Test
	public void testPhepCong() {
		System.out.println("testPhepCong");
		assertEquals(0.0, calculator.phepCong(5.0, 5.0), 0.01);
	}

}
