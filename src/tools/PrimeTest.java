package tools;

public class PrimeTest {

	public static boolean isPrime(long n) {
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
