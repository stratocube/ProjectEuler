package page1;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem24 {

	public static void main(String[] args) {
		ArrayList<Character> permGroup = new ArrayList<Character>(
				Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

		permute(permGroup, new ArrayList<Character>(), 1000000);
	}

	public static int permute(ArrayList<Character> list,
			ArrayList<Character> selected, int times) {
		if (list.size() == 0) {
			if (times == 1) {
				System.out.println(selected.toString().replaceAll("[, \\[\\]]",
						""));
				return -1;
			}
			return times - 1;
		}

		for (int selection = 0; selection < list.size(); selection++) {
			selected.add(list.remove(selection));

			times = permute(list, selected, times);
			if (times == -1) {
				return -1;
			}

			list.add(selection, selected.get(selected.size() - 1));
			selected.remove(selected.size() - 1);
		}

		return times;
	}
}
