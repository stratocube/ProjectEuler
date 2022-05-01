package page2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem88 {

	public static void main(String[] args) {
		List<Integer> solution;
		Set<Long> minProdSums = new HashSet<>();
		
		solution = getMinProdSumFactors(12000);
		for (int k = 2; k <= 12000; k++) {
			solution = getMinProdSumFactors(k);
			long prodSum = product(solution);
			minProdSums.add(prodSum);
		}
		
		long sum = 0;
		for (long prodSum : minProdSums) {
			sum += prodSum;
		}
		System.out.println(sum);
	}

	private static List<Integer> getMinProdSumFactors(int k) {
		List<Integer> factors = new ArrayList<>(k);
		factors.add(2);
		factors.add(2);

		return recurseProdSumFactors(factors, k);
	}

	private static List<Integer> recurseProdSumFactors(List<Integer> factors, int k) {
		long minProd = Long.MAX_VALUE;
		List<Integer> minFactors = new ArrayList<>();
		
		long prod = product(factors);
		int sum = k - factors.size();
		for (int i = 0; i < factors.size(); i++) {
			sum += factors.get(i);
		}

		int firstElement = factors.get(0);
		while (prod < sum) {
			prod /= firstElement;
			sum -= firstElement;

			firstElement++;

			prod *= firstElement;
			sum += firstElement;
		}
		factors.set(0, firstElement);

		//prod is >=sum
		if (prod == sum && prod < minProd) {
			minProd = prod;
			minFactors = new ArrayList<>(factors);
		}
		
		for (int i = 1; i < factors.size(); i++) {
			int raisedElement = factors.get(i) + 1;
			if (factors.get(i - 1) >= raisedElement) {
				for (int j = 0; j <= i; j++) {
					factors.set(j, raisedElement);
				}
				
				List<Integer> recurseFactors = recurseProdSumFactors(factors, k);
				if (recurseFactors.size() == 0 || minProd <= product(recurseFactors)) {
					return new ArrayList<>(minFactors);
				}
				return new ArrayList<>(recurseFactors);
			}
		}
		
		factors.add(2);
		if (Math.pow(2, factors.size()) > k + factors.size()) {
			return new ArrayList<>(minFactors);
		}
		
		for (int i = 0; i < factors.size()-1; i++) {
			factors.set(i, 2);
		}
		
		List<Integer> recurseFactors = recurseProdSumFactors(factors, k);
		if (recurseFactors.size() == 0 || minProd <= product(recurseFactors)) {
			return new ArrayList<>(minFactors);
		}
		return new ArrayList<>(recurseFactors);
	}
	
	private static long product(List<Integer> factors) {
		long prod = 1;
		for (int i = 0; i < factors.size(); i++) {
			prod *= factors.get(i);
		}
		return prod;
	}
}
