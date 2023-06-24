package lesson.three;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JunitAnnotationsExample {

	private ArrayList<String> list;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Using @BeforeClass, expected before all test cases ");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("Using @AfterClass, expected after all test cases ");
	}

	@Before
	public void before() {
		list = new ArrayList<>();
		System.out.println("Using @Before annotations, expected before each test cases ");
	}

	@After
	public void after() {
		list.clear();
		System.out.println("Using @After annotations, expected before each test cases ");
	}

	@Test
	public void testListEmpty() {
		list.add("Test");
		assertFalse(list.isEmpty());
		assertEquals(1, list.size());
	}

	@Ignore
	public void ignore() {
		System.out.println("Using @Ignore annotations, this execution is ignored ");
	}

	@Test(timeout = 10)
	public void testTimeout() {
		System.out.println("Using @Test(timeout = 10), it can be used to enfore timeout in Junit 4 test cases ");
	}

	@Test(expected = NoSuchMethodException.class)
	public void testException() {
		System.out.println(
				"Using @Test(expected = NoSuchMethodException.class), it will check for specified exception during its execution ");
	}

}
