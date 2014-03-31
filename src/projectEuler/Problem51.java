package projectEuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem51 {

	public static void main(String[] args) {
		
//		CombinationDistinct test = new CombinationDistinct(Arrays.asList(0,1,2,3),2);
//		while (test.hasNext()) {
//			System.out.println(test.next());
//		}
//		System.exit(1);
		
		int limitDigits = 8;
		SieveOfEratosthenes sieve = new SieveOfEratosthenes(1000000);
		int numPrimeReplacements = 0;
		int numDigits = 0;
		Integer nextPrime = 10;
		List<Integer> indicies;
		char[] primeChars, copyPrime;
		
		while (numPrimeReplacements < limitDigits) {
			nextPrime = sieve.next(nextPrime);
			primeChars = nextPrime.toString().toCharArray();
			numDigits = primeChars.length;
			indicies = new ArrayList<Integer>();
			for (int i = 0; i < numDigits; i++) {
				indicies.add(i);
			}
			
			outer:
			for (int numReplacementDigits = 1; numReplacementDigits < numDigits; numReplacementDigits++) {
				CombinationDistinct selectedIndicies = new CombinationDistinct(indicies, numReplacementDigits);
				
				while(selectedIndicies.hasNext()) {
					List<Integer> replacementIndicies = selectedIndicies.next();
					numPrimeReplacements = 0;
					
					int startDigit = 0;
					//the leading place value cannot be 0
					if (replacementIndicies.contains(new Integer(0))) {
						startDigit = 1;
					}
					for (int replacementDigit = startDigit; replacementDigit <= 9; replacementDigit++) {
						copyPrime = primeChars.clone();
						for (Integer index : replacementIndicies) {
							copyPrime[index] = Character.forDigit(replacementDigit, 10);
						}
						int newNumber = Integer.parseInt(new String(copyPrime));
						if (sieve.isPrime(newNumber)) {
							numPrimeReplacements++;
						}
					}
					
					if (numPrimeReplacements >= limitDigits) {
						break outer;
					}
				}
			}			
		}
		
		System.out.println(nextPrime);
	}
}
