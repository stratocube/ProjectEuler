package page2;

import java.math.BigInteger;

public class Problem63 {

	public static void main(String[] args) {
		
		int count = 0;
		for (Integer d = 1; d <= 9; d++) {
			for (int n = 1; n <= 22; n++) {
				BigInteger number = new BigInteger(d.toString());
				if (number.pow(n).toString().length() == n) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
