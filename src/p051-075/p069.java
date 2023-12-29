package page2;

import java.rmi.NotBoundException;
import utils.SieveOfEratosthenes;
import utils.Totient;

public class Problem69 {

	public static void main(String[] args) throws NotBoundException {
		SieveOfEratosthenes sieve = new SieveOfEratosthenes(10000);
		int maxNumber = 0;
		double maxRatio = 0;
		
		for (int number = 2; number <= 1000000; number++) {
			
			int totient = Totient.getTotient(number, sieve);
			
			double ratio = (double) number / totient;
			if (ratio > maxRatio) {
				maxRatio = ratio;
				maxNumber = number;
			}
			//System.out.println("n: " + number + " t: " + totient);
		}
		System.out.println(maxNumber);
	}
}
