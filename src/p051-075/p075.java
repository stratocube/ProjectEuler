package page2;

import utils.Factorize;

public class Problem75 {
	public static void main(String[] args) {
		int L = 1500000;
		int sqrtL = (int)Math.sqrt(L);
		int counts[] = new int[L];
		int length;
		
		for (int f1 = 1; f1 <= sqrtL; f1 += 2) {
			for (int f2 = 2; f2 <= sqrtL - f1; f2 += 2) {
				if (Factorize.gcd(f1, f2) == 1) {
					length = Math.abs(f2*f2 - f1*f1) + 2*f1*f2 + (f1*f1 + f2*f2);
					for (int l = length; l < L; l += length) {
						counts[l]++;
					}
				}
			}
		}
		
		int count = 0;
		for (int c : counts) {
			if (c == 1) {
				count++;
			}
		}
		System.out.println(count);
	}
}
