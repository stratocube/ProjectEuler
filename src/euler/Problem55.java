package euler;

import java.math.BigInteger;

public class Problem55 {

	public static void main(String[] args) {
		
		int count = 0;
		
		for (Integer i = 0; i < 10000; i++) {
			if(isLychrel(new BigInteger(i.toString()))) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	private static boolean isLychrel(BigInteger num) {
		
		StringBuilder numString = new StringBuilder(num.toString());
		BigInteger mirror = new BigInteger(numString.reverse().toString());
		
		for (int i = 1; i <= 50; i++) {
			
			//System.out.println(num + " + " + mirror);
			num = num.add(mirror);
			//System.out.println(num);
			
			numString = new StringBuilder(num.toString());
			mirror = new BigInteger(numString.reverse().toString());
			
			if (num.equals(mirror)) {
				return false;
			}
		}
		return true;
	}
}
