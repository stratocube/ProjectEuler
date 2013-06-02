package euler;

public class Problem33 {

	public static void main(String[] args)
	{
		int first, second;
		for (int d1 = 1; d1 <= 9; d1++) {
			for (int d2 = 1; d2 <= 9; d2++) {
				first = 10*d1 + d2;
				
				//d1 cancels
				for (int i = 1; i <= 9; i++) {
					if (i == d2 || d2 > i) {
						continue;
					}
					second = 10*d1 + i;
					if (first * i == second * d2) {
						System.out.println(first + "/" + second + " = " + d2 + "/" + i);
					}
					
					second = 10*i + d1;
					if (first * i == second * d2) {
						System.out.println(first + "/" + second + " = " + d2 + "/" + i);
					}
				}
				
				//d2 cancels
				for (int i = 1; i <= 9; i++) {
					if (i == d1 || d1 > i) {
						continue;
					}
					second = 10*d2 + i;
					if (first * i == second * d1) {
						System.out.println(first + "/" + second + " = " + d1 + "/" + i);
					}
					
					second = 10*i + d2;
					if (first * i == second * d1) {
						System.out.println(first + "/" + second + " = " + d1 + "/" + i);
					}
				}
			}
		}
	}
}
