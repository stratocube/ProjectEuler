package page1;

import java.util.ArrayList;
import java.util.List;
import utils.*;

public class Problem41 {

	public static void main(String[] args) {
		int n = 7;
		List<Integer> digits = new ArrayList<Integer>();
		for (int i = n; i >= 1; i--) {
			digits.add(i);
		}

		Permuter<Integer> permuter = new Permuter<Integer>(digits);
		permuter.next();
		int candidate = 1;
		List<Integer> permutation;

		do {
			StringBuilder sb = new StringBuilder();
			permutation = permuter.next();
			for (Integer i : permutation) {
				sb.append(i);
			}

			candidate = Integer.parseInt(sb.toString());
			if (isPrime(candidate)) {
				System.out.println(candidate);
				break;
			}

		} while (!permutation.equals(digits));

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
