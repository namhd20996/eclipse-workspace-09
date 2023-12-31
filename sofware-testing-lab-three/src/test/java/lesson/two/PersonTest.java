package lesson.two;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import model.Person;

@SuppressWarnings("deprecation")
public class PersonTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testExceptionOne() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("");
		new Person("Nam", -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionTwo() {
		new Person("Nam", -1);
	}

	@Test
	public void testExceptionThree() {
		try {
			new Person("Nam", -1);
			fail("Should...");
		} catch (IllegalArgumentException e) {
			assertThat(e, instanceOf(IllegalArgumentException.class));
//			assertEquals("Invalid age: " + person.getAge(), e.getMessage());
		}
	}

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void testExceptionFour() {
		collector.addError(new Throwable("First: "));
		collector.addError(new Throwable("Second: "));
		try {
			new Person("Nam", -1);
		} catch (Exception e) {
			collector.addError(e);
		}
	}
}
