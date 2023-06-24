package selenium;

import org.testng.annotations.Test;

public class GroupExampleTest {

	@Test(groups = "groupOne")
	public void testOne() {
		System.out.println("In test case 1 - and in groupOne");
	}

	@Test(groups = "groupOne")
	public void testTwo() {
		System.out.println("In test case 2 - and in groupOne");
	}

	@Test(groups = "groupOne")
	public void testThree() {
		System.out.println("In test case 3 - and in groupOne");
	}

	@Test(groups = "groupTwo")
	public void testFour() {
		System.out.println("In test case 4 - and in groupTwo");
	}

}
