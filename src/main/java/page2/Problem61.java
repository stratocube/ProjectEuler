package page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem61 {
	
	interface PolygonalOperation {
		int calculate(int n);
	}
	static PolygonalOperation Triangle = new PolygonalOperation() {
		public int calculate(int n) {
			return n*(n+1)/2;
		}
	};
	static PolygonalOperation Square = new PolygonalOperation() {
		public int calculate(int n) {
			return n*n;
		}
	};
	static PolygonalOperation Pentagonal = new PolygonalOperation() {
		public int calculate(int n) {
			return n*(3*n-1)/2;
		}
	};
	static PolygonalOperation Hexagonal = new PolygonalOperation() {
		public int calculate(int n) {
			return n*(2*n-1);
		}
	};
	static PolygonalOperation Heptagonal = new PolygonalOperation() {
		public int calculate(int n) {
			return n*(5*n-3)/2;
		}
	};
	static PolygonalOperation Octagonal = new PolygonalOperation() {
		public int calculate(int n) {
			return n*(3*n-2);
		}
	};
	
	public static void main(String[] args) {
		
		int polygonalValue = 1, n;
		List<List<Integer>> validPolygonals = new ArrayList<List<Integer>>();
		List<Integer> polygonalArray;
		List<PolygonalOperation> formulas = (List<PolygonalOperation>)
			Arrays.asList(Triangle, Square, Pentagonal, Hexagonal, Heptagonal, Octagonal);
		
		for (int formula = 0; formula < formulas.size(); formula++) {
			n = polygonalValue = 1;
			polygonalArray = new ArrayList<Integer>();
			while (polygonalValue < 10000) {
				if (polygonalValue >= 1000) {
					polygonalArray.add(polygonalValue);
				}
				n++;
				polygonalValue = formulas.get(formula).calculate(n);
			}
			validPolygonals.add(polygonalArray);
		}
		
		List<Integer> chain = getChain(validPolygonals, new ArrayList<Integer>());
		
		int sum = 0;
		for (Integer i : chain) {
			sum += i;
			System.out.print(i + " ");
		}
		System.out.println("\n" + sum);
	}
	
	private static List<Integer> getChain(List<List<Integer>> selection, List<Integer> trace) {
		List<List<Integer>> copySelection;
		List<Integer> copyTrace;
		
		if (selection.size() == 0) {
			if (trace.get(0) / 100 == trace.get(trace.size()-1) % 100) {
				return trace;
			}
			else {
				return null;
			}
		}
		
		for (List<Integer> list : selection) {
			for (Integer number : list) {
				if (trace.size() != 0 && number / 100 != trace.get(trace.size()-1) % 100) {
					continue;
				}
			
				copySelection = new ArrayList<List<Integer>>(selection);
				copySelection.remove(list);
				copyTrace = new ArrayList<Integer>(trace);
				copyTrace.add(number);
				
				List<Integer> subproblem = getChain(copySelection, copyTrace);
				if (subproblem != null) {
					return subproblem;
				}
			}
		}
		return null;
	}
}
