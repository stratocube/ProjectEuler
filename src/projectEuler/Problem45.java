package projectEuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem45 {

	private static final BigInteger LIMIT = new BigInteger("10000000000");
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger THREE = new BigInteger("3");
	private static List<BigInteger> pentagonalNumbers = new ArrayList<BigInteger>();
	private static List<BigInteger> triangleNumbers = new ArrayList<BigInteger>();
		
	public static void main(String[] args) 
	{
		BigInteger i;
		
		i = BigInteger.ONE;
		BigInteger triangle = BigInteger.ZERO;
		while (triangle.compareTo(LIMIT) <= 0) {
			triangle = i.multiply(i.add(BigInteger.ONE).divide(TWO));
			triangleNumbers.add(triangle);
			i = i.add(BigInteger.ONE);
		}
		
		i = BigInteger.ONE;
		BigInteger pentagonal = BigInteger.ZERO;
		while (pentagonal.compareTo(LIMIT) <= 0) {
			pentagonal = i.multiply(i.multiply(THREE).subtract(BigInteger.ONE)).divide(TWO);
			pentagonalNumbers.add(pentagonal);
			i = i.add(BigInteger.ONE);
		}
		
		i = BigInteger.ONE;
		BigInteger hexagonal = BigInteger.ZERO;
		while (hexagonal.compareTo(LIMIT) <= 0) {
			hexagonal = i.multiply(i.multiply(TWO).subtract(BigInteger.ONE));
			//System.out.println("Checking " + hexagonal);
			if (isTriangle(hexagonal) && isPentagonal(hexagonal)) {
				System.out.println(hexagonal + " is triple");
			}
			i = i.add(BigInteger.ONE);
		}
	}
	
	private static boolean isTriangle(BigInteger num) {
		int index = bigSqrt(num.multiply(TWO)).intValue() - 1;
		if (index >= triangleNumbers.size()) {
			return false;
		}
		return num.equals(triangleNumbers.get(index));
	}
	private static boolean isPentagonal(BigInteger num) {
		int index = bigSqrt(num.multiply(TWO).divide(THREE)).intValue();
		if (index >= pentagonalNumbers.size()) {
			return false;
		}
		return num.equals(pentagonalNumbers.get(index));
	}
	
	private static BigInteger bigSqrt(BigInteger num) {
		BigInteger prev = BigInteger.ZERO;
		BigInteger x = num.divide(TWO);
		while (prev.subtract(x).abs().compareTo(BigInteger.ONE) > 0) {
			prev = x;
			x = x.add(num.divide(x)).divide(TWO);
		}
		//System.out.println(x);
		return x;
	}
}