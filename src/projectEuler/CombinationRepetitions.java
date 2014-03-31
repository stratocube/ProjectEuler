package projectEuler;

import java.util.ArrayList;
import java.util.List;

/*
 * Combinations with repetitions
 * = Comb(r+n-1, r) where r is number of chosen, n is number of categories
 */
public class CombinationRepetitions {

	List<Integer> numbers;
	int numChosen;
	int[] comboIndicies;
	boolean finished = false;
	
	CombinationRepetitions(List<Integer> numbers, int numChosen) {
		this.numbers = numbers;
		this.numChosen = numChosen;
		
		comboIndicies = new int[numChosen];
		for (int i = 0; i < numChosen; i++) {
			comboIndicies[i] = 0;
		}
	}
	
	boolean hasNext() {
		return !finished;
	}
	
	List<Integer> next() {
		List<Integer> returnValue = new ArrayList<Integer>();
		for (int i = 0; i < numChosen; i++) {
			returnValue.add(numbers.get(comboIndicies[i]));
		}
		
		updateIndicies();
		return returnValue;
	}
	
	private void updateIndicies() {
		int i = 0;
		while (i < numChosen) {
			if (comboIndicies[i] < numbers.size()-1) {
				comboIndicies[i]++;
				for (int j = 0; j < i; j++) {
					comboIndicies[j] = comboIndicies[i];
				}
				return;
			}
			i++;
		}
		finished = true;
	}
}
