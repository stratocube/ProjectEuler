package page1;

import java.util.ArrayList;
import java.util.List;
import tools.*;

public class Problem43 {

	public static void main(String[] args) {
		List<Integer> digits = new ArrayList<Integer>();
		for (int i = 0; i <= 9; i++) {
			digits.add(i);
		}

		Permuter<Integer> permuter = new Permuter<Integer>(digits);
		List<Integer> permutation = (List<Integer>) permuter.next();

		long sum = 0;
		do {
			if (hasProperty(permutation)) {
				long value = arrayValue(permutation);
				System.out.println(value);
				sum += value;
			}
			permutation = (List<Integer>) permuter.next();

		} while (!permutation.equals(digits));

		System.out.println(sum);
	}

	private static boolean hasProperty(List<Integer> list) {
		if (arrayValue(list.subList(1, 4)) % 2 == 0
				&& arrayValue(list.subList(2, 5)) % 3 == 0
				&& arrayValue(list.subList(3, 6)) % 5 == 0
				&& arrayValue(list.subList(4, 7)) % 7 == 0
				&& arrayValue(list.subList(5, 8)) % 11 == 0
				&& arrayValue(list.subList(6, 9)) % 13 == 0
				&& arrayValue(list.subList(7, 10)) % 17 == 0) {
			return true;
		}
		return false;
	}

	private static long arrayValue(List<Integer> list) {
		StringBuilder sb = new StringBuilder();
		for (Integer i : list) {
			sb.append(i);
		}
		return Long.parseLong(sb.toString());
	}
}
