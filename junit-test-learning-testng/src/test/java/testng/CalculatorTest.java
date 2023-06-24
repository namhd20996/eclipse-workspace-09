package testng;

import org.testng.annotations.Test;

import model.Calculator;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;

public class CalculatorTest {
  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest");
  }


  @Test
  public void plusTest() {
	  Calculator calculator = new Calculator();
	  int result = calculator.plus(5, 6);
	  int expected = 10;
	  assertEquals(result, expected);
  }
}
