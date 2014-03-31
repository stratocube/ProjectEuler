package projectEuler;

public class Problem58 {

	public static void main(String[] args) {
		
		int cornerDelta = 0;
		int n = 1;
		
		int primeCount = 0;
		int totalDiagonal = 1;
		double ratio = 1;
		
		//SieveOfEratosthenes sieve = new SieveOfEratosthenes(100000);
		
		//for (int k = 0; k < 3; k++) {
		while (ratio >= 0.10) {
			cornerDelta += 2;
			n += cornerDelta;
			if (isPrime(n)) {
				primeCount++;
			}
			
			for (int i = 0; i < 3; i++) {
				n += cornerDelta;
				if (isPrime(n)) {
					primeCount++;
				}
			}
			
			totalDiagonal += 4;
			ratio = (double) primeCount / totalDiagonal;
		}
		System.out.println(primeCount + "/" + totalDiagonal);
		System.out.println(cornerDelta + 1);
	}

	private static boolean isPrime(long n) {
		if (n <= 1) {
			return false;
		}
		if (n < 4) {
			return true;
		}
		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		
		long f = 5;
		long r = (long) Math.floor(Math.sqrt(n));
		while (f <= r) {
			if (n % f == 0) {
				return false;
			}
			f += 2;
			
			if (n % f == 0) {
				return false;
			}
			f += 4;
		}
		return true;
	}
}