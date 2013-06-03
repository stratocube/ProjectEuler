package projectEuler;

import java.util.HashMap;
import java.util.Map;

public class Problem47 {

	private static final int LIMIT = 1000000;
	
	public static void main(String[] args) {
		
		int count = 0;
		int n = 4;
		Map<Integer, Integer> pf = new HashMap<Integer, Integer>();
		for (int i = 2; i <= LIMIT; i++) {
			pf = primeFactorization(i);
			if (pf.size() != n) {
				count = 0;
				continue;
			}
			
			count++;
			if (count == n) {
				for (int j = i-n+1; j <= i; j++) {
					System.out.println(j);
				}
				break;
			}
		}
	}
	
	private static Map<Integer, Integer> primeFactorization(int number) {
		Map<Integer, Integer> pf = new HashMap<Integer, Integer>();
		
		for (int i = 2; i <= number/2; i++) {
			while (number % i == 0) {
				//System.out.println(number);
				number /= i;
				if (pf.containsKey(i)) {
					pf.put(i, pf.get(i)+1);
				}
				else {
					pf.put(i, 1);
				}
			}
		}
		if (number != 1) {
			pf.put(number, 1);
		}
		return pf;
	}
}
