package euler;

public class Problem28 {

	static final int N = 1001;
	public static void main(String[] args)
	{
		int sum = 1, numbers = 1, jump = 2;
		for (int i = 0; i < (N-1)/2; i++) {
			for (int j = 0; j < 4; j++) {
				numbers += jump;
				sum += numbers;
				//System.out.println(numbers);

			}
			jump += 2;
		}
		
		System.out.println(sum);
	}
}
