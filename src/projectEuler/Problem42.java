package projectEuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Problem42 {

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("resources/triangleWords.txt"));
		String line = br.readLine();
		br.close();
		
		int count = 0;
		StringTokenizer tokenizer = new StringTokenizer(line, ",\"");
		
		while (tokenizer.hasMoreTokens()) {
			String word = tokenizer.nextToken();
			if (isTriangleWord(word)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	private static boolean isTriangleWord(String word) {
		int wordValue = 0;
		for (char ch : word.toCharArray()) {
			wordValue += ch-'A'+1;
		}
		wordValue *= 2;
		
		int n = (int)Math.sqrt(wordValue);
		if (n*(n+1) == wordValue) {
			return true;
		}
		
		return false;
	}
}
