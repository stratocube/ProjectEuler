package page2;

public class Problem76 {

	public static int[][] partition = new int[101][101];
	
	public static void main(String args[])
	{
		System.out.println(numSums(100, 99));
	}
	
	static int numSums(int number, int highestPart)
	{
		if (number < 0 || highestPart <= 0) {
			return 0;
		}
		if (number == 0) {
			partition[number][highestPart] = 1;
			return 1;
		}
		if (partition[number][highestPart] != 0) {
			return partition[number][highestPart];
		}
		
		int sum = numSums(number - highestPart, highestPart) + numSums(number, highestPart - 1);
		
		partition[number][highestPart] = sum;
		return sum;
	}
}
