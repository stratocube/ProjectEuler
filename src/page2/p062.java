package page2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem62 {

	public static void main(String[] args) {
		
		Map<String, List<BigInteger>> registry = new HashMap<String, List<BigInteger>>();
		List<BigInteger> cubeList;
		
		BigInteger n = BigInteger.ONE;
		BigInteger cube, solution;
		int counts[];
		String signature;
		
		while(true) {
			cube = n.pow(3);
			counts = new int[10];
			signature = "";
			
			for (char c : cube.toString().toCharArray()) {
				counts[c-'0']++;
			}
			for (int i = 0; i < 10; i++) {
				signature += counts[i];
			}
			
			if (registry.containsKey(signature)) {
				cubeList = registry.get(signature);
				cubeList.add(cube);
				registry.put(signature, cubeList);
				if (cubeList.size() == 5) {
					solution = cubeList.get(0);
					break;
				}
			}
			else {
				ArrayList<BigInteger> newList = new ArrayList<BigInteger>();
				newList.add(cube);
				registry.put(signature, newList);
			}
			n = n.add(BigInteger.ONE);
		}
		
		System.out.println(solution);
	}
}
