package euler;

import java.util.ArrayList;

public class Problem35 {

	static final int LIMIT = 1000000;
	static ArrayList<Integer> primes = generateSieve(LIMIT);

	public static void main(String[] args) {
		int count = 0;
		for (int i = 2; i < LIMIT; i++) {
			if (isCyclic(i)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	private static boolean isCyclic(int num) {
		
		int rotation = num;
		int length = (int)Math.log10(num);
		do {
			if (primes.get(rotation) == 0) {
				return false;
			}
			
			int lastDigit = rotation % 10;
			rotation /= 10;
			rotation += lastDigit * Math.pow(10, length);
			
		} while (rotation != num);
		
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
		return primes;
	}
}
