package page2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem59 {

	public static void main(String[] args) {
		
		int passwordLength = 3;
		List<Character> password = new ArrayList<Character>(passwordLength);
		
		Scanner reader = null;
		try {
			reader = new Scanner(new File("resources/cipher1.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		List<Integer> cipherChars = new ArrayList<Integer>();
		reader.useDelimiter(",");
		while (reader.hasNextInt()) {
			cipherChars.add(reader.nextInt());
		}
		
		Map<Integer,Integer> letterCounts;
		for (int i = 0; i < passwordLength; i++) {
			int index = i;
			letterCounts = new TreeMap<Integer,Integer>();
			
			while (index < cipherChars.size()) {
				Integer nextChar = cipherChars.get(index);
				if (letterCounts.containsKey(nextChar)) {
					letterCounts.put(nextChar, letterCounts.get(nextChar)+1);
				}
				else {
					letterCounts.put(nextChar, 1);
				}
				index += passwordLength;
			}
			
			int max = Collections.max(new ArrayList<Integer>(letterCounts.values()));
			for (Integer key : letterCounts.keySet()) {
				if (letterCounts.get(key) == max) {
					password.add((char) (' ' ^ key));
					break;
				}
			}
		}
		
		for (char c : password) {
			System.out.print(c);
		}
		System.out.println();
		
		int i = 0;
		int sum = 0;
		for (int c : cipherChars) {
			char decrypt = (char)((char)c ^ password.get(i%passwordLength));
			System.out.print(decrypt);
			sum += decrypt;
			i++;
		}
		System.out.println();
		System.out.println("Sum of ascii is " + sum);
	}
}
