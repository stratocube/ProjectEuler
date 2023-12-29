package utils;

import java.util.ArrayList;
import java.util.List;

/*
 * Combinations with distinct elements
 * C(n, k) = n!/(k!*(n-k)!) where n is size of list, k is number of chosen 
 */
public class CombinationDistinct {
	List<Integer> numbers;
	int numChosen;
	int[] comboIndicies;
	boolean finished = false;

	public CombinationDistinct(List<Integer> numbers, int numChosen) {
		if (numChosen > numbers.size()) {
			return;
		}
		this.numbers = numbers;
		this.numChosen = numChosen;

		comboIndicies = new int[numChosen];
		for (int i = 0; i < numChosen; i++) {
			comboIndicies[i] = i;
		}
	}

	public boolean hasNext() {
		return !finished;
	}

	public List<Integer> next() {
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
			if (i == numChosen - 1
					|| comboIndicies[i] < comboIndicies[i + 1] - 1) {
				comboIndicies[i]++;
				if (comboIndicies[i] == numbers.size()) {
					finished = true;
					return;
				}
				for (int j = 0; j < i; j++) {
					comboIndicies[j] = 0;
				}
				return;
			}
			i++;
		}
	}
}
