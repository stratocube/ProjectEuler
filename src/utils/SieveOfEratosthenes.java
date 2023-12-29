package utils;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {

	private List<Boolean> sieve;

	public SieveOfEratosthenes(int limit) {
		sieve = new ArrayList<Boolean>();
		for (int i = 0; i <= limit; i++) {
			sieve.add(true);
		}
		sieve.set(0, false);
		sieve.set(1, false);

		int crosslimit = (int) Math.floor(Math.sqrt(limit));
		for (int i = 2; i <= crosslimit; i++) {
			if (sieve.get(i) == true) {
				for (int j = i * i; j <= limit; j += i) {
					sieve.set(j, false);
				}
			}
		}
	}

	public boolean isPrime(int n) {
		return sieve.get(n);
	}

	public int previous(int n) throws IndexOutOfBoundsException {
		if (n >= sieve.size()) {
			throw new IndexOutOfBoundsException();
		}
		int index = n;
		do {
			index--;
			if (index < 0) {
				throw new IndexOutOfBoundsException();
			}
		} while (sieve.get(index) == false);
		return index;
	}
	
	public int next(int n) throws IndexOutOfBoundsException {
		if (n < 0) {
			throw new IndexOutOfBoundsException();
		}
		int index = n;
		do {
			index++;
			if (index >= sieve.size()) {
				throw new IndexOutOfBoundsException();
			}
		} while (sieve.get(index) == false);
		return index;
	}
}
