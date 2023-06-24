package lesson.one;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class MathRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(MathFuncTest.class);
		System.out.println("run Tests: " + result.getRunCount());
		System.out.println("fail Tests: " + result.getFailureCount());
		System.out.println("ignore Tests: " + result.getIgnoreCount());
		System.out.println("success Tests: " + result.wasSuccessful());
	}

}
