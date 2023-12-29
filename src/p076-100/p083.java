package page2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem83 {

	final static int WIDTH = 80;
	final static int HEIGHT = 80;
	final static int[][] matrix = new int[HEIGHT][WIDTH];
	static long[][] minPathValue = new long[HEIGHT][WIDTH];
	static Queue<Point> frontier;
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("../../resources/p083_matrix.txt"));
		String line;
		
		int i = 0, j = 0;
		while ((line = br.readLine()) != null) {
			String[] numbers = line.split(",");
			for (j = 0; j < WIDTH; j++) {
				matrix[i][j] = Integer.parseInt(numbers[j]);
			}
			i++;
		}
		
		for (i = 0; i < HEIGHT; i++) {
			for (j = 0; j < WIDTH; j++) {
				minPathValue[i][j] = Integer.MAX_VALUE;
			}
		}
		minPathValue[0][0] = matrix[0][0];
		
		frontier = new LinkedList<>();
		frontier.add(new Point(1,0));
		frontier.add(new Point(0,1));
		boolean changed;
		while (!frontier.isEmpty()) {
			Point expandLoc = frontier.remove();
			i = expandLoc.y;
			j = expandLoc.x;
			changed = false;
			
			if (i > 0) {
				if (minPathValue[i][j] > minPathValue[i-1][j] + matrix[i][j]) {
					minPathValue[i][j] = minPathValue[i-1][j] + matrix[i][j];
					changed = true;
				}
			}
			if (i < HEIGHT-1) {
				if (minPathValue[i][j] > minPathValue[i+1][j] + matrix[i][j]) {
					minPathValue[i][j] = minPathValue[i+1][j] + matrix[i][j];
					changed = true;
				}
			}
			if (j > 0) {
				if (minPathValue[i][j] > minPathValue[i][j-1] + matrix[i][j]) {
					minPathValue[i][j] = minPathValue[i][j-1] + matrix[i][j];
					changed = true;
				}
			}
			if (j < WIDTH-1) {
				if (minPathValue[i][j] > minPathValue[i][j+1] + matrix[i][j]) {
					minPathValue[i][j] = minPathValue[i][j+1] + matrix[i][j];
					changed = true;
				}
			}
			
			if (changed) {
				if (i > 0) {
					frontier.add(new Point(i-1,j));
				}
				if (i < HEIGHT-1) {
					frontier.add(new Point(i+1,j));
				}
				if (j > 0) {
					frontier.add(new Point(i,j-1));
				}
				if (j < WIDTH-1) {
					frontier.add(new Point(i,j+1));
				}
				frontier.add(new Point(i,j));
			}
		}
		
		System.out.println(minPathValue[HEIGHT-1][WIDTH-1]);
	}
}
