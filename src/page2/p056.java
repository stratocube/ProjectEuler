package page2;

import java.math.BigInteger;

public class Problem56 {

	public static void main(String[] args) {

		int max = 0;
		BigInteger oneHundred = new BigInteger("100");
		for (BigInteger a = BigInteger.ONE; a.compareTo(oneHundred) < 0; a = a
				.add(BigInteger.ONE)) {
			for (int b = 1; b < 100; b++) {

				int sum = 0;
				String exponent = a.pow(b).toString();
				for (char ch : exponent.toCharArray()) {
					sum += ch - '0';
				}

				if (sum > max) {
					max = sum;
				}
			}
		}

		System.out.println(max);
	}
}
