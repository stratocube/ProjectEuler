package projectEuler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Problem21 {
	public static void main(String[] args)
	{
		TreeSet<Integer> amicableNumbers = new TreeSet<Integer>();
		for (int i = 2; i < 10000; i++) {
			int pair = amicablePair(i);
			if (pair != -1) {
				amicableNumbers.add(i);
				amicableNumbers.add(pair);
				//System.out.println(i + ", " + pair + " are amicable.");
			}
		}
		
		int sum = 0;
		for (Integer i : amicableNumbers) {
			sum += i;
		}
		System.out.println(amicableNumbers);
		System.out.println(sum);
	}
	
	public static int amicablePair(int num1) {
		int num2 = divisorSum(num1);
		if (num1 == divisorSum(num2) && num1 != num2) {
			return num2;
		}
		return -1;
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
					newDivisors.add(elem * (int)Math.pow(factor, i));
				}
			}
			
			divisors = newDivisors;
		}
		divisors.remove(divisors.size()-1);
		
		int sum = 0;
		for (Integer i : divisors) {
			sum += i;
		}
		return sum;
	}
	
	private static Map<Integer, Integer> primeFactorization(int number) {
		Map<Integer, Integer> pf = new HashMap<Integer, Integer>();
		
		for (int i = 2; i <= number/2; i++) {
			while (number % i == 0) {
				//System.out.println(number);
				number /= i;
				if (pf.containsKey(i)) {
					pf.put(i, pf.get(i)+1);
				}
				else {
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
