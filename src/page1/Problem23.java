package page1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem23 {
	static final int LIMIT = 28123;

	public static void main(String[] args) throws Exception {
		ArrayList<Integer> abundantList = new ArrayList<Integer>();
		for (int i = 1; i <= LIMIT; i++) {
			if (isAbundant(i)) {
				abundantList.add(i);
			}
		}
		// System.out.println("Abundant list:");
		// System.out.println(abundantList);

		Set<Integer> abundantSums = new TreeSet<Integer>();
		for (int i = 0; i < abundantList.size(); i++) {
			for (int j = i; j < abundantList.size(); j++) {
				int sumPair = abundantList.get(i) + abundantList.get(j);
				if (sumPair <= LIMIT) {
					abundantSums.add(sumPair);
				}
			}
		}
		// System.out.println("Abundant sums:");
		// System.out.println(abundantSums);

		long sumNonAbundant = 0;
		long sumAbundant = 0;
		for (int i = 1; i <= LIMIT; i++) {
			if (!abundantSums.contains(i)) {
				sumNonAbundant += i;
			} else {
				sumAbundant += i;
			}
		}
		System.out.println("Sum of all non abundant sums: " + sumNonAbundant);
		System.out.println("Sum of all abundant sums: " + sumAbundant);
		System.out.println("Sum of all numbers to LIMIT: " + (LIMIT * (LIMIT + 1) / 2));
		System.out.println(sumNonAbundant);
	}

	public static boolean isAbundant(int num) {
		if (num < divisorSum(num)) {
			return true;
		}
		return false;
	}

	public static int divisorSum(int number) {

		Map<Integer, Integer> primeFactors = primeFactorization(number);
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		ArrayList<Integer> newDivisors;
		divisors.add(1);

		for (Integer factor : primeFactors.keySet()) {
			newDivisors = new ArrayList<Integer>();

			for (Integer elem : divisors) {
				for (int i = 0; i <= primeFactors.get(factor); i++) {
					newDivisors.add(elem * (int) Math.pow(factor, i));
				}
			}

			divisors = newDivisors;
		}
		divisors.remove(divisors.size() - 1);

		int sum = 0;
		for (Integer i : divisors) {
			sum += i;
		}
		return sum;
	}

	private static Map<Integer, Integer> primeFactorization(int number) {
		Map<Integer, Integer> pf = new HashMap<Integer, Integer>();

		for (int i = 2; i <= number / 2; i++) {
			while (number % i == 0) {
				// System.out.println(number);
				number /= i;
				if (pf.containsKey(i)) {
					pf.put(i, pf.get(i) + 1);
				} else {
					pf.put(i, 1);
				}
			}
		}
		if (number != 1) {
			pf.put(number, 1);
		}
		return pf;
	}
}
