package page1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem22 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"../../resources/p022_names.txt"));
		String line = br.readLine();
		List<String> names = Arrays
				.asList(line.replaceAll("\"", "").split(","));
		Collections.sort(names);

		long total = 0;
		for (int i = 0; i < names.size(); i++) {
			System.out.print(names.get(i) + ": ");

			int sum = 0;
			for (char letter : names.get(i).toCharArray()) {
				int value = letter - 'A' + 1;
				sum += value;

				// System.out.print(value + ", ");
			}
			System.out.println(sum);
			total += (i + 1) * sum;
		}

		System.out.println("Grand total is: " + total);
		br.close();
	}
}
