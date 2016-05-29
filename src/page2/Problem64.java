package page2;

import java.util.List;
import tools.ContinuousFraction;

public class Problem64 {

	public static void main(String[] args) {
		int count = 0;
		
		int i = 1;
		List<Integer> digits;
		for (int n = 1; n <= 10000; n++) {
			if (n == i*i) {
				i++;
				continue;
			}
			
			//Non-square value
			digits = ContinuousFraction.squareRootCycle(n);
			
			if (digits.size() % 2 == 0) {
				count++;
			}
//			System.out.print("sqrt(" + n + ")=[" + digits.get(0) + ";(");
//			for (int d = 1; d < digits.size()-1; d++) {
//				System.out.print(digits.get(d) + ",");
//			}
//			System.out.println(digits.get(digits.size()-1) + ")]");
		}
		
		System.out.println(count);
	}
}
