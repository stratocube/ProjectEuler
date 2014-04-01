package page2;

import java.util.ArrayList;
import java.util.List;
import tools.*;

public class Problem60 {

	final static int MAX_SIEVE = 10000000;
	
	public static void main(String[] args) {
		SieveOfEratosthenes sieve = new SieveOfEratosthenes(MAX_SIEVE);
		List<Integer> primeList = new ArrayList<Integer>();
		int lastPrime = 1;
		for (int i = 0; i < 3; i++) {
			lastPrime = sieve.next(lastPrime);
			primeList.add(lastPrime);
		}
		lastPrime = sieve.next(lastPrime);
		
		CombinationDistinct combo = null;
		List<Integer> sequence = null;
		CombinationDistinct pairs;
		List<Integer> trial;
		
		boolean solution = false;
		while (!solution) {
			primeList.add(lastPrime);
			lastPrime = sieve.next(lastPrime);
			combo = new CombinationDistinct(primeList, 4);
			
			newCombo:
			while (combo.hasNext()) {
				sequence = combo.next();
				sequence.add(lastPrime);
				//new ArrayList<Integer>(java.util.Arrays.asList(3,7,109))
				pairs = new CombinationDistinct(sequence, 2);
				
				solution = true;
				while (pairs.hasNext()) {
					trial = pairs.next();
					Long candidate1 = Long.parseLong(trial.get(0) + "" + trial.get(1));
					Long candidate2 = Long.parseLong(trial.get(1) + "" + trial.get(0));
					boolean test1 = candidate1 > MAX_SIEVE ? PrimeTest.isPrime(candidate1) : sieve.isPrime(candidate1.intValue());
					boolean test2 = candidate2 > MAX_SIEVE ? PrimeTest.isPrime(candidate2) : sieve.isPrime(candidate2.intValue());
					if (!test1 || !test2) {
						solution = false;
						continue newCombo;
					}
				}
				break;
			}
		}
		
		for (int i : sequence) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
