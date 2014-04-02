package page2;

public class Problem71 {

	public static void main(String[] args) {
		
		int d = 1;
		int n;
		int maxn = 0;
		int maxd = 1;
		
		while (d <= 1000000) {
			if (d % 7 == 0) {
				d++;
				continue;
			}
			
			// n/d < 3/7
			n = 3*d / 7;
			
			// maxn/maxd < n/d
			if (maxn*d < n*maxd) {
				maxn = n;
				maxd = d;
			}
			
			d++;
		}
		
		System.out.println(maxn + "/" + maxd);
	}
}
