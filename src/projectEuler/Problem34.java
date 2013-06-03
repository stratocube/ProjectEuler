package projectEuler;

public class Problem34 {

	public static void main(String[] args) {
		//10^7 > 7*9!
		for (int i = 3; i < 10000000; i++) {
			int digit = i;
			int sum = 0;
			while (digit != 0) {
				sum += factorial(digit % 10);
				if (sum > i) {
					break;
				}
				digit /= 10;
			}
			
			if (sum == i) {
				System.out.println(i);
			}
		}
	}
	
	private static int factorial(int num) {
		int product = 1;
		while (num > 1) {
			product *= num;
			num--;
		}
		return product;
	}
}
