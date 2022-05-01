package page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem74 {
	public static void main(String[] args) {
		
		List<Integer> cycle;
		List<Integer> digitFactorials = Arrays.asList(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880);
		Integer number;
		int count, num60 = 0;
		
		for (int i = 1; i < 1000000; i++) {
			cycle = new ArrayList<Integer>();
			number = i;
			count = 0;
			
			while (!cycle.contains(number)) {
				cycle.add(number);
				count++;
				//System.out.print(number + " -> ");
				
				int sum = 0;
				for (char digitChar : number.toString().toCharArray()) {
					sum += digitFactorials.get(digitChar - '0');
				}
				number = sum;
			}
			
			if (count == 60) {
				num60++;
			}
			//System.out.println();
		}
		System.out.println(num60);
	}
}
