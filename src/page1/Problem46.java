package page1;

public class Problem46 {

	private static final long LIMIT = 10000;

	public static void main(String[] args) {
		for (long odd = 3; odd <= LIMIT; odd += 2) {
			if (isPrime(odd)) {
				continue;
			}

			if (!goldbachConjecture(odd)) {
				System.out.println(odd);
				break;
			}
		}
	}

	private static boolean goldbachConjecture(long odd) {
		long maxSquare = odd / 2;
		for (int i = 1; i * i <= maxSquare; i++) {
			long prime = odd - 2 * i * i;
			if (isPrime(prime)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isPrime(long num) {
		if (num < 2) {
			return false;
		}
		if (num == 2 || num == 3) {
			return true;
		}
		if (num % 2 == 0 || num % 3 == 0) {
			return false;
		}

		long n = 5;
		long limit = (long) Math.floor(Math.sqrt(num));
		while (n <= limit) {
			if (num % n == 0) {
				return false;
			}
			if (n % 6 == 1) {
				n += 4;
			} else {
				n += 2;
			}
		}

		return true;
	}
}
