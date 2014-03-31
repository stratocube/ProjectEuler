package page1;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

public class Problem29 {

	static final int LIMIT = 100;

	public static void main(String[] args) {
		Set<BigInteger> powers = new TreeSet<BigInteger>();

		for (int i = 2; i <= LIMIT; i++) {
			for (int j = 2; j <= LIMIT; j++) {
				BigInteger power = BigInteger.valueOf(i).pow(j);

				powers.add(power);
			}
		}

		System.out.println(powers.size());
	}
}
