package page2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem79 {

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("../../resources/p079_keylog.txt"));
		String line = null;
		Set<String> passwords = new HashSet<>();
		while ((line = br.readLine()) != null) {
			passwords.add(line.trim());
		}
		
		BigInteger code = BigInteger.ZERO;
		String codeString;
		int index;
		boolean match;
		
		while (true) {
			code = code.add(BigInteger.ONE);
			codeString = code.toString();
			match = true;
			
			checkPasswords:
			for (String password : passwords) {
				index = 0;
				for (char ch : password.toCharArray()) {
					index = codeString.substring(index).indexOf(ch);
					if (index == -1) {
						match = false;
						break checkPasswords;
					}
				}
			}
			
			if (match) {
				System.out.println(code);
				break;
			}
		}
	}
}
