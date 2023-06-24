package exception;

import static org.hamcrest.CoreMatchers.instanceOf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import model.Calculator;

public class CalculatorTestEx {
	
	
	// Khi sử dụng ErrorCollector nó sẽ giúp thu thập tất cả Exception đến hết phương thức 
	// test đó nếu không sử dụng thì khi test chạy khi có Exception nó sẽ thoát và không chạy test tiếp
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Test
	public void testDivideErrorCollector() {
		Calculator calculator = new Calculator();
		
		// Tạo các Throwable để add Excreption cho rõ ràng còn nếu không có thì nó tự động tạo
		collector.addError(new Throwable("Error at the first line"));
		collector.addError(new Throwable("Error at the second line"));
		
		try {
			int result = calculator.divide(9, 0);
		} catch (Exception e) {
			collector.addError(e);
		}
		System.out.println("testDivideErrorCollector");
	}
	
	
	
	// Test với @Rule
	// Ban đầu gắn ngoại lệ là none
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testDivideWithRule() {
		Calculator calculator = new Calculator();
		// Ngoại lệ mong muốn
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage("Divide by zero");
		
		calculator.divide(9, 0);
	}
	

	// Kiểm tra ngoại lệ ném ra có đúng hay không
	@Test(expected = ArithmeticException.class)
	public void testDivideForException() {
		Calculator calculator = new Calculator();
		calculator.divide(9, 0);
	}

	// Kiểm tra ngoại lệ bằng try catch
	@Test
	public void testDivideWithTryCatch() {
		Calculator calculator = new Calculator();
		try {
			int result = calculator.divide(9, 0);
			fail("Not found exception");
		} catch (Exception e) {
			assertThat(e, instanceOf(ArithmeticException.class));
			assertEquals("Divide by zero", e.getMessage());
		}
	}

}
