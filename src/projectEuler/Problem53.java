package projectEuler;

public class Problem53 {

	public static void main(String[] args) {
		
		long sum = 0;
		for (int n = 1; n <= 100; n++) {
			long r = 0;
			while (combination(n, r) <= 1000000 && r <= n/2) {
				r++;
			}
			if (r <= n/2) {
				sum += n+1 - 2*r;
			}
		}
		
		System.out.println(sum);
	}
	
	private static long combination(long n, long r) {
		
		double product = 1;
		for (long i = r; i >= 1; i--) {
			product *= n-i+1;
			product /= i;
		}
		
		return Math.round(product);
	}
}
