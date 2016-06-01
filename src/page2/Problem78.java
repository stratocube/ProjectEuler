package page2;

import java.math.BigInteger;

public class Problem78 {

	public static BigInteger[] partition = new BigInteger[10000000];
	
	public static void main(String args[])
	{
		//Init
		partition[0] = BigInteger.ONE;
		
		int number = 0;
		final BigInteger MILLION = BigInteger.valueOf(1000000L);
		BigInteger partitions = BigInteger.ONE;
		
		/*
		while (number < 10) {
			number++;
			partitions = partitions(number);
			System.out.println(number + ": " + partitions);
		}
		/*/
		while (!partitions.mod(MILLION).equals(BigInteger.ZERO)) {
			number++;
			partitions = partitions(number);
		}
		System.out.println(number + ": " + partitions);
		//*/
	}
	
	static BigInteger partitions(int number) {
		if (number < 0)
			return BigInteger.ZERO;
		if (partition[number] != null)
			return partition[number];
		
		BigInteger sum = BigInteger.ZERO;
		int i = 1;
		int pentagonal = 1;
		while (pentagonal <= number) {
			if (i % 2 == 0)
				sum = sum.subtract(partitions(number-pentagonal));
			else
				sum = sum.add(partitions(number-pentagonal));
			
			i = -i;
			pentagonal = i*(3*i-1)/2;
			
			if (pentagonal > number) {
				break;
			}
			
			if (i % 2 == 0)
				sum = sum.subtract(partitions(number-pentagonal));
			else
				sum = sum.add(partitions(number-pentagonal));
			
			i = -i + 1;
			pentagonal = i*(3*i-1)/2;
		}
		
		partition[number] = sum;
		return sum;
	}
}
