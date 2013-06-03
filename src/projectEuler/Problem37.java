package projectEuler;

import java.util.ArrayList;

public class Problem37 {
	static final int LIMIT = 1000000;
	static ArrayList<Integer> primes = generateSieve(LIMIT);
	
	public static void main(String[] args)
	{
		ArrayList<Integer> truncablePrimes = new ArrayList<Integer>();
		StringBuilder sb;
		forLoop:
		for (int i = 11; i < LIMIT; i++) {
			sb = new StringBuilder(new Integer(i).toString());
			while (sb.length() != 0) {
				if (primes.get(Integer.parseInt(sb.toString())) == 0) {
					continue forLoop;
				}
				sb.deleteCharAt(0);
			}
			
			sb = new StringBuilder(new Integer(i).toString());
			while (sb.length() != 0) {
				if (primes.get(Integer.parseInt(sb.toString())) == 0) {
					continue forLoop;
				}
				sb.deleteCharAt(sb.length()-1);
			}
			
			truncablePrimes.add(i);
		}
		
		System.out.println("Found " + truncablePrimes.size() + ": " + truncablePrimes);
		int sum = 0;
		for (Integer i : truncablePrimes) {
			sum += i;
		}
		System.out.println(sum);
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
		return primes;
	}
}
