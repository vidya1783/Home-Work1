package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class FizzWriter {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		String path = "";
		//Prompt user for value of the destination file
		System.out.println("What is the destination file?");
		path = userInput.nextLine();
		//Instantiate the file object
		File target = new File(path);
		//Validate the information given
		//If the file already exists, it must be overwritten.
		// If the user enters an invalid destination file, the program indicates this and exits.
		if(target.exists()) {
			System.out.println(target.getName() + " already exists and will be overwritten.");
		}
		String result = "";
		try(PrintWriter fileWriter = new PrintWriter(target)) {
			for (int i = 1; i <= 300; i++) {
				if(i % 5 == 0 && i % 3 == 0) {
					result = "FizzBuzz";
				} else if (i % 3 == 0 || Integer.toString(i).contains("3")) {
					result = "Fizz";
				} else if (i % 5 == 0 || Integer.toString(i).contains("5")) {
					result = "Buzz";
				} else {
					result = Integer.toString(i);
				}
				fileWriter.println(result);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
}