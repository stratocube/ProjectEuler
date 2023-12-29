package utils;

import java.math.BigInteger;
import java.util.ArrayList;

public class ContinuousFraction {

	public static ArrayList<Integer> squareRootCycle(int n) {
		int a0 = (int) Math.floor(Math.sqrt(n));
		int numerator = 1;
		int denominator = a0;
		int a = a0;
		
		ArrayList<Integer> coeff = new ArrayList<Integer>();
		coeff.add(a0);
		do {
			numerator = (n - denominator*denominator) / numerator;
			a = (denominator + a0) / numerator;
			denominator = a * numerator - denominator;
			
			coeff.add(a);
		} while ((numerator != 1) || (denominator != a0));
		
		return coeff;
	}
	
	public static String convergent(int index, ArrayList<Integer> array) {
		ArrayList<Integer> coeffArray = new ArrayList<Integer>(array);
		
		BigInteger a0 = BigInteger.valueOf(coeffArray.get(0));
		coeffArray.remove(0);
		
		BigInteger numerator = BigInteger.ZERO;
		BigInteger denominator = BigInteger.ONE;
		
		int cycleIndex = (index-1) % coeffArray.size();
		while (index > 0) {
			BigInteger coeff = BigInteger.valueOf(coeffArray.get(cycleIndex));
			BigInteger temp = numerator;
			numerator = denominator;
			denominator = denominator.multiply(coeff).add(temp);
			
			cycleIndex--;
			if (cycleIndex < 0) {
				cycleIndex = coeffArray.size()-1;
			}
			index--;
		}
		numerator = denominator.multiply(a0).add(numerator);
		
		return numerator.toString() + "/" + denominator.toString();
	}
}
