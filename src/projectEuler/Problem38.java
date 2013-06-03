package projectEuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem38 {

	public static void main(String[] args)
	{
		String largest = "";
		for (int n = 2; n <= 9; n++) {
			int max = (int)Math.pow(10, 9/n);
			int min = (int)Math.pow(10, 9/n - 1);
			for (int num = min; num < max; num++) {
				StringBuilder concat = new StringBuilder();
				for (int i = 1; i <= n; i++) {
					concat.append(i * num);
				}
				if (isPandigital(concat.toString())) {
					if (concat.toString().compareTo(largest) > 0) {
						largest = concat.toString();
					}
					System.out.println("n = " + n + ": " + num + " generates " + concat);
				}
			}
		}
		System.out.println("Max is " + largest);
	}
	
	private static boolean isPandigital(String string) {
		List<Character> characters = new ArrayList<Character>();
		for (char c : string.toCharArray()) {
			characters.add(c);
		}
		Collections.sort(characters);
		
		return characters.equals(
			Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
	}
}
