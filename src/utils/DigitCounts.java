package utils;

public class DigitCounts {

	public static int[] digitCounts(long n) {
		int counts[] = new int[10];
		while (n > 0) {
			counts[(int)(n%10)]++;
			n /= 10;
		}
		return counts;
	}
}
