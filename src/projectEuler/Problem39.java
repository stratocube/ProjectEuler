package projectEuler;

public class Problem39 {

	public static void main(String[] args) {
		int maxCount = 0;
		int maxPerimeter = 0;
		for (int p = 3; p <= 1000; p++) {
			int count = 0;
			for (int a = 1; a <= p/3; a++) {
				for (int b = a; b <= (p-a)/2; b++) {
					int c = p - a - b;
					if (a*a + b*b == c*c) {
						count++;
						//System.out.println(a + ", " + b + ", " + c);
					}
				}
			}
			
			if (count > maxCount) {
				maxCount = count;
				maxPerimeter = p;
			}
			if (count != 0) {
				System.out.println("Perimeter " + p + " has " + count);
			}
		}
		System.out.println("Perimeter " + maxPerimeter + " has max " + maxCount);
	}
}
