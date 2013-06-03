package projectEuler;

import java.util.ArrayList;
import java.util.List;

public class Permuter2 {
	List<Object> list;
	long count;
	long maxPermutations;
	
	public Permuter2(List<?> list) throws IllegalArgumentException {
		if (list.size() > 20) {
			throw new IllegalArgumentException();
		}
		this.list = new ArrayList<Object>(list);
		count = 0;
		maxPermutations = 1;
		
		for (int i = list.size(); i > 1; i--) {
			maxPermutations *= i;
		}
	}
	
	public List<?> get(long permutation) {
		List<Object> available = new ArrayList<Object>(list);
		List<Object> result = new ArrayList<Object>();
		
		while (!available.isEmpty()) {
			long index = permutation;
			for (long i = available.size()-1; i > 1; i--) {
				index /= i;
			}
			index %= available.size();
			
			result.add(available.remove((int)index));
		}
		
		return result;
	}
	
	public List<?> next() {
		List<?> temp = get(count);
		count++;
		if (count >= maxPermutations) {
			count %= maxPermutations;
		}
		return temp;
	}
	
	public void set(long index) {
		count = index;
	}
	
	public void reset() {
		count = 0;
	}
}
