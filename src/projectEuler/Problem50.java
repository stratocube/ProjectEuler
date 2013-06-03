package projectEuler;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem50 {
	
	static final int LIMIT = 1000000;
	static ArrayList<Integer> primes = generateSieve(LIMIT);
	
	public static void main(String[] args) {
		
		for (int consecutiveLength = primes.size(); consecutiveLength > 0; consecutiveLength--) {
			shiftLoop:
			for (int shift = 0; shift <= primes.size()-consecutiveLength; shift++) {
				int sum = 0;
				for (int i = shift + consecutiveLength - 1; i >= shift; i--) {
					sum += primes.get(i);
					if (sum > LIMIT) {
						continue shiftLoop;
					}
				}
				
				if (isPrime(sum)) {
					System.out.println(sum + " is sum of " + consecutiveLength);
					System.exit(0);
				}
			}
		}
	}
	
	private static boolean isPrime(long num) {
		if (num < 2) {
			return false;
		}
		if (num == 2 || num == 3) {
			return true;
		}
		if (num % 2 == 0 || num % 3 == 0) {
			return false;
		}
		
		long n = 5;
		long limit = (long)Math.floor(Math.sqrt(num));
		while (n <= limit) {
			if (num % n == 0) {
				return false;
			}
			if (n % 6 == 1) {
				n += 4;
			}
			else {
				n += 2;
			}
		}
		
		return true;
	}
	
	private static ArrayList<Integer> generateSieve(int cap) {
		ArrayList<Integer> primes = new ArrayList<Integer>(cap);
		for (int i = 0; i < cap; i++) {
			primes.add(i);
		}
		
		int limit = (int)Math.sqrt(cap);
		for (int i = 2; i <= limit; i++) {
			if (primes.get(i) == 0) {
				continue;
			}
			
			int x = 2*i;
			while (x < cap) {
				primes.set(x, 0);
				x += i;
			}
		}
		primes.set(1, 0);
		primes.removeAll(Arrays.asList(0));
		return primes;
	}
}
