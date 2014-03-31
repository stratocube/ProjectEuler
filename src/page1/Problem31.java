package page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem31 {
	public static final List<Integer> coins = Arrays.asList(200, 100, 50, 20,
			10, 5, 2, 1);

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (@SuppressWarnings("unused")
		Integer i : coins) {
			list.add(0);
		}
		System.out.println(combinations(list, 0));
	}

	public static int combinations(List<Integer> counts, int index) {
		int sum = 0;
		if (index == counts.size()) {
			return 0;
		}
		while (totalAmount(counts, coins) < 200) {
			sum += combinations(counts, index + 1);
			counts.set(index, counts.get(index) + 1);
		}
		if (totalAmount(counts, coins) == 200) {
			sum++;
			// System.out.println(counts);
		}
		counts.set(index, 0);
		return sum;
	}

	public static int totalAmount(List<Integer> counts, List<Integer> coins) {
		int dotProd = 0;
		for (int i = 0; i < counts.size(); i++) {
			dotProd += counts.get(i) * coins.get(i);
		}
		return dotProd;
	}
}
