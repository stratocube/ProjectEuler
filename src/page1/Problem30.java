package page1;

import java.util.ArrayList;
import java.util.List;

public class Problem30 {

	public static final int LIMIT = 4;

	public static void main(String[] args) {
		System.out.println(generateSequence(new ArrayList<Integer>(), 6));
	}

	public static long generateSequence(List<Integer> list, int l) {
		long sum = 0;
		if (l == 0) {
			long retVal = checkSumXPowers(list, 5);
			if (retVal > 1) {
				System.out.println(retVal);
				return retVal;
			}
			return 0;
		}

		for (int i = 0; i < 10; i++) {
			List<Integer> copy = new ArrayList<Integer>(list);
			copy.add(i);
			sum += generateSequence(copy, l - 1);
		}

		return sum;
	}

	public static long checkSumXPowers(List<Integer> digits, int x) {
		long sum1 = 0;
		for (Integer i : digits) {
			sum1 += Math.pow(i, x);
		}

		long sum2 = 0;
		for (Integer i : digits) {
			sum2 = 10 * sum2 + i;
		}

		if (sum1 == sum2) {
			return sum1;
		}
		return 0;
	}
}
