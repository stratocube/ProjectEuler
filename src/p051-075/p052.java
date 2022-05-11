package page2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Problem52 {

	public static void main(String[] args) {

		long x = 1;
		while (!sameCharacters(Arrays.asList(6 * x, 5 * x, 4 * x, 3 * x, 2 * x,
				x))) {
			x++;
		}

		System.out.println(x);
	}

	private static boolean sameCharacters(List<Long> list) {

		Iterator<Long> iter = list.iterator();
		Long first = iter.next();
		char characters[] = first.toString().toCharArray();
		Arrays.sort(characters);

		while (iter.hasNext()) {
			Long next = iter.next();
			char ary[] = next.toString().toCharArray();
			Arrays.sort(ary);
			if (!Arrays.equals(ary, characters)) {
				return false;
			}
		}

		return true;
	}
}
