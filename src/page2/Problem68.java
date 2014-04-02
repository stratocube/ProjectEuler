package page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem68 {

	public static void main(String[] args) {
	
		FiveRing ring = new FiveRing();
		List<List<Integer>> solutions = findSolutions(ring);
		
		for (List<Integer> solution : solutions) {
			String solutionString = solution.toString().replaceAll("[\\[\\], ]", "");
			if (solutionString.length() == 16) {
				System.out.println(solutionString);
			}
		}
	}
	
	private static List<List<Integer>> findSolutions(FiveRing ring) {
		List<List<Integer>> solutions = new ArrayList<List<Integer>>();
		List<Integer> available = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		for (Integer i = 1; i <= 10; i++) {
			available.remove(i);
			for (Integer j = 1; j <= 10; j++) {
				if (j == i) {
					continue;
				}
				available.remove(j);
				for (Integer k = 1; k <= 10; k++) {
					if (k == i || k == j) {
						continue;
					}
					available.remove(k);
					int sum = i + j + k;
					
					ring.set(0, 0, i);
					ring.set(0, 1, j);
					ring.set(0, 2, k);
					findSolutionsRecurse(ring, 0, 0, available, sum, solutions);
					
					available.add(k);
				}
				available.add(j);
			}
			available.add(i);
		}
		return solutions;
	}
	
	private static void findSolutionsRecurse(FiveRing ring, int line, int node,
			List<Integer> available, int sum, List<List<Integer>> solutions) {
		
		List<Integer> copyAvailable;
		FiveRing copyRing;
		
		while (ring.hasValue(line, node)) {
			node++;
			if (node == 3) {
				//check full line
				if (ring.get(line, 0) + ring.get(line,1) + ring.get(line,2) != sum) {
					return;
				}
				
				node = 0;
				line++;
				if (line == 5) {
					List<Integer> solution = ring.getRepresentation();
					
					//check for cycled solutions
					for (int i = 0; i < solution.size(); i += 3) {
						List<Integer> cycleList = new ArrayList<Integer>(solution.subList(i,solution.size()));
						cycleList.addAll(solution.subList(0, i));
						
						if (solutions.contains(cycleList)) {
							//System.out.println("*" + cycleList.toString());
							return;
						}
					}
					//System.out.println(solution.toString());
					solutions.add(solution);
					return;
				}
			}
		}
		
		for (Integer value : available) {
			
			copyAvailable = new ArrayList<Integer>(available);
			copyAvailable.remove(value);
			
			copyRing = new FiveRing(ring);
			copyRing.set(line, node, value);
			
			findSolutionsRecurse(copyRing, line, node, copyAvailable, sum, solutions);
		}
	}
	
	static class FiveRing {
		private int[][] layout = new int[5][3];
		List<Integer> nodes = new ArrayList<Integer>();
				
		public FiveRing() {
			for (int i = 0; i < 10; i++) {
				nodes.add(null);
			}
			for (int i = 0; i < 5; i++) {
				layout[i][0] = i;
				layout[i][1] = i + 5;
				layout[i][2] = (i+1)%5 + 5;
			}
		}
		
		public FiveRing(FiveRing ring) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					this.layout[i][j] = ring.layout[i][j];
				}
			}
			this.nodes = new ArrayList<Integer>(ring.nodes);
		}
		
		public Integer get(int line, int node) {
			return nodes.get(layout[line][node]);
		}
		
		public void set(int line, int node, int value) {
			nodes.set(layout[line][node], value);
		}
		
		public boolean hasValue(int line, int node) {
			return nodes.get(layout[line][node]) != null;
		}
		
		public String toString() {
			String solution = "";
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					solution += nodes.get(layout[i][j]);
				}
			}
			return solution;
		}
		
		public List<Integer> getRepresentation() {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					list.add(nodes.get(layout[i][j]));
				}
			}
			return list;
		}
	}
} 
