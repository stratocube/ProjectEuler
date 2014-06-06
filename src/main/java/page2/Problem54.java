package page2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem54 {
	public static void main(String[] args) {
		Scanner reader = null;
		try {
			reader = new Scanner(new File("resources/poker.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		int count = 0;
		while (reader.hasNextLine()) {
			String game = reader.nextLine();
			String[] cards = game.split(" ");
			List<Card> cardList1 = new ArrayList<Card>();
			List<Card> cardList2 = new ArrayList<Card>();
			for (int i = 0; i < 5; i++) {
				cardList1.add(new Card(cards[i]));
				cardList2.add(new Card(cards[i+5]));
			}
			
			Hand player1 = new Hand(cardList1);
			Hand player2 = new Hand(cardList2);
			int rank1 = player1.getRank();
			int rank2 = player2.getRank();
			
			if (rank1 > rank2) {
				count++;
			}
			else if (rank1 == rank2) {
				if (player1.highestRank > player2.highestRank) {
					count++;
				}
				else if (player1.highestRank == player2.highestRank) {
					int nextHighest1 = 1;
					int nextHighest2 = 1;
					while (nextHighest1 == nextHighest2 && nextHighest1 > 0) {
						nextHighest1 = player1.getNextHighest();
						nextHighest2 = player2.getNextHighest();
					}
					
					if (nextHighest1 > nextHighest2) {
						count++;
					}
					else {
						//Draw or Player2 wins
					}
				}
				else {
					//Player2 wins
				}
			}
			else {
				//Player2 wins
			}
		}
		
		System.out.println(count);
	}
}

enum Suit { Spade, Diamond, Heart, Club }

class Card implements Comparable<Card> {
	int value;
	Suit suit;
	
	public Card(String description) {
		if (description.length() == 2) {
			switch(description.charAt(0)) {
			case '2': case '3': case '4': case '5':
			case '6': case '7': case '8': case '9':
				value = description.charAt(0) - '0';
				break;
			case 'T': value = 10; break;
			case 'J': value = 11; break;
			case 'Q': value = 12; break;
			case 'K': value = 13; break;
			case 'A': value = 14; break;
			}
			switch(description.charAt(1)) {
			case 'S': suit = Suit.Spade; break;
			case 'D': suit = Suit.Diamond; break;
			case 'H': suit = Suit.Heart; break;
			case 'C': suit = Suit.Club; break;
			}
		}
	}

	@Override
	public int compareTo(Card o) {
		return (int) Math.signum(this.value - o.value);
	}
}

class Hand {
	List<Card> hand;
	int highestRank;
	int index;
	
	public Hand(List<Card> list) {
		this.hand = list;
		Collections.sort(hand);
		index = hand.size()-1;
	}
	
	public int getRank() {
		List<Integer> values = new ArrayList<Integer>();
		List<Suit> suits = new ArrayList<Suit>();
		for (Card c : hand) {
			values.add(c.value);
			suits.add(c.suit);
		}
		
		boolean sameSuit = true;
		for (Suit s : suits) {
			if (s != suits.get(0)) {
				sameSuit = false;
				break;
			}
		}
		
		//Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
		if (values.containsAll(Arrays.asList(10, 11, 12, 13, 14)) && sameSuit) {
			highestRank = 14;
			return 9;
		}
		
		boolean consecutive = true;
		int previous = values.get(0);
		for (int i = 1; i < values.size(); i++) {
			if (values.get(i) != previous + 1) {
				consecutive = false;
			}
			previous = values.get(i);
		}
		
		//Straight Flush: All cards are consecutive values of same suit.
		if (sameSuit && consecutive) {
			highestRank = values.get(values.size()-1);
			return 8;
		}
		
		List<Integer> groupings = new ArrayList<Integer>(15);
		for (int i = 0; i <= 14; i++) {
			groupings.add(0);
		}
		for (int value : values) {
			groupings.set(value, groupings.get(value)+1);
		}
		
		//Four of a Kind: Four cards of the same value.
		if (groupings.contains(4)) {
			highestRank = groupings.indexOf(4);
			return 7;
		}
		
		//Full House: Three of a kind and a pair.
		if (groupings.contains(3) && groupings.contains(2)) {
			highestRank = values.get(values.size()-1);
			return 6;
		}
		
		//Flush: All cards of the same suit.
		if (sameSuit) {
			highestRank = values.get(values.size()-1);
			return 5;
		}
		
		//Straight: All cards are consecutive values.
		if (consecutive) {
			highestRank = values.get(values.size()-1);
			return 4;
		}
		
		//Three of a Kind: Three cards of the same value.
		if (groupings.contains(3)) {
			highestRank = groupings.indexOf(3);
			return 3;
		}
		
		//Two Pairs: Two different pairs.
		if (groupings.contains(2) && groupings.indexOf(2) != groupings.lastIndexOf(2)) {
			highestRank = Math.max(groupings.indexOf(2), groupings.lastIndexOf(2));
			return 2;
		}
		
		//One Pair: Two cards of the same value.
		if (groupings.contains(2)) {
			highestRank = groupings.indexOf(2);
			return 1;
		}
		
		//High Card: Highest value card.
		highestRank = values.get(values.size()-1);
		return 0;
	}
	
	public int getNextHighest() {
		if (index < 0) {
			return -1;
		}
		
		int nextValue = hand.get(index).value;
		index--;
		return nextValue;
	}
}
