package projectEuler;

import java.util.ArrayList;

public class Problem26 {

	public static void main(String[] args)
	{
		int max = 0;
		int number = 0;
		for (int i = 1; i < 1000; i++) {
			int r = recurringCycle(i);
			if (r > max) {
				max = r;
				number = i;
			}
		}
		System.out.println("1/" + number + " has " + max + " cycle length");
	}
	
	public static int recurringCycle(int num) {
		
		while (num % 2 == 0) {
			num /= 2;
		}
		while (num % 5 == 0) {
			num /= 5;
		}
		if (num == 1) {
			return 0;
		}
		
		int size = (new Integer(num)).toString().length();
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		int divisor = (int)Math.pow(10, size-1);
		
		int cnt = 0;
		while (!divisors.contains(divisor)) {
			divisors.add(divisor);
			divisor = (10 * divisor % num);
			cnt++;
		}
		
		return cnt;
	}
}
