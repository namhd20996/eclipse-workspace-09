package parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import model.Calculator;

@RunWith(Parameterized.class)
public class CalculatorParameterized {

	private int firstNumber;
	private int secondNumber;
	private int expectedResult;
	private Calculator calculator;

	@Before
	public void init() {
		calculator = new Calculator();
	}

	public CalculatorParameterized(int firstNumber, int secondNumber, int expectedResult) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.expectedResult = expectedResult;
	}
	
	// Data dùng để test cần phải khai báo @Parameterized.Parameters
	// Khi khai báo tự động sẽ chèn các value vào constructor khi test
	@Parameterized.Parameters
	public static Collection numbers() {
		return List.of(
				new Integer[][] {
					{4,5,6}	,
					{6,7,8},
					{0,1,0},
					{4,2,2},
					{0,5,0},
					{-8,-2,4}
				});
	}
	
	@Test
	public void testDivide() {
		System.out.printf("\n Parameterized: %d / %d = expected: %d",
				firstNumber, secondNumber, expectedResult);
		int result = calculator.divide(firstNumber, secondNumber);
		assertEquals(expectedResult, result);
	}

}
