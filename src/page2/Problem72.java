package page2;

import java.rmi.NotBoundException;

import tools.SieveOfEratosthenes;
import tools.Totient;

public class Problem72 {

	public static void main(String[] args) throws NotBoundException {
		SieveOfEratosthenes sieve = new SieveOfEratosthenes(1000000);
		long sum = 0;
		for (int number = 2; number <= 1000000; number++) {
			sum += Totient.getTotient(number, sieve);
		}
		System.out.println(sum);
	}
}
