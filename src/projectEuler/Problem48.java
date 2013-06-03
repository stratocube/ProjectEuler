package projectEuler;

import java.math.BigInteger;

public class Problem48 {

	public static void main(String[] args) {
		
		BigInteger tenDigits = new BigInteger("10").pow(10);
		BigInteger sum = BigInteger.ZERO;
		
		for (int i = 1; i <= 1000; i++) {
			BigInteger self = BigInteger.valueOf(i);
			sum = sum.add(self.modPow(self, tenDigits)).mod(tenDigits);
		}
		
		System.out.println(sum);
	}
}
