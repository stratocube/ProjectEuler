package page2;


public class Problem73 {

	public static void main(String[] args) {
		
		int n1 = 1, d1 = 3, n2 = 1, d2 = 2;
		int lowNumerator, highNumerator;
		long count = 0;
		
		for (int d = 2; d <= 12000; d++) {
			lowNumerator = (n1*d / d1) + 1;
			highNumerator = (n2*d - 1) / d2;
			
			for (int i = lowNumerator; i <= highNumerator; i++) {
				if (gcd(d, i) == 1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	public static int gcd(int a, int b) {
	   if (b==0) return a;
	   return gcd(b,a%b);
	}
}
