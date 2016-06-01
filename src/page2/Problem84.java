package page2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem84 {

	final static List<String> board = Arrays.asList("GO", "A1", "CC1", "A2", "T1", "R1", "B1", "CH1", "B2", "B3",
			"JAIL", "C1", "U1", "C2", "C3", "R2", "D1", "CC2", "D2", "D3", "FP", "E1", "CH2", "E2", "E3", "R3", "F1",
			"F2", "U2", "F3", "G2J", "G1", "G2", "CC3", "G3", "R4", "CH3", "H1", "T2", "H2");
	final static List<String> chanceGoToFixed = Arrays.asList("GO", "JAIL", "C1", "E3", "H2", "R1");

	static Map<String, Double> tempWeights = new HashMap<>();
	static {
		tempWeights = new HashMap<>();
		for (String space : board) {
			tempWeights.put(space, 0.0);
		}
	}
	static Map<String, Double> boardProbabilities;
	static {
		boardProbabilities = new HashMap<>();
		for (String space : board) {
			boardProbabilities.put(space, 2.5);
		}
	}

	final static int DIE_MAX = 6;
	static int[] rollCounts = new int[DIE_MAX + DIE_MAX + 1];
	static double totalProb;

	public static void main(String[] args) {
		for (int i = 1; i <= DIE_MAX; i++) {
			for (int j = 1; j <= DIE_MAX; j++) {
				rollCounts[i + j]++;
			}
		}

		for (int iter = 0; iter < 100; iter++) {

			// All possible movements
			for (int startIndex = 0; startIndex < board.size(); startIndex++) {
				for (int rollIndex = 2; rollIndex < rollCounts.length; rollIndex++) {
					double rollProb = (double) rollCounts[rollIndex] / (DIE_MAX * DIE_MAX);
					double spaceProb = boardProbabilities.get(board.get(startIndex));

					int endIndex = (startIndex + rollIndex) % board.size();
					move(endIndex, spaceProb * rollProb);
				}
			}

			totalProb = 0;
			for (double prob : tempWeights.values()) {
				totalProb += prob;
			}

			// 3-double rule
			for (String space : tempWeights.keySet()) {
				tempWeights.put(space, tempWeights.get(space) * (1 - 1.0 / (DIE_MAX * DIE_MAX * DIE_MAX)));
			}
			tempWeights.put("JAIL", tempWeights.get("JAIL") + (totalProb * 1.0 / (DIE_MAX * DIE_MAX * DIE_MAX)));

			// Normalize
			for (String space : tempWeights.keySet()) {
				tempWeights.put(space, 100 * tempWeights.get(space) / totalProb);
			}
			boardProbabilities = new HashMap<>(tempWeights);
		}

		for (String space : boardProbabilities.keySet()) {
			System.out.println(space + ": " + boardProbabilities.get(space));
		}
	}

	public static void move(int index, double probability) {
		double newProbability;
		if (board.get(index).startsWith("CC")) {
			newProbability = tempWeights.get("GO") + probability * 1 / 16.0;
			tempWeights.put("GO", newProbability);

			newProbability = tempWeights.get("JAIL") + probability * 1 / 16.0;
			tempWeights.put("JAIL", newProbability);

			String otherChest = board.get(index);
			newProbability = tempWeights.get(otherChest) + probability * 14 / 16.0;
			tempWeights.put(otherChest, newProbability);

		} else if (board.get(index).startsWith("CH")) {
			for (String goTo : chanceGoToFixed) {
				newProbability = tempWeights.get(goTo) + probability * 1 / 16.0;
				tempWeights.put(goTo, newProbability);
			}

			int nextRailway = index;
			while (!board.get(nextRailway).startsWith("R")) {
				nextRailway = (nextRailway + 1) % board.size();
			}
			String railway = board.get(nextRailway);
			newProbability = tempWeights.get(railway) + probability * 2 / 16.0;
			tempWeights.put(railway, newProbability);

			int nextUtil = index;
			while (!board.get(nextUtil).startsWith("U")) {
				nextUtil = (nextUtil + 1) % board.size();
			}
			String util = board.get(nextUtil);
			newProbability = tempWeights.get(util) + probability * 1 / 16.0;
			tempWeights.put(util, newProbability);

			int backThree = (index - 3) % board.size();
			move(backThree, probability * 1 / 16.0);

			String otherChance = board.get(index);
			newProbability = tempWeights.get(otherChance) + probability * 6 / 16.0;
			tempWeights.put(otherChance, newProbability);

		} else if (board.get(index).equals("G2J")) {
			index = board.indexOf("JAIL");
			newProbability = tempWeights.get("JAIL") + probability;
			tempWeights.put("JAIL", newProbability);

		} else {
			String space = board.get(index);
			newProbability = tempWeights.get(space) + probability;
			tempWeights.put(space, newProbability);
		}
	}
}