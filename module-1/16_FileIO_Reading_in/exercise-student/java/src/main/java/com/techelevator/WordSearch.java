package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		String filePath = "";
		String searchTerm = "";
		String caseSensitive = "";
		File searchFile = new File(filePath);
		// Prompt User for file path
		// Validate File is a file and that it exists
		while (searchFile.isFile() == false || searchFile.exists() == false) {
			System.out.println("What is the fully qualified name of the file that should be searched? ");
			filePath = userInput.nextLine();
			// Create File reference to path,
			searchFile = new File(filePath);
		}
		// Prompt User for search word
		System.out.println("What is the search word you are looking for? ");
		searchTerm = userInput.nextLine();
		// Prompt User for case sensitivity
		System.out.println("Should the search be case sensitive? (Y/N) ");
		caseSensitive = userInput.nextLine();
		// Use Scanner to check if each line of File .contains() search word
		String searchResults = "";
		if (caseSensitive.equals("N")) {
			try (Scanner fileScanner = new Scanner(searchFile)) {
				
				Integer lineCounter = 0;
				while (fileScanner.hasNextLine()) {
					lineCounter++;
					String lineToSearch = fileScanner.nextLine();
					if (lineToSearch.toLowerCase().contains(searchTerm.toLowerCase())) {
						searchResults += (lineCounter.toString() + ") " + lineToSearch + "\n");
					}
				}
			} catch (FileNotFoundException fnfEx) {
				System.out.println("This should not have happened, get help!");
			} finally {
				System.out.println(searchResults.trim());
			}
		}
		if (caseSensitive.equals("Y")) {
			try (Scanner fileScanner = new Scanner(searchFile)) {
				Integer lineCounter = 0;
				while (fileScanner.hasNextLine()) {
					lineCounter++;
					String lineToSearch = fileScanner.nextLine();
					if (lineToSearch.contains(searchTerm)) {
						searchResults += (lineCounter.toString() + ") " + lineToSearch + "\n");
					}
				}
			} catch (FileNotFoundException fnfEx) {
				System.out.println("This should not have happened, get help!");
			} finally {
				System.out.println(searchResults.trim());
			}
		}
	}
}