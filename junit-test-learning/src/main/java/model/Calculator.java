package model;

public class Calculator {

	public int divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Divide by zero");
		}
		return a / b;
	}

	public double phepTru(Double a, Double b) {
		return a - b;
	}

	public double phepCong(Double a, Double b) {
		return a + b;
	}
}
