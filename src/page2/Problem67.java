package page2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem67 {

	public static void main(String[] args) {
		Scanner reader = null;
		try {
			reader = new Scanner(new File("resources/triangle.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		List<Integer> previousRow = getRow(reader);
		List<Integer> row;
		
		while (reader.hasNextLine()) {
			row = getRow(reader);
			
			row.set(0, row.get(0) + previousRow.get(0));
			for (int i = 1; i < previousRow.size(); i++) {
				row.set(i, row.get(i) + Math.max(previousRow.get(i-1), previousRow.get(i)));
			}
			row.set(row.size()-1, row.get(row.size()-1) + previousRow.get(previousRow.size()-1));
			
			previousRow = row;
		}
		
		int max = 0;
		for (int i : previousRow) {
			if (i > max) {
				max = i;
			}
		}
		System.out.println(max);
	}
	
	private static List<Integer> getRow(Scanner reader) {
		String line = reader.nextLine();
		String[] words = line.split(" ");
		List<Integer> row = new ArrayList<Integer>();
		for (String word : words) {
			row.add(Integer.parseInt(word));
		}
		return row;
	}
}
