package euler;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19);
	public static void main(String[] args) {
		Permuter permuter1 = new Permuter(list);
		Permuter2 permuter2 = new Permuter2(list);
		long start, end;
		long iterations = 1000000;
		
		start = System.currentTimeMillis();
		for (int i = 0; i < iterations; i++) {
			permuter1.next();
		}
		end = System.currentTimeMillis();
		System.out.println("Permuter1: " + (end - start));
		
		start = System.currentTimeMillis();
		for (int i = 0; i < iterations; i++) {
			permuter2.next();
		}
		end = System.currentTimeMillis();
		System.out.println("Permuter2: " + (end - start));
	}
}
