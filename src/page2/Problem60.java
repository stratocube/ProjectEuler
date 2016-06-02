package page2;

import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tools.Factorize;
import tools.SieveOfEratosthenes;

public class Problem60 {

	final static int MAX_PRIME = 10000;
	final static int MAX_SIEVE = 10000000;
	
	public static void main(String[] args) throws NotBoundException {
		SieveOfEratosthenes sieve = new SieveOfEratosthenes(MAX_SIEVE);
		List<List<Integer>> primeLists = new ArrayList<List<Integer>>();
		int prime, prime1, prime2;
		
		prime = 3;
		while (prime < MAX_PRIME) {
			primeLists.add(Arrays.asList(prime));
			prime = sieve.next(prime);
			
		}
		
		for (int n = 0; n < 4; n++) {
			List<List<Integer>> swapList = new ArrayList<List<Integer>>();
			for (int i = 0; i < primeLists.size(); i++) {
				List<Integer> primeList = primeLists.get(i);
				
				prime1 = primeList.get(primeList.size()-1);
				prime1 = sieve.next(prime1);
				
				anotherPrime:
				while (prime1 < MAX_PRIME) {
					for (int j = 0; j < primeList.size(); j++) {
						prime2 = primeList.get(j);
						
						long candidate1 = Integer.parseInt(prime1 + "" + prime2);
						long candidate2 = Integer.parseInt(prime2 + "" + prime1);
						boolean test1 = candidate1 > MAX_SIEVE ? Factorize.isPrime(candidate1) : sieve.isPrime((int)candidate1);
						boolean test2 = candidate2 > MAX_SIEVE ? Factorize.isPrime(candidate2) : sieve.isPrime((int)candidate2);
						
						if (!(test1 && test2)) {
							prime1 = sieve.next(prime1);
							continue anotherPrime;
						}
					}
					List<Integer> copyList = new ArrayList<Integer>(primeList);
					copyList.add(prime1);
					swapList.add(copyList);
					prime1 = sieve.next(prime1);
				}
			}
			primeLists = swapList;
		}
		
		for (List<Integer> list : primeLists) {
			System.out.print(list.toString());
			int sum = 0;
			for (Integer i : list) {
				sum += i;
			}
			System.out.println(" " + sum);
		}
	}
}
