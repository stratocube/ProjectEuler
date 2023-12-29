package page2;

import java.util.HashSet;
import java.util.Set;

import utils.SieveOfEratosthenes;

public class Problem87 {

	final static int FIFTY_MILLION = 50000000;
	static SieveOfEratosthenes sieve = new SieveOfEratosthenes(1000000);
	static Set<Integer> solutions = new HashSet<>();
	
	public static void main(String[] args)
	{
		int firstPrime = 2;
		int secondPrime = 2;
		int thirdPrime = 2;
		
		int square = firstPrime * firstPrime;
		int cube = secondPrime * secondPrime * secondPrime;
		int fourth = thirdPrime * thirdPrime * thirdPrime * thirdPrime;
		
		int sum = square + cube + fourth;
		
		while (sum < FIFTY_MILLION) {
			while (sum < FIFTY_MILLION) {
				while (sum < FIFTY_MILLION) {
					solutions.add(sum);
					firstPrime = sieve.next(firstPrime);
					square = firstPrime * firstPrime;
					sum = square + cube + fourth;
				}
				firstPrime = 2;
				secondPrime = sieve.next(secondPrime);
				square = firstPrime * firstPrime;
				cube = secondPrime * secondPrime * secondPrime;
				sum = square + cube + fourth;
			}
			firstPrime = 2;
			secondPrime = 2;
			thirdPrime = sieve.next(thirdPrime);
			square = firstPrime * firstPrime;
			cube = secondPrime * secondPrime * secondPrime;
			fourth = thirdPrime * thirdPrime * thirdPrime * thirdPrime;
			sum = square + cube + fourth;
		}
		
		System.out.println(solutions.size());
	}
}
