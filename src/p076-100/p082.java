package page2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Problem82 {

	final static int WIDTH = 80;
	final static int HEIGHT = 80;
	final static int[][] matrix = new int[HEIGHT][WIDTH];
	static int[] horizontalSum = new int[HEIGHT];
	//static int[] minSum = new int[HEIGHT];
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("resources/p082_matrix.txt"));
		String line;
		
		int i = 0, j = 0;
		while ((line = br.readLine()) != null) {
			String[] numbers = line.split(",");
			for (j = 0; j < WIDTH; j++) {
				matrix[i][j] = Integer.parseInt(numbers[j]);
			}
			i++;
		}
		
		int minPathSum = Integer.MAX_VALUE;
		int sum;
		int minSum;
		for (j = 1; j < WIDTH; j++) {
			for (i = 0; i < HEIGHT; i++) {
				sum = matrix[i][j];
				minSum = sum + matrix[i][j-1];
				
				if (i > 0 && minSum > (matrix[i-1][j] + matrix[i][j])) {
					minSum = matrix[i-1][j] + matrix[i][j];
				}
				for (int idown = i+1; idown < HEIGHT; idown++) {
					sum += matrix[idown][j];
					if (minSum > sum + matrix[idown][j-1]) {
						minSum = sum + matrix[idown][j-1];
					}
				}
				matrix[i][j] = minSum;
			}
		}
		
		for (i = 0; i < HEIGHT; i++) {
			if (minPathSum > matrix[i][WIDTH-1]) {
				minPathSum = matrix[i][WIDTH-1];
			}
		}
		
		System.out.println(minPathSum);
	}
}
