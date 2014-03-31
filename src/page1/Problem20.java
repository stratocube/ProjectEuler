package page1;

import java.math.BigInteger;

public class Problem20 {

	public static void main(String[] args) {
		BigInteger factorial = BigInteger.ONE;
		for (Integer i = 1; i <= 100; i++) {
			factorial = factorial.multiply(new BigInteger(i.toString()));
		}

		int sum = 0;
		for (char s : factorial.toString().toCharArray()) {
			sum += s - '0';
		}
		System.out.println(sum);
	}
}
