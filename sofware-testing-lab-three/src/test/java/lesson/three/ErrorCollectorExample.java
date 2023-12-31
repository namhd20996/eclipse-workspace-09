package lesson.three;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ErrorCollectorExample {

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void testErrorCollector() {
		collector.addError(new Throwable("There is 	an error in first line"));
		collector.addError(new Throwable("There is 	an error in second line"));
		System.out.println("Hello!..");
		try {
			assertTrue("A" == "B");
		} catch (Throwable e) {
			collector.addError(e);
		}
		System.out.println("World!..");
	}

}
