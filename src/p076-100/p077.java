package page2;

import utils.SieveOfEratosthenes;

public class Problem77 {

	public static SieveOfEratosthenes sieve = new SieveOfEratosthenes(1000);
	public static int[][] partition = new int[1000][1000];
	
	public static void main(String args[])
	{
		
		int num = 2;
		int numSums = 0;
		while (numSums <= 5000) {
			num++;
			numSums = numPrimeSums(num, sieve.previous(num));
		}
		
		System.out.println(num + " can be written " + numSums + " ways");
	}
	
	static int numPrimeSums(int number, int highestPrime)
	{
		if (number < 0) {
			return 0;
		}
		if (number == 0) {
			partition[number][highestPrime] = 1;
			return 1;
		}
		if (highestPrime ==2) {
			if (number % 2 == 0) {
				return 1;
			}
			else {
				return 0;
			}
		}
		if (partition[number][highestPrime] != 0) {
			return partition[number][highestPrime];
		}
		
		int sum = numPrimeSums(number - highestPrime, highestPrime) + numPrimeSums(number, sieve.previous(highestPrime));
		
		partition[number][highestPrime] = sum;
		return sum;
	}
}
