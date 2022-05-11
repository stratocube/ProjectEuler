package page2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Problem80 {

	public static void main(String[] args)
	{
		int n = 1;
		int nextSquare = 1;
		long sum = 0;
		final BigDecimal TWO = BigDecimal.valueOf(2);
		final BigDecimal PRECISION = BigDecimal.ONE.movePointLeft(100); 
		
		for (int i = 1; i <= 100; i++) {
			if (i == nextSquare) {
				n++;
				nextSquare = n*n;
				continue;
			}
			
			BigDecimal number = BigDecimal.valueOf(i);
			BigDecimal root = number;
			BigDecimal rootComplement = BigDecimal.ZERO;
			while (root.subtract(rootComplement).abs().compareTo(PRECISION) > 0) {
				rootComplement = number.divide(root, 105, RoundingMode.FLOOR);
				root = (root.add(rootComplement)).divide(TWO);
			}
			
			String rep = root.toString();
			int decimalIndex = rep.indexOf('.');
			rep = rep.substring(0, decimalIndex) + rep.substring(decimalIndex+1);
			rep = rep.substring(0, 100);
			
			int digitalSum = 0;
			for (char ch : rep.toCharArray()) {
				digitalSum += ch - '0';
			}
			sum += digitalSum;
			System.out.println(i + " : " + digitalSum);
		}
		System.out.println(sum);
	}
}
