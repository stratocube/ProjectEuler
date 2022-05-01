package page1;

public class Problem40 {

	public static void main(String[] args) {
		StringBuilder constant = new StringBuilder();
		int i = 0;
		while (constant.length() <= 1000000) {
			constant.append(i);
			i++;
		}
		int product = 1;
		for (i = 0; i <= 6; i++) {
			product *= constant.charAt((int) Math.pow(10, i)) - '0';
		}
		System.out.println(product);
	}
}
