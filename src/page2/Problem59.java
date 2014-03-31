package page2;

import java.util.Scanner;

public class Problem59 {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner("resources/cipher1.txt");
		while (reader.hasNextInt()) {
			System.out.println(reader.nextInt());
		}
		System.out.println((char)('A' ^ '*'));
	}
}
