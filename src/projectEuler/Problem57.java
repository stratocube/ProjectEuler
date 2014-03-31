package projectEuler;

import java.math.BigInteger;

public class Problem57 {
	
	public static void main(String[] args) {
		BigInteger numerator = BigInteger.ZERO;
		BigInteger denominator = BigInteger.ONE;
		int count = 0;
		BigInteger tempDenominator, tempNumerator;
		
		for (int i = 1; i <= 1000; i++) {
			
			tempDenominator = denominator.multiply(new BigInteger("2")).add(numerator);
			tempNumerator = denominator;
			
			denominator = tempDenominator;
			numerator = tempNumerator;
			//System.out.println(numerator + "/" + denominator);
			
			tempNumerator = numerator.add(denominator);
			while (tempDenominator != BigInteger.ZERO) {
				tempDenominator = tempDenominator.divide(new BigInteger("10"));
				tempNumerator = tempNumerator.divide(new BigInteger("10"));
			}
			if (tempNumerator != BigInteger.ZERO) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
