package page1;

import java.math.BigInteger;

public class Problem25 {

	public static void main(String[] args) {
		BigInteger fibonacci1 = BigInteger.ONE;
		BigInteger fibonacci2 = BigInteger.ONE;

		int cnt = 2;
		while (fibonacci1.toString().length() < 1000) {
			BigInteger temp = fibonacci1;
			fibonacci1 = fibonacci1.add(fibonacci2);
			fibonacci2 = temp;
			cnt++;
		}

		System.out.println(cnt);
	}
}
