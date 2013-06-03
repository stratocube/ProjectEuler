package projectEuler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Permuter {
	private List<?> original;
	private Set<Integer> availableIndicies;
	private Stack<Integer> indiciesStack;
	
	public Permuter(List<?> list) {
		original = new ArrayList<Object>(list);
		indiciesStack = new Stack<Integer>();
		availableIndicies = new TreeSet<Integer>();
		
		for (int i = original.size()-1; i >= 0; i--) {
			indiciesStack.add(i);
		}
	}
	
	public List<?> next() {
		while (!indiciesStack.isEmpty()) {
			if (trySwapLargerAvailable()) {
				break;
			}
			availableIndicies.add(indiciesStack.pop());
		}
		
		//Fill remaining with lowest in set
		Iterator<Integer> iter = availableIndicies.iterator();
		while (iter.hasNext()) {
			indiciesStack.add(iter.next());
			iter.remove();
		}
		return permutationList();
	}
	
	//Try to search set for a greater index and swap
	private boolean trySwapLargerAvailable() {
		Iterator<Integer> iter = availableIndicies.iterator();
		while (iter.hasNext()) {
			Integer i = iter.next();
			if (i > indiciesStack.peek()) {
				iter.remove();
				availableIndicies.add(indiciesStack.pop());
				indiciesStack.push(i);
				return true;
			}
		}
		return false;
	}
	
	//Translates all indicies in the stack to objects in original list
	private List<Object> permutationList() {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < original.size(); i++) {
			list.add(original.get(indiciesStack.get(i)));
		}
		return list;
	}
}
