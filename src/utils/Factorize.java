package utils;

import java.util.HashMap;
import java.util.Map;

public class Factorize {

	public static boolean isPrime(long n) {
		if (n <= 1) {
			return false;
		}
		if (n < 4) {
			return true;
		}
		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}

		long f = 5;
		long r = (long) Math.floor(Math.sqrt(n));
		while (f <= r) {
			if (n % f == 0) {
				return false;
			}
			f += 2;

			if (n % f == 0) {
				return false;
			}
			f += 4;
		}
		return true;
	}
	
	public static Map<Integer,Integer> factor(long number) {
		Map<Integer,Integer> factorization = new HashMap<Integer,Integer>();
		long passNumber[] = { number };
		int exp;
		exp = getExp(passNumber, 2);
		if (exp > 0) {
			factorization.put(2, exp);
		}
		exp = getExp(passNumber, 3);
		if (exp > 0) {
			factorization.put(3, exp);
		}
		
		int divisor = 5;
		while (passNumber[0] != 1) {
			exp = getExp(passNumber, divisor);
			if (exp > 0) {
				factorization.put(divisor, exp);
			}
			divisor += 2;
			exp = getExp(passNumber, divisor);
			if (exp > 0) {
				factorization.put(divisor, exp);
			}
			divisor += 4;
		}
		return factorization;
	}
	
	private static int getExp(long passNumber[], int divisor) {
		int count = 0;
		while (passNumber[0] % divisor == 0) {
			passNumber[0] /= divisor;
			count++;
		}
		return count;
	}
	
	public static int numDivisors(long number) {
		Map<Integer,Integer> factorization = factor(number);
		int numDivisors = 1;
		for (int exponent : factorization.values()) {
			numDivisors *= exponent + 1;
		}
		return numDivisors;
	}
	
	public static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
}
