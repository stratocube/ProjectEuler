package tools;

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

	public int next(int n) {
		int index = n;
		do {
			index++;
			if (index >= sieve.size()) {
				return -1;
			}
		} while (sieve.get(index) == false);
		return index;
	}
}
