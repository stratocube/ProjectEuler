package page1;

import java.util.Calendar;

public class Problem19 {

	public static void main(String[] args) {

		Calendar date = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		date.set(1901, Calendar.JANUARY, 1);
		end.set(2000, Calendar.DECEMBER, 31);

		System.out.println(date.toString());
		System.out.println(end.toString());

		int count = 0;
		while (date.before(end)) {
			if (date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				count++;
			}
			date.add(Calendar.MONTH, 1);
		}
		System.out.println(count);
	}
}
