package page2;

import java.rmi.NotBoundException;
import java.util.Arrays;

import tools.SieveOfEratosthenes;
import tools.Signature;
import tools.Totient;

public class Problem70 {

	public static void main(String[] args) throws NotBoundException {
		int minNumber = 0;
		double minRatio = 10;
		double ratio;
		
		SieveOfEratosthenes sieve = new SieveOfEratosthenes(10000);
		for (int number = 2; number < 10000000; number++) {
			int totient = Totient.getTotient(number, sieve);
			
			String s1 = Arrays.toString(Signature.digitCounts(number));
			String s2 = Arrays.toString(Signature.digitCounts(totient));
			
			if (s1.equals(s2)) {
				ratio = (double) number / totient;
				if (ratio < minRatio) {
					minRatio = ratio;
					minNumber = number;
				}
				//System.out.println(number + " " + totient);
			}
		}
		
		System.out.println(minNumber);
	}
}
