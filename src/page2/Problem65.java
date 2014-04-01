package page2;

import java.math.BigInteger;

public class Problem65 {

	public static void main(String[] args) {
		
		BigInteger remainder;
		BigInteger numerator = BigInteger.ZERO;
		BigInteger denominator = BigInteger.ONE;
		
		for (int i = 100-1; i >= 1; i--) {
			remainder = BigInteger.ONE;
			if ((i+1) % 3 == 0) {
				Integer k = 2*(i+1)/3;
				remainder = new BigInteger(k.toString());
			}
			
			BigInteger temp = numerator;
			numerator = denominator;
			denominator = denominator.multiply(remainder).add(temp);
		}
		numerator = numerator.add(denominator).add(denominator);
		
		System.out.println(numerator + "/" + denominator);
		int sum = 0;
		for (char c : numerator.toString().toCharArray()) {
			sum += c-'0';
		}
		System.out.println(sum);
	}
}
