package page2;

public class Problem86 {

	public static void main(String[] args) {
		long count = 0;
		int max = 1;
		while (count <= 1000000) {
			max++;
			for (int i = 1; i <= max; i++) {
				for (int j = i; j <= max; j++) {
					int k = max;
					int d1 = (i + j) * (i + j) + k * k;
					int d2 = (i + k) * (i + k) + j * j;
					int d3 = (j + k) * (j + k) + i * i;
					
					int shortestSquare = Math.min(Math.min(d1, d2), d3);
					int shortest = (int)Math.floor(Math.sqrt(shortestSquare));
					if (shortest * shortest == shortestSquare) {
						count++;
					}
				}
			}
		}
		
		System.out.println(max + ": " + count);
	}
}
