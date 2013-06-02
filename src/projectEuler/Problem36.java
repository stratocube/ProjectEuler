package euler;

public class Problem36 {

	public static void main(String[] args)
	{
		int sum = 0;
		for (int i = 1; i < 1000000; i++) {
			if (isPalindrome(i, 10) && isPalindrome(i, 2)) {
				sum += i;
				//System.out.println(i);
			}
		}
		System.out.println(sum);
	}
	
	static boolean isPalindrome(int num, int base) {
		StringBuilder representation = new StringBuilder();
		while (num != 0) {
			representation.insert(0, num % base);
			num /= base;
		}
		if (representation.toString().equals(
				representation.reverse().toString())) {
			//System.out.println(representation.toString());
			return true;
		}
		return false;
	}
}
