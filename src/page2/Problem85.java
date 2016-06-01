package page2;

public class Problem85 {

	static long[][] rectangleCounts = new long[60][5000];
	
	public static void main(String[] args)
	{
		long closestCount = 0;
		int closestWidth = 0;
		int closestHeight = 0;
		rectangleCounts[1][1] = 1;
		
		int i = 1;
		while (rectangleCounts[i][i] < 2000000) {
			int j = i;
			
			while (rectangleCounts[i][j] < 2000000) {
				j++;
				rectangleCounts[i][j] = rectangleCounts[i][j-1] + i*j*(i+1)/2;
			}
			if (Math.abs(rectangleCounts[i][j] - 2000000) <= Math.abs(closestCount - 2000000)) {
				closestCount = rectangleCounts[i][j];
				closestHeight = i;
				closestWidth = j;
			}
			if (Math.abs(rectangleCounts[i][j-1] - 2000000) <= Math.abs(closestCount - 2000000)) {
				closestCount = rectangleCounts[i][j-1];
				closestHeight = i;
				closestWidth = j-1;
			}
			
			i++;
			rectangleCounts[i][i] = rectangleCounts[i-1][i] + i*i*(i+1)/2;
		}
		if (Math.abs(rectangleCounts[i][i] - 2000000) <= Math.abs(closestCount - 2000000)) {
			closestCount = rectangleCounts[i][i];
			closestHeight = i;
			closestWidth = i;
		}
		
		System.out.println(closestHeight + "x" + closestWidth + "=" + (closestHeight*closestWidth) + " - " + closestCount + " solutions");
	}
}
