package page2;

import java.math.BigInteger;
import java.util.ArrayList;

import utils.ContinuousFraction;

public class Problem66 {

	public static void main(String[] args) {
		
		BigInteger maxx = BigInteger.ZERO;
		int maxD = 0;
		
		int D = 1;
		int i = 1;
		while (D <= 1000) {
			if (D == i*i) {
				i++;
				D++;
				continue;
			}
			
			int n = 0;
			while (true) {
				ArrayList<Integer> cycle = ContinuousFraction.squareRootCycle(D);
				String representation = ContinuousFraction.convergent(n, cycle);
				
				String[] parts = representation.split("/");
				BigInteger x = new BigInteger(parts[0]);
				BigInteger y = new BigInteger(parts[1]);
				
				//x^2 = Dy^2+1
				if (x.pow(2).equals(
						BigInteger.valueOf(D).multiply(y.pow(2)).add(BigInteger.ONE))) {
					
					System.out.println("D=" + D + ", x=" + x);
					if (x.compareTo(maxx) > 0) {
						maxx = x;
						maxD = D;
					}
					break;
				}
				n++;
			}			
			D++;
		}
		System.out.println(maxD);
	}
}
