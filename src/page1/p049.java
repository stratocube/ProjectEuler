package page1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem49 {

	public static void main(String[] args) {

		for (int i = 2; i < 10000; i++) {
			if (!isPrime(i)) {
				continue;
			}

			for (int j = 1; j <= (10000 - i) / 2; j++) {
				if (!isPrime(i + j) || !isPrime(i + 2 * j)) {
					continue;
				}

				if (sortedDigits(i).equals(sortedDigits(i + j))
						&& sortedDigits(i + j).equals(sortedDigits(i + 2 * j))) {
					System.out.println(i + " " + (i + j) + " " + (i + 2 * j));
				}
			}
		}
	}

	private static List<Integer> sortedDigits(int num) {
		List<Integer> list = new ArrayList<Integer>();
		while (num != 0) {
			list.add(num % 10);
			num /= 10;
		}
		Collections.sort(list);
		return list;
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
