package page1;

public class Problem27 {
	public static void main(String[] args) {
		int max = 0, a = 0, b = 0;
		for (int i = -999; i < 1000; i++) {
			for (int j = -999; j < 1000; j++) {
				int length = checkQuadratic(i, j);
				if (length > max) {
					max = length;
					a = i;
					b = j;
				}
			}
		}
		System.out.println(max + " " + a + " " + b + " " + a * b);
	}

	public static int checkQuadratic(int a, int b) {
		int n = 0;
		while (isPrime(n * n + a * n + b)) {
			n++;
		}
		return n;
	}

	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		if (num == 2 || num == 3) {
			return true;
		}
		if (num % 2 == 0 || num % 3 == 0) {
			return false;
		}

		int n = 5;
		int limit = (int) Math.floor(Math.sqrt(num));
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
