package tools;

public class Signature {

	public static int[] countDigits(long n) {
		int counts[] = new int[10];
		while (n > 0) {
			counts[(int)(n%10)]++;
			n /= 10;
		}
		return counts;
	}
}
