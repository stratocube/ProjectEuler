package tools;

import java.rmi.NotBoundException;

public class Totient {
	
	public static int getTotient(int number, SieveOfEratosthenes sieve) throws NotBoundException {
		int sqrt = (int) Math.floor(Math.sqrt(number));
		int prime = 2;
		int totient = number, lastPrime = number;
		while (prime <= sqrt) {
			if (totient % prime == 0) {
				totient /= prime;
				totient *= prime-1;
				while (lastPrime % prime == 0) {
					lastPrime /= prime;
				}
			}
			try {
				prime = sieve.next(prime);
			} catch (NotBoundException e) {
				throw e;
			}
		}
		if (lastPrime != 1) {
			totient /= lastPrime;
			totient *= (lastPrime-1);
		}
		
		return totient;
	}
}
