package WebSearchEngine;

import java.util.ArrayList;
import java.util.Scanner;
import Utilities.TST;
import java.io.File;

public class AutoFill {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Utilities.log("Enter word for suggestions (We use history.txt for this feature)");
		String word = input.nextLine();
		int top = 0;

		ArrayList<String> keys = new ArrayList<String>();

		// contains the history of searches by the user (for suggestions)
		TST<Integer> history = new TST<Integer>();
		try {
			File myObj = new File("history.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				keys.add(data.toLowerCase());
				history.put(data.toLowerCase(), top);
				top++;
			}
			myReader.close();
		} catch (Exception e) {
			Utilities.log("Error: " + e.getMessage());
		}
		history.printSimilarWords(word.toLowerCase());
	}

}