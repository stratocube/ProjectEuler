package page2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Problem81 {

	final static int WIDTH = 80;
	final static int HEIGHT = 80;
	final static int[][] matrix = new int[HEIGHT][WIDTH];
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("../../resources/p081_matrix.txt"));
		String line;
		
		int i = 0, j = 0;
		while ((line = br.readLine()) != null) {
			String[] numbers = line.split(",");
			for (j = 0; j < WIDTH; j++) {
				matrix[i][j] = Integer.parseInt(numbers[j]);
			}
			i++;
		}
		
		for (i = 1; i < HEIGHT; i++) {
			matrix[i][0] += matrix[i-1][0];
		}

		for (j = 1; j < WIDTH; j++) {
			matrix[0][j] += matrix[0][j-1];
		}
	
		for (j = 1; j < WIDTH; j++) {
			for (i = 1; i < HEIGHT; i++) {
				matrix[i][j] += Math.min(matrix[i-1][j], matrix[i][j-1]);
			}
		}
		
		System.out.println(matrix[HEIGHT-1][WIDTH-1]);
	}
}
