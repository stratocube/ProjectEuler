
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.Permuter;

public class p032 {

	static final List<Integer> panDigits = Arrays.asList(1, 2, 3, 4, 5, 6, 7,
			8, 9);

	public static void main(String[] args) throws Exception {
		Permuter<Integer> permuter = new Permuter<Integer>(panDigits);
		permuter.next();

		List<Integer> perm = new ArrayList<Integer>();
		List<Integer> segment;
		BigInteger multiplier1, multiplier2, product, sum;
		Set<BigInteger> products = new TreeSet<BigInteger>();

		while (!perm.equals(panDigits)) {
			perm = permuter.next();

			for (int i = 1; i <= (panDigits.size() + 1) / 4; i++) {
				segment = perm.subList(0, i);
				multiplier1 = asNumber(segment);

				segment = perm.subList(i, (panDigits.size() + 1) / 2);
				multiplier2 = asNumber(segment);

				segment = perm.subList((panDigits.size() + 1) / 2,
						panDigits.size());
				product = asNumber(segment);

				if (multiplier1.multiply(multiplier2).equals(product)) {
					products.add(product);
					System.out.println(multiplier1.toString() + " * "
							+ multiplier2.toString() + " = "
							+ product.toString());
				}
			}
		}

		sum = BigInteger.ZERO;
		for (BigInteger num : products) {
			sum = sum.add(num);
		}
		System.out.println("Total products is " + sum);
	}

	private static BigInteger asNumber(List<Integer> list) {
		StringBuilder builder = new StringBuilder();
		for (Integer i : list) {
			builder.append(i.toString());
		}
		return new BigInteger(builder.toString());
	}
}
