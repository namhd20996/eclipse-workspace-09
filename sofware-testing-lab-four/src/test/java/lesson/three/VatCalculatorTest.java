package lesson.three;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VatCalculatorTest {
	
	@Test
	public void testVatCalculatorTest() {
		VatCalculator calculator = new VatCalculator();
		double expected = 10;
		Assert.assertEquals(calculator.getVatOnAmount(100), expected);
		Assert.assertNotEquals(calculator.getVatOnAmount(120), expected);
		
	}

}
