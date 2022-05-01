package page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tools.CombinationDistinct;

public class Problem51 {

	public static void main(String[] args) throws IndexOutOfBoundsException
	{
		int limitDigits = 8;
		tools.SieveOfEratosthenes sieve = new tools.SieveOfEratosthenes(1000000);
		int numPrimeReplacements = 0;
		int numDigits = 0;
		Integer mysteryNum = 0;
		List<Integer> indicies;
		char[] mysteryChars, copyNumber;

		while (numPrimeReplacements < limitDigits) {
			mysteryNum++;
			mysteryChars = mysteryNum.toString().toCharArray();
			numDigits = mysteryChars.length;
			indicies = new ArrayList<Integer>();
			for (int i = 0; i < numDigits; i++) {
				indicies.add(i);
			}

			outer:
			for (int numReplacementDigits = 1; numReplacementDigits < numDigits; numReplacementDigits++) {
				CombinationDistinct selectedIndicies = new CombinationDistinct(indicies, numReplacementDigits);

				while (selectedIndicies.hasNext()) {
					List<Integer> replacementIndicies = selectedIndicies.next();
					numPrimeReplacements = 0;

					int startDigit = 0;
					// the leading place value cannot be 0
					if (replacementIndicies.contains(new Integer(0))) {
						startDigit = 1;
					}
					for (int replacementDigit = startDigit; replacementDigit <= 9; replacementDigit++) {
						copyNumber = Arrays.copyOf(mysteryChars, mysteryChars.length);
						for (Integer index : replacementIndicies) {
							copyNumber[index] = Character.forDigit(replacementDigit, 10);
						}
						int newNumber = Integer.parseInt(new String(copyNumber));
						if (sieve.isPrime(newNumber)) {
							numPrimeReplacements++;
						}
					}

					if (numPrimeReplacements >= limitDigits) {
						System.out.println(replacementIndicies);
						break outer;
					}
				}
			}
		}

		System.out.println(mysteryNum);
	}
}
