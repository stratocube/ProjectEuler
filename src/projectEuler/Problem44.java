package euler;

import java.util.ArrayList;
import java.util.List;

public class Problem44 {

	private static final int LIMIT = 10000;
	private static List<Integer> pentagonalNumbers = new ArrayList<Integer>();
	
	public static void main(String[] args)
	{
		for (int i = 1; i <= LIMIT; i++) {
			pentagonalNumbers.add(i*(3*i-1)/2);
		}
		//System.out.println(pentagonalNumbers);
		
		for (int i = 0; i <= pentagonalNumbers.size()/2; i++) {
			for (int j = i; j <= pentagonalNumbers.size()/2; j++) {
				int a = pentagonalNumbers.get(i);
				int b = pentagonalNumbers.get(j);
				
				int sum = a + b;
				int difference = b - a;
				if (isPentagonal(sum) && isPentagonal(difference)) {
					//System.out.println(b + " + " + a + " = " + sum);
					System.out.println(b + " - " + a + " = " + difference);
				}
			}
		}
	}
	
	private static boolean isPentagonal(int num) {
		int index = (int)Math.sqrt((2*num)/3);
		return num == pentagonalNumbers.get(index);
	}
}
