package page2;

import java.util.ArrayList;
import java.util.List;

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
			int a0 = i-1;
			int numerator = 1;
			int denominator = a0;
			int a;
			
			digits = new ArrayList<Integer>();
			do {
				numerator = (n - denominator*denominator) / numerator;
				a = (denominator + a0) / numerator;
				denominator = a * numerator - denominator;
				digits.add(a);
				
			} while ((numerator != 1) || (denominator != a0));
			
			if (digits.size() % 2 == 1) {
				count++;
			}
//			System.out.print("sqrt(" + n + ")=" + "[" + a0 + ";(");
//			for (int d = 0; d < digits.size()-1; d++) {
//				System.out.print(digits.get(d) + ",");
//			}
//			System.out.println(digits.get(digits.size()-1) + ")]");
		}
		
		System.out.println(count);
	}
}
