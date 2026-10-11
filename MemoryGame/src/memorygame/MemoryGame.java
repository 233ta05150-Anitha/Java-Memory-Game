package memorygame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class MemoryGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<String> cards = new ArrayList<>();
		//create 4 pairs of cards
		cards.add("A");
		cards.add("A");
		cards.add("B");
		cards.add("B");
		cards.add("C");
		cards.add("C");
		cards.add("D");
		cards.add("D");
		//shuffle cards randomly
		Collections.shuffle(cards);
		
		//create the game board
		String[] board = new String[cards.size()];
		//hide all cards initially
		Arrays.fill(board," ");
		
		boolean[] flipped = new boolean[cards.size()];
		boolean[] matched = new boolean[cards.size()];
		int pairsFound = 0;
		
		System.out.println("Welcome to the Memory Game!");
		printBoard(board);
		while(pairsFound < 4) {
			

		
		int index;
		while(true) {
			System.out.println("Enter the index of the card to flip (0-7):");
			index = scanner.nextInt();
			
			if(index < 0 || index >= cards.size()) {
				System.out.println("Invalid index! Enter 0 to 7.");
			} else if(matched[index]) {
				System.out.println("This card is already matched! Choose another.");
			}else {
				break;
			}
		}
		//reveal the selected card
		board[index] = cards.get(index);
		flipped[index] = true;
		printBoard(board);
		
		int secondIndex;
		
		
		while(true) {
			System.out.println("Enter the index of the second card (0-7):");
			secondIndex = scanner.nextInt();
			if(secondIndex < 0 || secondIndex >= cards.size()) {
				System.out.println("Invalid index! Enter 0 to 7.");
			} else if(secondIndex == index) {
				System.out.println("You already selected that card! Choose another.");
			}else if(matched[secondIndex]) {
					System.out.println("This card is already matched! Choose another.");
			} else {
				break;
			}
		}
		//reveal the second card
		board[secondIndex] = cards.get(secondIndex);
		flipped[secondIndex] = true;
		printBoard(board);
		if(cards.get(index).equals(cards.get(secondIndex))) {
			System.out.println("You found a pair!");
			matched[index] = true;
			matched[secondIndex] = true;
			pairsFound++;
		}else {
			System.out.println("Sorry, those cards don't match.");
			
			//hide both unmatched cards
			board[index] = " ";
			board[secondIndex] = " ";
			
			flipped[index] = false;
			flipped[secondIndex] = false;
		}
		printBoard(board);
	}
	System.out.println("Congratulations, you won!");
		scanner.close();

	}
	public static void printBoard(String[] board) {
		for(int i=0;i<board.length;i++) {
			System.out.print("| " + i + ": " + board[i] + " ");
		}
		System.out.println("|");
	}
	

}
